package io.payeah.sdk.response;

import lombok.Data;
import java.util.List;

/**
 * CardHolderInfoCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : card holder info
 **/
@Data
public class CardHolderInfoCO {
    /**
     * [Mandatory] Card User Unique ID
     * String type
     */
    private String cardUserId;

    /**
     * [Mandatory] First Name
     * String type
     * Maximum length: 40
     */
    private String firstName;

    /**
     * [Optional] Middle Name
     * String type
     * Maximum length: 40
     */
    private String middleName;

    /**
     * [Mandatory] Last Name
     * String type
     * Maximum length: 40
     */
    private String lastName;

    /**
     * [Mandatory] Email
     * String type
     * Unique, each email can only be bound to one card holder
     * Maximum length: 40
     */
    private String email;

    /**
     * [Mandatory] Mobile Prefix
     * String type
     * Currently supported regions see appendix: mobile prefix
     * Maximum length: 4
     */
    private String mobilePrefix;

    /**
     * [Mandatory] Mobile
     * String type
     * (Mobile phone number prefix + mobile phone number) is unique. Each mobile phone number can only be bound to one cardholder
     * Maximum length: 11
     */
    private String mobile;

    /**
     * [Mandatory] Birth Date
     * String type
     * Format: yyyy-MM-dd (Card holder must be over 18 years old)
     * Maximum length: 10
     */
    private String birthDate;

    /**
     * [Mandatory] Country Code
     * String type
     * (For example: China, send CNH)
     * See appendix: country code
     * Maximum length: 3
     */
    private String countryCode;

    /**
     * [Mandatory] Billing State
     * String type
     * Maximum length: 50
     */
    private String billingState;

    /**
     * [Mandatory] Billing City
     * String type
     * Maximum length: 50
     */
    private String billingCity;

    /**
     * [Mandatory] Billing Address
     * String type
     * Maximum length: 100
     */
    private String billingAddress;

    /**
     * [Mandatory] Billing Zip Code
     * String type
     * Maximum length: 10
     */
    private String billingZipCode;

    /**
     * [Mandatory] Status
     * String type
     * Values: 0# Disable 1# Enable 2# Delete 3# in process
     */
    private String status;

    /**
     * [Mandatory] Create Time
     * String type
     * Format: yyyy-MM-dd HH:mm:ss
     */
    private String createAt;

    /**
     * [Optional] Remark
     * String type
     */
    private String remark;

    /**
     * [Optional] Card bin list
     * List type
     * Card holder supported cardbin list details
     */
    private List<HolderCardBin> holderCardBins;

    /**
     * HolderCardBin
     * email : david@payeah.io
     * created : 2023/11/6
     * description : holder card bin
     **/
    @Data
    public static class HolderCardBin {
        /**
         * [Mandatory] Supported Card Bin
         * String type
         * Only the supported cardBin can use this card holder for card opening
         */
        private String cardBin;

        /**
         * [Mandatory] Holder Status
         * String type
         * Values: 0# Disable 1# Enable 2# Delete 3# in process
         */
        private String holderStatus;

        /**
         * [Mandatory] Status Description
         * String type
         */
        private String holderStatusDesc;
    }
}