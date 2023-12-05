package io.payeah.sdk.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import io.payeah.sdk.enums.ErrorCode;
import io.payeah.sdk.exception.PayeahException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/10/26
 * description :
 **/
public class DateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String valueAsString = jsonParser.getValueAsString();
        SimpleDateFormat simpleDateFormat = ThreadLocalUtils.SIMPLE_DATEFORMAT_REQUEST_THREADLOCAL.get();
        try {
            return simpleDateFormat.parse(valueAsString);
        } catch (ParseException e) {
            throw new PayeahException(ErrorCode.COMMON_ERROR_CODE.name(),"date format error");
        }
    }
}
