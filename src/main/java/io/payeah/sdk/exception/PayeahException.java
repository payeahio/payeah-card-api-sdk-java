package io.payeah.sdk.exception;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/3
 * description :
 **/
public class PayeahException extends RuntimeException{

    private String code;
    private String message;

    public PayeahException(String code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public PayeahException(String message){
        super(message);
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
