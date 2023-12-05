package io.payeah.sdk.api;


import io.payeah.sdk.request.CardCloseCmd;
import io.payeah.sdk.request.CardCreateCmd;
import io.payeah.sdk.request.CardInfoQry;
import io.payeah.sdk.request.CardModifyCmd;
import io.payeah.sdk.request.CardOpsQry;
import io.payeah.sdk.request.CardRechargeCmd;
import io.payeah.sdk.request.CardRefundCmd;
import io.payeah.sdk.request.CardTransQry;
import io.payeah.sdk.response.AuthTansInfoCO;
import io.payeah.sdk.response.CardInfoCO;
import io.payeah.sdk.response.CardOpsTransInfoCO;
import io.payeah.sdk.response.CreateCardCO;
import io.payeah.sdk.response.OrderCmdCO;
import io.payeah.sdk.response.OrderMofifyCmdCO;
import io.payeah.sdk.response.PageCO;
import io.payeah.sdk.response.SettlementTansInfoCO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/3
 * description :
 **/
public interface CardService {
    @POST("/py-card/openapi/v1/card/create")
    Call<CreateCardCO> createCard(@Body CardCreateCmd cardCreateCmd);

    @POST("/py-card/openapi/v1/card/close")
    Call<OrderCmdCO> closeCard(@Body CardCloseCmd cardCloseCmd);

    @POST("/py-card/openapi/v1/card/recharge")
    Call<OrderCmdCO> cardRecharge(@Body CardRechargeCmd cardRechargeCmd);

    @POST("/py-card/openapi/v1/card/info")
    Call<CardInfoCO> getCardInfo(@Body CardInfoQry cardInfoQry);

    @POST("/py-card/openapi/v1/card/auth-trans")
    Call<PageCO<AuthTansInfoCO>> getCardAuthTransactionList(@Body CardTransQry cardTransQry);

    @POST("/py-card/openapi/v1/card/settle-trans")
    Call<PageCO<SettlementTansInfoCO>> getCardSettlementTransactionList(@Body CardTransQry cardTransQry);

    @POST("/py-card/openapi/v1/card/refund")
    Call<OrderCmdCO> cardRefund(@Body CardRefundCmd cardRefundCmd);

    @POST("/py-card/openapi/v1/card/modify")
    Call<OrderMofifyCmdCO> modifyCard(@Body CardModifyCmd cardModifyCmd);

    @POST("/py-card/openapi/v1/card/ops-trans")
    Call<PageCO<CardOpsTransInfoCO>> getCardOpsTransactionList(@Body CardOpsQry cardOpsQry);
}
