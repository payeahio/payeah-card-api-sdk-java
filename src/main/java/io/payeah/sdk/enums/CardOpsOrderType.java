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
public enum CardOpsOrderType {
    CARD_APPLICATION(0, "Card Application"),
    RECHARGE(1, "Recharge"),
    CARD_CANCELLATION(3, "Card Cancellation"),
    REFUND(4, "Refund");
    private final int code;
    private final String description;

    CardOpsOrderType(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public static CardOpsOrderType getByCode(int code) {
        return Arrays.stream(CardOpsOrderType.values()).filter(status -> status.getCode() == code).findFirst().orElse(null);
    }
}
