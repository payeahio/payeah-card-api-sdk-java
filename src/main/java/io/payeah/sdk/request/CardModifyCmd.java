package io.payeah.sdk.request;

import lombok.Data;

/**
 * CardModifyCmd
 * email : david@payeah.io
 * created : 2023/11/6
 * description : card modify command
 **/
@Data
public class CardModifyCmd {

    /**
     * User Request Number
     * Mandatory
     * String type (Maximum length: 128)
     * Unique order number
     */
    private String clientOrderId;

    /**
     * Card Unique Identifier
     * Mandatory
     * String type
     */
    private String cardId;

    /**
     * Card Alias
     * Conditional
     * String type
     */
    private String cardAlias;

    /**
     * Card Label
     * Conditional
     * String type
     */
    private String cardLabel;

    /**
     * Card Status
     * Conditional
     * Integer type
     * Card freeze operation: 0#Freeze 1#Enable
     */
    private Integer status;

    /**
     * Card Spending Limit
     * Conditional
     * Numeric type
     * Card usage limit (regular cards must be empty)
     */
    private Double authLimitAmount;
}