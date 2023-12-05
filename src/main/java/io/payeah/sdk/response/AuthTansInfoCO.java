package io.payeah.sdk.response;

import lombok.Data;

import java.util.Date;

/**
 * AuthTansInfoCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : auth transaction data info
 **/
@Data
public class AuthTansInfoCO {
    /**
     * [Mandatory] Record Number
     */
    private String recordNo;

    /**
     * [Mandatory] Card Unique Identifier
     */
    private String cardId;

    /**
     * [Mandatory] Transaction Occurrence Time
     */
    private Date occurTime;

    /**
     * [Optional] Transaction Currency
     */
    private String transCurrency;

    /**
     * [Mandatory] Transaction Currency Amount
     */
    private Double transCurrencyAmt;

    /**
     * [Mandatory] Local Currency
     */
    private String localCurrency;

    /**
     * [Mandatory] Local Currency Amount
     */
    private Double localCurrencyAmt;

    /**
     * [Mandatory] Response Code ,see api introduction
     */
    private String respCode;

    /**
     * [Optional] Approval Code
     */
    private String approvalCode;

    /**
     * [Mandatory] Merchant Name
     */
    private String merchantName;

    /**
     * [Optional] Merchant Category Code
     */
    private String merchantCategoryCode;

    /**
     * [Optional] Cross-Border Type
     */
    private String crossBoardType;

    /**
     * [Mandatory] Transaction Type
     */
    private String transType;

    /**
     * [Mandatory] Transaction Status
     */
    private String transStatus;

    /**
     * [Optional] Original Record Number
     */
    private String originRecordNo;
}