package io.payeah.sdk.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/10/26
 * description :
 **/
public class DateSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (date != null) {
            jsonGenerator.writeString(ThreadLocalUtils.SIMPLE_DATEFORMAT_RESPONSE_THREADLOCAL.get().format(date));
        }
    }
}
