package io.payeah.sdk.converter;

import com.alibaba.cola.dto.SingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import io.payeah.sdk.exception.PayeahException;
import io.payeah.sdk.response.SecretResponse;
import io.payeah.sdk.utils.AesUtil;
import io.payeah.sdk.utils.JsonUtil;
import io.payeah.sdk.utils.RsaUtil;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Response Body Converter
 *
 */
public class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final ObjectReader reader;

    private final String payeahRsaPublicKey;
    private final String rsaPrivateKey;

    ResponseBodyConverter(ObjectReader reader,
                          String payeahRsaPublicKey, String rsaPrivateKey) {
        this.reader = reader;
        this.payeahRsaPublicKey = payeahRsaPublicKey;
        this.rsaPrivateKey = rsaPrivateKey;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        // Decode json data into ApiResult Object
        ObjectMapper mapper = JsonUtil.getObjectMapper();
        SecretResponse secretRespBody = mapper.readValue(value.charStream(), SecretResponse.class);
        if (!secretRespBody.isSuccess()) {
            throw new PayeahException(secretRespBody.getErrCode(), secretRespBody.getErrMessage());
        }
        try {
            // Verify sign
            Map<String, String> sigMap = new TreeMap<>();
            sigMap.put("timestamp", secretRespBody.getTimestamp().toString());
            sigMap.put("key", secretRespBody.getKey());
            sigMap.put("data", secretRespBody.getData());
            sigMap.put("success", Boolean.valueOf(secretRespBody.isSuccess()).toString());
            String signContent = sigMap.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .reduce((a, b) -> a + "&" + b).orElse("");
            boolean checkResult = RsaUtil.verifySign(signContent, secretRespBody.getSign(), payeahRsaPublicKey);
            if (!checkResult) {
                throw new RuntimeException("response signature verification failed");
            }


            // Use your RSA private key to decrypt response's aesKey and aesIv
            byte[] aesSaltDecrypt = RsaUtil.decrypt(secretRespBody.getKey(), rsaPrivateKey);
            byte[] aesKey = Arrays.copyOfRange(aesSaltDecrypt, 0, 32);
            byte[] iv = Arrays.copyOfRange(aesSaltDecrypt, 32, aesSaltDecrypt.length);

            // Use AES to decrypt bizContent
            String dataDecrypt = AesUtil.decrypt(secretRespBody.getData(), aesKey, iv);
            return reader.readValue(dataDecrypt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}