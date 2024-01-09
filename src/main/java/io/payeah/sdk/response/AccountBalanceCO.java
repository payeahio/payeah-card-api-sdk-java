package io.payeah.sdk.response;

import lombok.Data;

/**
 * AccountBalanceCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : account balance client object
 **/
@Data
public class AccountBalanceCO {

    /**
     * [Mandatory] Currency
     * String type
     * Merchant's account currency
     */
    private String ccy;

    /**
     * [Mandatory] Current Balance
     * Numeric type
     * Current total balance
     */
    private Double currentBalance;

    /**
     * [Mandatory] Available Balance
     * Numeric type
     * Current available balance
     */
    private Double availableBal;
}