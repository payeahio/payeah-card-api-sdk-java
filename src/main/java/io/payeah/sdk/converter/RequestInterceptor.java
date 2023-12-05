package io.payeah.sdk.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.payeah.sdk.config.PayeahCardConfig;
import io.payeah.sdk.request.SecretRequest;
import io.payeah.sdk.utils.AesUtil;
import io.payeah.sdk.utils.JsonUtil;
import io.payeah.sdk.utils.RsaUtil;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RequestInterceptor implements Interceptor {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final String API_KEY_HEADER_NAME = "X-API-KEY";
    private static final ObjectMapper mapper = JsonUtil.getObjectMapper();

    private final ObjectWriter objectWriter;
    private final String apiKey;
    private final String payeahRsaPublicKey;
    private final String rsaPrivateKey;


    public static RequestInterceptor create(PayeahCardConfig config) {
        return new RequestInterceptor(config);
    }

    private RequestInterceptor(PayeahCardConfig config) {
        this.objectWriter = mapper.writerFor(SecretRequest.class);
        this.apiKey = config.getApiKey();
        this.payeahRsaPublicKey = config.getPayeahRsaPublicKey();
        this.rsaPrivateKey = config.getRsaPrivateKey();
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        if ("POST".equals(request.method())) {
            try {
                // Use AES to encrypt request data
                Buffer buffer = new Buffer();
                request.body().writeTo(buffer);
                final String requestJson = buffer.readUtf8();
                byte[] aesKey = AesUtil.generateAESKey();
                byte[] ivKey = AesUtil.generateIvKey();

                String aesEncryptResult = "";
                if (StringUtils.isNotEmpty(requestJson)) {
                    aesEncryptResult = AesUtil.encrypt(requestJson, aesKey, ivKey);
                }
                // Use Payeah RSA public key to encrypt request's aesKey and aesIv
                byte[] sourceKey = Arrays.copyOf(aesKey, aesKey.length + ivKey.length);
                System.arraycopy(ivKey, 0, sourceKey, aesKey.length, ivKey.length);
                String rsaEncryptResult = RsaUtil.encrypt(sourceKey, payeahRsaPublicKey);

                // Create response map
                SecretRequest secretRequest = new SecretRequest();
                secretRequest.setKey(rsaEncryptResult);
                secretRequest.setData(aesEncryptResult);
                secretRequest.setTimestamp(System.currentTimeMillis());
                Map<String, String> requestData = new TreeMap<>();
                requestData.put("timestamp", secretRequest.getTimestamp().toString());
                requestData.put("key", rsaEncryptResult);
                if (StringUtils.isNotEmpty(requestJson)) {
                    requestData.put("data", aesEncryptResult);
                }
                String signContent = requestData.entrySet().stream()
                        .map(entry -> entry.getKey() + "=" + entry.getValue())
                        .collect(Collectors.joining("&"));
                String rsaSig = RsaUtil.sign(signContent, rsaPrivateKey);
                secretRequest.setSign(rsaSig);

                byte[] bytes = this.objectWriter.writeValueAsBytes(secretRequest);
                return chain.proceed(request.newBuilder().header(API_KEY_HEADER_NAME,apiKey).post(RequestBody.create(bytes, MEDIA_TYPE)).build());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return chain.proceed(request);
    }
}
