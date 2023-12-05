package io.payeah.sdk.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.payeah.sdk.request.SecretRequest;
import io.payeah.sdk.utils.AesUtil;
import io.payeah.sdk.utils.JsonUtil;
import io.payeah.sdk.utils.RsaUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Webhook decryption and data conversion converter
 */
public class WebhookConverter {
    /**
     * payeahWebHookRsaPublicKey
     */
    private final String payeahWebHookRsaPublicKey;

    /**
     * webHookRsaPrivateKey
     * Own webHookRsaPrivateKey
     */
    private final String webHookRsaPrivateKey;
    private final ObjectMapper mapper = JsonUtil.getObjectMapper();

    /**
     * WebhookConverter
     *
     * @param payeahWebHookRsaPublicKey
     * @param webHookRsaPrivateKey
     */
    public WebhookConverter(String payeahWebHookRsaPublicKey, String webHookRsaPrivateKey) {
        this.payeahWebHookRsaPublicKey = payeahWebHookRsaPublicKey;
        this.webHookRsaPrivateKey = webHookRsaPrivateKey;
    }

    /**
     * convert
     *
     * @param secretRequest
     * @return WebhookParam
     */
    public WebhookParam convert(SecretRequest secretRequest) throws Exception {
        // Verify sign
        Map<String, String> sigMap = new TreeMap<>();
        sigMap.put("timestamp", secretRequest.getTimestamp().toString());
        sigMap.put("key", secretRequest.getKey());
        sigMap.put("data", secretRequest.getData());
        String signContent = sigMap.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((a, b) -> a + "&" + b).orElse("");
        boolean checkResult = RsaUtil.verifySign(signContent, secretRequest.getSign(), payeahWebHookRsaPublicKey);
        if (!checkResult) {
            throw new RuntimeException("request signature verification failed");
        }


        // Use your RSA private key to decrypt response's aesKey and aesIv
        byte[] aesSaltDecrypt = RsaUtil.decrypt(secretRequest.getKey(), webHookRsaPrivateKey);
        byte[] aesKey = Arrays.copyOfRange(aesSaltDecrypt, 0, 32);
        byte[] iv = Arrays.copyOfRange(aesSaltDecrypt, 32, aesSaltDecrypt.length);

        // Use AES to decrypt bizContent
        String dataDecrypt = AesUtil.decrypt(secretRequest.getData(), aesKey, iv);
        //Data conversion
        WebhookParam webhookParam = mapper.readValue(dataDecrypt, WebhookParam.class);
        String webHookBizContentJsonString = webhookParam.getData().toString();
        switch (WebhookEventTypeEnum.valueOf(webhookParam.getType())) {
            case type_card_operate:
                webhookParam.setData(mapper.readValue(webHookBizContentJsonString, CardOperateHookParam.class));
                break;
            case card_transaction:
                webhookParam.setData(mapper.readValue(webHookBizContentJsonString, CardTransactionHookParam.class));
                break;
            case card_3ds_otp:
                webhookParam.setData(mapper.readValue(webHookBizContentJsonString, Card3dsOtpHookParam.class));
                break;
            case trade_fee:
                webhookParam.setData(mapper.readValue(webHookBizContentJsonString, TradeFeeHookParam.class));
                break;
            default:
                throw new RuntimeException("unknown webhook type");
        }
        return webhookParam;
    }
}
