package io.payeah.sdk.enums;

import lombok.Getter;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2024/1/3
 * description :
 **/
@Getter
public enum WebhookTakeOutType {
    NULL(-2,"Judge by type of webhook"),
    NONE(-1, "No account impact"),
    VA(1, "Va"),
    CARD(2, "Card"),
    BOTH(3, "Both");

    private final int code;
    private final String description;

    WebhookTakeOutType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static WebhookTakeOutType fromCode(Integer code) {
        if (code == null) {
            return NULL;
        }
        for (WebhookTakeOutType type : WebhookTakeOutType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return NULL;
    }

    public boolean isVa() {
        return this == VA;
    }
}
