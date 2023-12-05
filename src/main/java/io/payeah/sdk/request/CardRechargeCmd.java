package io.payeah.sdk.request;

import lombok.Data;

/**
 * CardRechargeCmd
 * email : david@payeah.io
 * created : 2023/11/3
 * description : card recharge request body
 **/
@Data
public class CardRechargeCmd {

    /**
     * [Mandatory] User Request Number
     * String type, maximum length 128
     * Unique order number
     */
    private String clientOrderId;

    /**
     * [Mandatory] Card Unique Identifier
     * String type
     * Unique card number
     */
    private String cardId;

    /**
     * [Mandatory] Authorization Limit Amount
     * Numeric type
     * Recharge limit
     */
    private Double amount;

    /**
     * [Optional] Card Type
     * String type
     * 1 (Regular card, default) 2 (Shared card)
     */
    private Integer channelType;

}