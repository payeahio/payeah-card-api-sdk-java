package io.payeah.sdk.response;

import lombok.Data;

/**
 * OrderMofifyCmdCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : order modify command data info
 **/
@Data
public class OrderMofifyCmdCO {
    /**
     * [Mandatory] Client Order ID as assigned by the client
     * String type
     * Unique order number
     */
    private String clientOrderId;

    /**
     * [Mandatory] Card ID as assigned by the service system
     * String type
     * Unique card ID
     */
    private String cardId;
}