package io.payeah.sdk.response;

import lombok.Data;

/**
 * OrderCmdCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : order command data info
 **/
@Data
public class OrderCmdCO {
    /**
     * [Mandatory] Client Order ID as assigned by the client
     * String type
     * Unique order number
     */
    private String clientOrderId;

    /**
     * [Mandatory] Order ID as assigned by the service system
     * String type
     * Unique order number
     */
    private String orderId;
}