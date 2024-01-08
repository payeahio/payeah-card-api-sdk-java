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
    /**
     * 兼容三种时间格式
     * 1. yyyy-MM-dd HH:mm:ss
     * 2. yyyy-MM-dd
     * 3. yyyy-MM-ddTHH:mm:ss.000+00:00
     */
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String valueAsString = jsonParser.getValueAsString();
        if (!valueAsString.contains(" ")) {
            valueAsString = valueAsString + " 00:00:00";
        }
        if (valueAsString.contains("T")) {
            // 2024-01-05T06:29:35.000+00:00
            // 给出此种格式的时间，需要转换为yyyy-MM-dd HH:mm:ss
            valueAsString = valueAsString.replace("T", " ");
            valueAsString = valueAsString.substring(0, valueAsString.indexOf("."));
        }
        SimpleDateFormat simpleDateFormat = ThreadLocalUtils.SIMPLE_DATEFORMAT_REQUEST_THREADLOCAL.get();
        try {
            return simpleDateFormat.parse(valueAsString);
        } catch (ParseException e) {
            throw new PayeahException(ErrorCode.COMMON_ERROR_CODE.name(),"date format error");
        }
    }
}
