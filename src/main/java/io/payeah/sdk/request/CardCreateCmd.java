package io.payeah.sdk.request;

import lombok.Data;

import java.util.Date;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/3
 * description :
 * create card request body
 **/
@Data
public class CardCreateCmd {
    /**
     * Client Order ID as assigned by the client
     * [Mandatory]
     * max length 64
     */
    private String clientOrderId;
    /**
     * Local currency code of the card
     * ISO 4217 currency code, e.g. USD, EUR, GBP, etc.
     * [Mandatory]
     */
    private String localCurrency;
    /**
     * Start date of the card
     * Greater than or equal to the current date, format yyyy-MM-dd (UTC +8)
     * [Mandatory]
     */
    private Date startDate;
    /**
     * End date of the card
     * Greater than or equal to the start time, the format is yyyy-MM-dd  (UTC +8)
     * [Mandatory]
     */
    private Date endDate;
    /**
     * Authorization limit amount of the card
     * The maximum amount of a single transaction that can be authorized by the card
     * [Mandatory]
     */
    private Double authLimitAmount;
    /**
     * Whether to enable multiple use of the card
     * 0: No
     * 1: Yes
     * [Mandatory]
     */
    private Integer enableMultiUse;
    /**
     * Whether to enable currency check
     * 0: No
     * 1: Yes
     * [Mandatory]
     */
    private Integer enableCurrencyCheck;
    /**
     * max length 64
     * [Optional]
     */
    private String cardAlias;
    /**
     * Regular card (default): 222929 (test network use 522981)
     * [Mandatory]
     */
    private String binRangeId;
    /**
     * Card header: 485932, 486821 must be transmitted (cardUserId returned by the cardholder’s application interface
     * [Conditional]
     */
    private String cardUserId;
}
