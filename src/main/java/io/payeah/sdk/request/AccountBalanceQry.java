package io.payeah.sdk.request;

import lombok.Data;


/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/6
 * description :
 * account balance query
 **/
@Data
public class AccountBalanceQry {
    /**
     * currency
     * (Mandatory)
     */
    private String ccy;
}
