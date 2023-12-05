package io.payeah.sdk.enums;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/22
 * description :
 **/
public enum CardAuthStatus {
    APPROVED("APPROVED", "approved"),
    DECLINED("DECLINED", "declined");

    private final String code;
    private final String description;

    CardAuthStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
