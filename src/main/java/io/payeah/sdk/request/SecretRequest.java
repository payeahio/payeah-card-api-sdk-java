package io.payeah.sdk.request;

import lombok.Data;

/**
 * SecretRequest
 * email : david@payeah.io
 * created : 2023/11/8
 * description : secret request
 **/
@Data
public class SecretRequest {

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