package io.payeah.sdk.enums;

import lombok.Getter;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/22
 * description :
 **/
@Getter
public enum CardHolderStatus {
    DISABLED(0, "Disable"),
    ENABLED(1, "Enable"),
    DELETED(2, "Delete"),
    IN_PROCESS(3, "In Process");

    private final int code;
    private final String description;

    CardHolderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
