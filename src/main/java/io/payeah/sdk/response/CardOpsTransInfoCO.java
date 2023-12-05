package io.payeah.sdk.response;

import lombok.Data;

import java.util.Date;

/**
 * CardOpsTransInfoCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : card ops trans info
 **/
@Data
public class CardOpsTransInfoCO {
    /**
     * [Mandatory] Order ID as assigned by the service system
     * String type
     * Unique order number
     */
    private String orderId;

    /**
     * [Mandatory] Card ID as assigned by the service system
     * String type
     * Unique card ID
     */
    private String cardId;

    /**
     * [Mandatory] Card Type
     * 0-Regular card 1-Shared sub-card
     * Double type
     */
    private Double cardType;

    /**
     * [Mandatory] Client Order ID as assigned by the client
     * String type
     * A combination of case-sensitive alphanumerics, all numbers, or all letters of up to 64 characters.
     */
    private String clientOrderId;

    /**
     * [Mandatory] Order Type
     * Integer type
     * 0: Card Application
     * 1: Recharge
     * 3: Card Cancellation
     * 4: Refund
     */
    private Integer opType;

    /**
     * [Mandatory] Order Status
     * Integer type
     * 0: Pending
     * 1: Processing
     * 2: Success
     * 3: Failed
     */
    private Integer status;

    /**
     * [Mandatory] Status Description
     * String type
     */
    private String statusDesc;

    /**
     * [Mandatory] Order Amount
     * Numeric type
     * Order Amount
     */
    private Double amount;

    /**
     * [Mandatory] Fee
     * Numeric type
     * Fee
     */
    private Double fee;

    /**
     * [Mandatory] Creation Time
     * Date type
     * Format: yyyy-MM-dd HH:mm:ss
     */
    private Date createAt;
}