package io.payeah.sdk.request;

import lombok.Data;


/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/6
 * description :
 * card holder create request body
 **/
@Data
public class CardHolderCreateCmd {
    /**
     * first name ,
     * [Mandatory]
     * Maximum length: 40
     */
    private String firstName;

    /**
     * middle name ,
     * [Optional]
     * Maximum length: 40
     */
    private String middleName;

    /**
     * last name ,
     * [Mandatory]
     * Maximum length: 40
     */
    private String lastName;

    /**
     * email ,
     * [Mandatory]
     * Maximum length: 40
     */
    private String email;

    /**
     * mobile prefix
     * [Mandatory]
     * Maximum length: 4
     * see api introduction: mobile prefix
     */
    private String mobilePrefix;

    /**
     * (Mobile phone number prefix + mobile phone number) is unique. Each mobile phone number can only be bound to one cardholder,Maximum length: 11
     * [Mandatory]
     * Maximum length: 11
     */
    private String mobile;

    /**
     * birth date (yyyy-MM-dd UTC+8),Maximum length: 10
     * [Mandatory]
     * Maximum length: 10
     */
    private String birthDate;

    /**
     * country code (IOS 3166-1 alpha-3)
     * [Mandatory]
     * Maximum length: 3
     */
    private String countryCode;

    /**
     * billing state
     * [Mandatory]
     * Maximum length: 50
     */
    private String billingState;

    /**
     * billing city
     * [Mandatory]
     * Maximum length: 50
     */
    private String billingCity;

    /**
     * billing address
     * [Mandatory]
     * Maximum length: 100
     */
    private String billingAddress;

    /**
     * billing zip code
     * [Mandatory]
     * Maximum length: 10
     */
    private String billingZipCode;

}
