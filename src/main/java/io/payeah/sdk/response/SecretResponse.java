package io.payeah.sdk.response;

import com.alibaba.cola.dto.Response;
import lombok.Data;

/**
 * SecretResponse
 * email : david@payeah.io
 * created : 2023/11/8
 * description : secret response
 **/
@Data
public class SecretResponse extends Response {
    /**
     * [Mandatory] Timestamp
     * Long type
     */
    private Long timestamp;

    /**
     * [Mandatory] Key
     * String type
     */
    private String key;

    /**
     * [Mandatory] Sign
     * String type
     */
    private String sign;

    /**
     * [Mandatory] Data
     * String type
     */
    private String data;
}