package io.payeah.sdk.response;

import lombok.Data;

import java.util.Date;

/**
 * SettlementTansInfoCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : settlement transaction data info
 **/
@Data
public class SettlementTansInfoCO {
    /**
     * [Mandatory] Record Number
     * String type
     * Record Number as assigned by the service system
     */
    private String recordNo;

    /**
     * [Mandatory] Card Unique Identifier
     * String type
     * The card’s unique number will be used by subsequent interfaces.
     */
    private String cardId;

    /**
     * [Mandatory] Billing Date
     * Date type
     * Billing Date
     */
    private Date settleDate;

    /**
     * [Mandatory] Transaction Currency
     * String type
     * Transaction Currency
     */
    private String transCurrency;

    /**
     * [Mandatory] Transaction Amount
     * Double type
     * Transaction Amount
     */
    private Double transCurrencyAmt;

    /**
     * [Mandatory] Billing Currency
     * String type
     * Billing Currency
     */
    private String billCurrency;

    /**
     * [Mandatory] Billing Amount
     * Double type
     * Billing Amount
     */
    private Double billCurrencyAmt;

    /**
     * [Optional] Authorization Code
     * String type
     * Authorization Code
     */
    private String approvalCode;

    /**
     * [Mandatory] Payment Indicator
     * String type
     * 1: Receive (refund) 0: Pay (consumption)
     */
    private String isCredit;

    /**
     * [Optional] Merchant Name
     * String type
     * Merchant Name
     */
    private String merchantName;

    /**
     * [Optional] Original Record Number
     * String type
     * Original Record Number
     */
    private String originRecordNo;
}