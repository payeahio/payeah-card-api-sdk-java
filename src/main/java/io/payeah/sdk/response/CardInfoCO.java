package io.payeah.sdk.response;

import lombok.Data;

import java.util.Date;

/**
 * CardInfoCO
 * email : david@payeah.io
 * created : 2023/11/4
 * description : card info response body
 **/
@Data
public class CardInfoCO {
    /**
     * [Mandatory] User Number
     * Numeric type
     * User Number as assigned by the service system
     */
    private String userNo;

    /**
     * [Mandatory] Card Number
     * String type
     * Card Number as assigned by the service system
     */
    private String cardNo;

    /**
     * [Mandatory] Card CVV (3 digits)
     * Numeric type
     * Card CVV (3 digits)
     */
    private String cardVerifyNo;

    /**
     * [Optional] Card Alias
     * String type
     * Card Alias
     */
    private String cardAlias;

    /**
     * [Optional] Card Label
     * String type
     * Card Label
     */
    private String cardLabel;

    /**
     * [Mandatory] Card Expiry Date
     * String type
     * Card Expiry Date
     */
    private String cardExpiryDate;

    /**
     * [Mandatory] Local Currency
     * String type
     * Local currency code of the card
     */
    private String localCurrency;

    /**
     * [Mandatory] Start Active Date
     * String type
     * Start Active Date
     */
    private String startActiveDate;

    /**
     * [Mandatory] End Close Date
     * String type
     * End Close Date
     */
    private String endCloseDate;

    /**
     * [Optional] Credit Limit Amount
     * Numeric type
     * Credit Limit Amount
     */
    private Double creditLimitAmt;

    /**
     * [Mandatory] Min Authorization Amount
     * Numeric type
     * Min Authorization Amount
     */
    private Double minAuthAmt;

    /**
     * [Mandatory] Max Authorization Amount
     * Numeric type
     * Max Authorization Amount
     */
    private Double maxAuthAmt;

    /**
     * [Mandatory] Balance Amount
     * Numeric type
     * Balance Amount
     */
    private Double balanceAmt;

    /**
     * [Mandatory] Used Authorization Amount
     * Numeric type
     * Used Authorization Amount
     */
    private Double usedAuthAmt;

    /**
     * [Mandatory] Enable Multiple Use
     * String type
     * Enable Multiple Use
     */
    private String enableMultiUse;

    /**
     * [Optional] Enable Currency Check
     * String type
     * Enable Currency Check
     */
    private String enableCurrencyCheck;

    /**
     * [Conditional] Card Closed Amount
     * Numeric type
     * Card Closed Amount
     */
    private Double cardClosedAmt;

    /**
     * [Mandatory] Card Status
     * String type
     * Card Status
     */
    private String cardStatus;

    /**
     * [Mandatory] Card Status Description
     * String type
     * Card Status Description
     */
    private String cardStatusDesc;

    /**
     * [Mandatory] Card Creation Time
     * Date type
     * Card Creation Time
     */
    private Date createTime;

    /**
     * [Conditional] Card User Information
     * String type
     * Card User Information
     */
    private CardUserInfo cardUserInfo;

    /**
     * [Conditional] Billing Address Information
     * String type
     * Billing Address Information
     */
    private BillAddressInfo billAddressInfo;

    @Data
    public static class CardUserInfo {
        /**
         * [Mandatory] First Name
         * String type
         * First Name
         */
        private String firstName;

        /**
         * [Mandatory] Last Name
         * String type
         * Last Name
         */
        private String lastName;

        /**
         * [Mandatory] Email
         * String type
         * Email
         */
        private String email;

        /**
         * [Mandatory] Mobile
         * String type
         * Mobile
         */
        private String mobile;

        /**
         * [Mandatory] Birth Date
         * String type
         * Birth Date
         */
        private String birthDate;
    }

    @Data
    public static class BillAddressInfo {
        /**
         * [Mandatory] Country Code
         * String type
         * Country Code
         */
        private String countryCode;

        /**
         * [Mandatory] Country
         * String type
         * Country
         */
        private String country;

        /**
         * [Mandatory] Billing State
         * String type
         * Billing State
         */
        private String billingState;

        /**
         * [Mandatory] Billing City
         * String type
         * Billing City
         */
        private String billingCity;

        /**
         * [Mandatory] Billing Address
         * String type
         * Billing Address
         */
        private String billingAddress;

        /**
         * [Mandatory] Billing Zip Code
         * String type
         * Billing Zip Code
         */
        private String billingZipCode;
    }
}