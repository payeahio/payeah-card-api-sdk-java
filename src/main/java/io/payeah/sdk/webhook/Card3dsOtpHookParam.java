package io.payeah.sdk.webhook;

import lombok.Data;

/**
 * Card3dsOtpHookParam
 * email : david@payeah.io
 * created : 2023/11/2
 * description : card 3ds otp hook parameters
 **/
@Data
public class Card3dsOtpHookParam {
    /**
     * [Mandatory] OTP verification code
     * String type
     */
    private String otp;

    /**
     * [Mandatory] Card number unique ID, the unique identifier of the card number
     * String type
     */
    private String cardId;

    /**
     * [Mandatory] Card number, mask display
     * String type
     */
    private String cardNo;

    /**
     * [Mandatory] Transaction currency, indicating the currency type involved in the transaction
     * String type
     */
    private String transactionCurrency;

    /**
     * [Mandatory] Transaction amount, indicating the amount of the transaction
     * Double type
     */
    private Double transactionAmount;

    /**
     * [Mandatory] Merchant name, indicating the merchant name involved in the transaction
     * String type
     */
    private String merchantName;
}