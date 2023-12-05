package io.payeah.sdk.utils;

import io.payeah.sdk.enums.ErrorCode;
import io.payeah.sdk.exception.PayeahException;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public class ServiceExecutor {
    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                StringBuilder errorMsgBuilder = new StringBuilder();
                errorMsgBuilder.append("http request failed: ");
                errorMsgBuilder.append(null != response.body() ? response.body().toString() : "");
                errorMsgBuilder.append(null != response.errorBody() ? response.errorBody().string() : "");
                throw new PayeahException(ErrorCode.ERROR.getErrCode(), errorMsgBuilder.toString());
            }
        } catch (PayeahException se){
            throw se;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new PayeahException(ErrorCode.ERROR.getErrCode(), ioException.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            throw new PayeahException(ErrorCode.ERROR.getErrCode(), e.getMessage());
        }
    }
}
