package io.payeah.sdk.request;

import lombok.Data;

/**
 * CardRefundCmd
 * email : david@payeah.io
 * created : 2023/11/6
 * description : card refund request body
 **/
@Data
public class CardRefundCmd {

    /**
     * [Mandatory] User Request Number
     * String type, maximum length 128
     * Unique order number
     */
    private String clientOrderId;

    /**
     * [Conditional] Card Unique Identifier
     * String type
     * Unique card number
     */
    private String cardId;

    /**
     * [Mandatory] Refund Amount
     * Numeric type
     * Refund amount
     */
    private Double refundAmount;

    /**
     * [Optional] Card Type
     * String type
     * 1 (Regular card, default) 2 (Shared card)
     */
    private Integer channelType;

    /**
     * [Conditional] Group Unique Identifier for Shared Card
     * String type
     * Unique number of the shared card group
     */
    private String groupId;
}