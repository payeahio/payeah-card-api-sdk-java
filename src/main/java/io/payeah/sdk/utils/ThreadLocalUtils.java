package io.payeah.sdk.utils;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/3
 * description :
 **/
public class ThreadLocalUtils {
    public static ThreadLocal<SimpleDateFormat> SIMPLE_DATEFORMAT_RESPONSE_THREADLOCAL = ThreadLocal.withInitial(() -> {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
        return simpleDateFormat;
    });
    public static ThreadLocal<SimpleDateFormat> SIMPLE_DATEFORMAT_REQUEST_THREADLOCAL = ThreadLocal.withInitial(() -> {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
        return simpleDateFormat;
    });
}
