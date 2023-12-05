package io.payeah.sdk.request;

import lombok.Data;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/3
 * description :
 * card close request body
 **/
@Data
public class CardCloseCmd {

    /**
     * Client Order ID as assigned by the client
     * max length: 64
     * (Mandatory)
     */
    private String clientOrderId;


    /**
     * The card’s unique number will be used by subsequent interfaces.
     * (Mandatory)
     */
    private String cardId;
}
