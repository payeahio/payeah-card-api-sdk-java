package io.payeah.sdk.api;


import com.alibaba.cola.dto.SingleResponse;
import io.payeah.sdk.request.AccountBalanceQry;
import io.payeah.sdk.response.AccountBalanceCO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/3
 * description :
 **/
public interface AccountService {
    @POST("/py-card/openapi/v1/account/balance")
    Call<AccountBalanceCO> getUserBalanceAccount(@Body AccountBalanceQry accountBalanceQry);
}
