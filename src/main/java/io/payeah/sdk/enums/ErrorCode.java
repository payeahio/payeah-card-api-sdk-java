package io.payeah.sdk.enums;

public enum ErrorCode {

    SUCCESS("200", "success"),
    ERROR("500", "error"),
    // common error
    COMMON_ERROR_CODE("1000000", "common error"),
    SYSTEM_ERROR("1000001", "system error"),
    HTTP_REQUEST_ERROR("1000002", "http request error"),


    // business error
    PARAMETER_VALIDATION_FAILURE("110001", "Parameter validation failed"),
    PRODUCT_NOT_ENABLED("110002", "Product not enabled, please contact the administrator"),
    FEE_RULES_NOT_CONFIGURED("110003", "Fee rules not configured"),
    CARD_OR_GROUP_STATUS_NOT_SATISFIED("110004", "Card or group status not satisfied"),
    INSUFFICIENT_ACCOUNT_BALANCE("110005", "Insufficient account balance"),
    INSUFFICIENT_CARD_OR_GROUP_BALANCE("110006", "Insufficient card or group balance"),
    UNREPORTED_APPLICANT("110007", "Applicant for card opening has not been reported"),
    LIMIT_LESS_THAN_USED_AMOUNT("110008", "Limit cannot be less than the amount already used"),
    QUERY_RESULT_SET_EMPTY("120001", "Query result set is empty"),
    OPERATION_FAILED("130001", "Operation failed, please try again later"),
    UNKNOWN_ORDER_STATUS("140001", "Unknown order status, please query to get the order result");

    ;

    private final String errCode;
    private final String errDesc;

    private ErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public static void main(String[] args) {
        ErrorCode errorCode = valueOf("te");
        System.out.println(errorCode);
    }
}
