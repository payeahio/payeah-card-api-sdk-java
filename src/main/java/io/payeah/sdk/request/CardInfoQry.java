package io.payeah.sdk.request;

import lombok.Data;


/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/4
 * description :
 * card info query request body
 **/
@Data
public class CardInfoQry {

        /**
         * Card Unique Identifier
         * (Mandatory)
         */
        private String cardId;
}
