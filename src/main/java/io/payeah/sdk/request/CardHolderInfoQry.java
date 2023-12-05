package io.payeah.sdk.request;

import lombok.Data;


/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/6
 * description :
 * card holder info query request body
 **/
@Data
public class CardHolderInfoQry {


    /**
     * CardUser Unique Identifier
     * Conditional
     * String type
     */
    private String cardUserId;
}
