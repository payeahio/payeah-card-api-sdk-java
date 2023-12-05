package io.payeah.sdk.enums;

import lombok.Getter;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/22
 * description :
 **/
@Getter
public enum CardAuthType {
    AUTH("AUTH", "authorization"),
    REVERSAL("REVERSAL", "reversal"),
    REFUND("REFUND", "refund"),
    FEE("FEE", "fee"),
    FEE_REVERSAL("FEE_REVERSAL", "fee reversal"),
    ORIGINAL_CREDIT("ORIGINAL_CREDIT", "OCT refund"),
    ORIGINAL_CREDIT_REVERSAL("ORIGINAL_CREDIT_REVERSAL", "OCT refund reversal");

    private final String code;
    private final String description;

    private CardAuthType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
