package io.payeah.sdk.enums;

import lombok.Getter;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/1
 * description :
 **/
@Getter
public enum CardAuthTransRespCode {
    SUCCESS("000000", "Transaction successful"),
    ACCOUNT_EXCEPTION("100001", "Transaction failed (account exception)"),
    INVALID_CARD("200001", "Transaction failed (invalid card)"),
    INSUFFICIENT_BALANCE("200002", "Transaction failed (insufficient balance)"),
    INVALID_CVV("200003", "Transaction failed (invalid CVV)"),
    INVALID_EXPIRY_DATE("200004", "Transaction failed (invalid expiry date)"),
    INVALID_CURRENCY("200005", "Transaction failed (invalid currency)"),
    NON_MULTI_USE_CARD("200006", "Transaction failed (non-multi-use card)"),
    EXCEED_LIMIT("200007", "Transaction failed (exceed limit)"),
    CARD_EXCEPTION("200008", "Transaction failed (card exception)"),
    EXCEED_TRANSACTION_LIMIT("200009", "Transaction failed (exceed transaction limit)"),
    INVALID_MERCHANT("300001", "Transaction failed (invalid merchant)"),
    HIGH_RISK_TRANSACTION("400001", "Transaction failed (high-risk transaction)"),
    INVALID_AMOUNT("400002", "Transaction failed (invalid amount)"),
    INVALID_TRANSACTION("400003", "Transaction failed (invalid transaction)"),
    TRANSACTION_NOT_FOUND("400004", "Transaction failed (transaction not found)"),
    INVALID_TRANSACTION_STATUS("400005", "Transaction failed (invalid transaction status)"),
    UNSUPPORTED_TRANSACTION_TYPE("400006", "Transaction failed (unsupported transaction type)"),
    TRANSACTION_TIMEOUT("400007", "Transaction failed (transaction timeout)"),
    RISK_CONTROL_REJECTION("400008", "Transaction failed (risk control rejection)"),
    CHANNEL_INTERCEPTION("400009", "Transaction failed (channel interception)"),
    REFUND_LIMIT_EXCEEDED("400010", "Transaction failed (refund limit exceeded)"),
    FREQUENT_AUTHORIZATION("400011", "Transaction failed (frequent authorization)"),
    DECISION_REJECTION("400012", "Transaction failed (decision rejection)"),
    SYSTEM_UPGRADE("999998", "Transaction failed (system upgrade)"),
    UNKNOWN_EXCEPTION("999999", "Transaction failed (unknown exception)");
    private final String code;
    private final String description;

    CardAuthTransRespCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
