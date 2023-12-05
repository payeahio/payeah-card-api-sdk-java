package io.payeah.sdk.response;

import lombok.Data;

/**
 * CardHolderCmdCO
 * email : david@payeah.io
 * created : 2023/11/6
 * description : card holder command request body
 **/
@Data
public class CardHolderCmdCO {

    /**
     * [Mandatory] Card User Unique ID
     * String type
     */
    private String cardUserId;
}