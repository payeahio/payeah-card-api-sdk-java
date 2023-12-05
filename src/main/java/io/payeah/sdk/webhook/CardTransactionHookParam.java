package io.payeah.sdk.webhook;

import lombok.Data;

/**
 * CardTransactionHookParam
 * email : david@payeah.io
 * created : 2023/11/2
 * description : card transaction webhook request body
 **/
@Data
public class CardTransactionHookParam {
        /**
         * [Mandatory] Record Number, a unique identifier for each transaction
         */
        private String recordNo;

        /**
         * [Mandatory] Card Unique Identifier, indicating the unique identifier of the card involved in the transaction
         */
        private String cardId;

        /**
         * [Mandatory] Transaction Occurrence Time, recording the date and time of the transaction
         */
        private String occurTime;

        /**
         * [Optional] Transaction Currency, indicating the currency type used in the transaction
         */
        private String transCurrency;

        /**
         * [Mandatory] Transaction Currency Amount, indicating the amount involved in the transaction
         */
        private Double transCurrencyAmt;

        /**
         * [Mandatory] Local Currency, indicating the currency type of the card used in the transaction
         */
        private String localCurrency;

        /**
         * [Mandatory] Local Currency Amount, indicating the amount of card local currency transaction
         */
        private Double localCurrencyAmt;

        /**
         * [Mandatory] Transaction Response Code, see Appendix: Transaction response code
         */
        private String respCode;

        /**
         * [Optional] Authorization Code, used for authorization code of authorization transaction
         */
        private String approvalCode;

        /**
         * [Mandatory] Merchant Name, indicating the merchant name involved in the transaction
         */
        private String merchantName;

        /**
         * [Optional] Merchant MCC, indicating the merchant's MCC
         */
        private String merchantCategoryCode;

        /**
         * [Optional] Cross-Border Type, 0: domestic 1: overseas
         */
        private String crossBoardType;

        /**
         * [Mandatory] Transaction Type, see Appendix: Transaction Type
         */
        private String transType;

        /**
         * [Mandatory] Transaction Status, see Appendix: Transaction Status
         */
        private String transStatus;
}