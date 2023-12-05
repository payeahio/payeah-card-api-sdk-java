package io.payeah.sdk.enums;

import lombok.Getter;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/22
 * description :
 **/
@Getter
public enum CardSettlementType {
    PAY(0, "Pay (Consumption)"),
    RECEIVE(1, "Receive (Refund)");

    private final int code;
    private final String description;

    CardSettlementType(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
