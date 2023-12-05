package io.payeah.sdk.enums;

import lombok.Getter;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/22
 * description :
 **/
@Getter
public enum CardStatus {
    USING(1, "Using"),
    CLOSED(2, "Closed"),
    FROZEN(0, "Frozen");

    private final int code;
    private final String description;

    CardStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
