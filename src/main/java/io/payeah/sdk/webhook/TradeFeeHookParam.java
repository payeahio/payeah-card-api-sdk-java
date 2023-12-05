package io.payeah.sdk.webhook;

import lombok.Data;

import java.util.Date;

/**
 * TradeFeeHookParam
 * email : david@payeah.io
 * created : 2023/11/2
 * description : trade fee hook parameters
 **/
@Data
public class TradeFeeHookParam {
    /**
     * [Mandatory] Card Unique Identifier
     * String type
     */
    private String cardId;

    /**
     * [Mandatory] Fee Type
     * 97 - Cross-border handling fee
     * 98 - Transaction refund processing fee
     * 99 - Transaction processing fee
     * Integer type
     */
    private int opType;

    /**
     * [Mandatory] Fee Voucher
     * Used to identify the voucher information for the fee
     * String type
     */
    private String receiptNo;

    /**
     * [Mandatory] Transaction ID
     * Associated with the corresponding transaction record
     * String type
     */
    private String recordNo;

    /**
     * [Mandatory] User Number
     * User identification related to the fee record
     * String type
     */
    private String userNo;

    /**
     * [Mandatory] Fee Currency
     * Indicating the currency type of the fee
     * String type
     */
    private String realCcy;

    /**
     * [Mandatory] Fee Amount
     * Indicating the amount actually charged
     * Double type
     */
    private Double realFee;

    /**
     * [Mandatory] Time
     * Recording the date and time when the fee occurred
     * Format: "yyyy-MM-dd HH:mm:ss"
     * Date type
     */
    private Date createAt;
}