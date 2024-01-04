package io.payeah.sdk.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/22
 * description :
 **/
@Getter
public enum CardTransFeeType {

    REVERSAL_PROCESSING_FEE(91, "Reversal processing fee"),
    MERCHANT_FORCE_SETTLEMENT(92, "Merchant force settlement"),
    EXCEPTION_SETTLEMENT(93, "Exception settlement"),
    AFTER_REVERSAL_SETTLEMENT(94, "After reversal settlement"),
    SETTLEMENT_EXCHANGE_DIFFERENCE(95, "Settlement exchange difference"),
    MINOR_TRANSACTION_PROCESSING_FEE(96, "Minor transaction processing fee"),

    CROSS_FEE(97, "Cross-border handling fee"),
    REFUND_FEE(98, "Transaction refund processing fee"),
    PROCESSING_FEE(99, "Transaction processing fee");

    private final int code;
    private final String description;

    CardTransFeeType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static CardTransFeeType getByCode(int code) {
        return Arrays.stream(CardTransFeeType.values()).filter(status -> status.getCode() == code).findFirst().orElse(null);
    }
}
