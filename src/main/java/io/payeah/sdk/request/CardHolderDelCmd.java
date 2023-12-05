package io.payeah.sdk.request;

import lombok.Data;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/6
 * description :
 * card holder del request body
 **/
@Data
public class CardHolderDelCmd {

    /**
     * CardUser Unique Identifier
     * [Mandatory]
     */
    private String cardUserId;
}
