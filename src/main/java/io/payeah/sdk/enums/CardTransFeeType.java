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
