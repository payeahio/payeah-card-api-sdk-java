package io.payeah.sdk.webhook;

import lombok.Getter;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/11/2
 * description :
 **/

@Getter
public enum WebhookEventTypeEnum {
    trade_fee,
    card_3ds_otp,
    card_transaction,
    type_card_operate
}
