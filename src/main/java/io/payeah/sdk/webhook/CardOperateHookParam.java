package io.payeah.sdk.webhook;

import lombok.Data;

import java.util.Date;

/**
 * CardOperateHookParam
 * email : david@payeah.io
 * created : 2023/11/2
 * description : card operate hook parameters
 **/
@Data
public class CardOperateHookParam {

    /**
     * [Mandatory] The order number returned by the service system uniquely identifies each order.
     * String type
     */
    private String orderId;

    /**
     * [Optional] Card number, the unique identifier of the card. The card number will be involved in operations such as opening cards and selling cards.
     * String type
     */
    private String cardId;

    /**
     * [Optional] Card group number, the unique identifier of the card group. The card group number will be involved in operations such as opening cards and selling cards.
     * String type
     */
    private String groupId;

    /**
     * [Mandatory] Request serial number, the serial number uploaded by the customer, uniquely identifies each request.
     * String type
     */
    private String clientOrderId;

    /**
     * [Mandatory] Order type, indicating the type of order, such as opening card, recharging, selling card, refunding.
     * Integer type
     */
    private int opType;

    /**
     * [Mandatory] Order status, indicating the status of the order, such as success or failure.
     * Order Status: 2 success,3 failed
     * Integer type
     */
    private int status;

    /**
     * [Mandatory] Status description, describes the detailed information of the order status.
     * String type
     */
    private String statusDesc;

    /**
     * [Mandatory] Order amount, indicating the amount of the order. Note: The limit (0 means no limit) when opening the attached card; the amount of the card when selling the card.
     * Double type
     */
    private Double amount;

    /**
     * [Mandatory] Fee, indicating the fee for the order. Note: The total fee when opening the card.
     * Double type
     */
    private Double fee;

    /**
     * [Optional] Card information, including more detailed information about the card, usually provided when opening the card.
     * CardInfo type
     */
    private CardInfo cardInfo;

    /**
     * [Mandatory] Creation time, the time when the order was created, in the format of yyyy-MM-dd HH:mm:ss.
     * Date type
     */
    private Date createAt;

    @Data
    public static class CardInfo {
        /**
         * [Mandatory] Card number, identifies the card number of the cardholder.
         * String type
         */
        private String cardNo;

        /**
         * [Mandatory] Card security verification code CVV (3 digits), card verification code used for security verification.
         * String type
         */
        private String cardVerifyNo;

        /**
         * [Optional] Card alias, the alias of the card, optional field.
         * String type
         */
        private String cardAlias;

        /**
         * [Optional] Card label, the label of the card, optional field.
         * String type
         */
        private String cardLabel;

        /**
         * [Mandatory] Card expiration date, indicating the validity period of the card, in the format of MM/yyyy (such as: 03/2022).
         * String type
         */
        private String cardExpiryDate;

        /**
         * [Mandatory] Card local currency, indicating the local currency of the card.
         * String type
         */
        private String localCurrency;

        /**
         * [Mandatory] Card effective date, indicating the date when the card takes effect.
         * String type
         */
        private String startActiveDate;

        /**
         * [Mandatory] The latest closing date of the card, indicating the latest closing date of the card.
         * String type
         */
        private String endCloseDate;
    }
}