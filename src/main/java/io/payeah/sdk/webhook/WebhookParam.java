package io.payeah.sdk.webhook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WebhookParam
 * email : david@payeah.io
 * created : 2023/11/20
 * description : webhook request body
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebhookParam {
    /**
     * [Mandatory] Event Type
     */
    private String type;

    /**
     * [Mandatory] Event Data
     */
    private Object data;
}