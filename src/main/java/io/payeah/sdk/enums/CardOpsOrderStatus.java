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
public enum CardOpsOrderStatus {
    PENDING(0, "Pending"),
    PROCESSING(1, "Processing"),
    SUCCESS(2, "Success"),
    FAILED(3, "Failed");

    private final int code;
    private final String description;

    CardOpsOrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CardOpsOrderStatus getByCode(int code) {
        return Arrays.stream(CardOpsOrderStatus.values()).filter(status -> status.getCode() == code).findFirst().orElse(null);
    }

    public static boolean isFailed(int code) {
        return code == FAILED.getCode();
    }
    public boolean isFailed() {
        return this.code == FAILED.getCode();
    }
}
