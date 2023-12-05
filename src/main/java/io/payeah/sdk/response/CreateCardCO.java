package io.payeah.sdk.response;

import lombok.Data;

/**
 * CreateCardCO
 * email : david@payeah.io
 * created : 2023/11/3
 * description : create card response body
 **/
@Data
public class CreateCardCO {
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

    /**
     * [Mandatory] Card ID as assigned by the service system
     * String type
     * The card’s unique number will be used by subsequent interfaces.
     */
    private String cardId;

    /**
     * [Mandatory] Local Currency
     * String type
     * Local currency code of the card
     * ISO 4217 currency code, e.g. USD, EUR, GBP, etc.
     */
    private String localCurrency;

    /**
     * [Mandatory] Card Number
     * String type
     * Card Number
     */
    private String cardNo;

    /**
     * [Mandatory] Card Verification Number (VCC)
     * String type
     * Card Verification Number (VCC)
     */
    private String cardVerifyNo;

    /**
     * [Mandatory] Card Expiry Date
     * String type
     * Card Expiry Date
     */
    private String cardExpiryDate;
}