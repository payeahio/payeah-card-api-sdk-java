package io.payeah.sdk.api;


import io.payeah.sdk.request.CardHolderCreateCmd;
import io.payeah.sdk.request.CardHolderDelCmd;
import io.payeah.sdk.request.CardHolderInfoQry;
import io.payeah.sdk.response.CardHolderCmdCO;
import io.payeah.sdk.response.CardHolderInfoCO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/6
 * description :
 **/
public interface CardHolderService {

    @POST("/py-card/openapi/v1/card-holder/create")
    Call<CardHolderCmdCO> createCardHolder(@Body CardHolderCreateCmd cardHolderCreateCmd);

    @POST("/py-card/openapi/v1/card-holder/info")
    Call<CardHolderInfoCO> getCardHolderInfo(@Body CardHolderInfoQry cardHolderInfoQry);

    @POST("/py-card/openapi/v1/card-holder/delete")
    Call<CardHolderCmdCO> deleteCardHolder(@Body CardHolderDelCmd cardHolderDelCmd);
}
