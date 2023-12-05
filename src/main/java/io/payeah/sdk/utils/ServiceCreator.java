package io.payeah.sdk.utils;

import io.payeah.sdk.config.PayeahCardConfig;
import io.payeah.sdk.converter.ConverterFactory;
import io.payeah.sdk.converter.RequestInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;

import java.util.Arrays;

public class ServiceCreator {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_1_1));
    private static Retrofit.Builder builder = new Retrofit.Builder();
    private static volatile Retrofit retrofit;

    public static <S> S create(Class<S> serviceClass, PayeahCardConfig config) {
        Retrofit instance = getRetrofit(config);
        return instance.create(serviceClass);
    }


    private static Retrofit getRetrofit(PayeahCardConfig config) {
        if (retrofit == null) {
            synchronized (Retrofit.class) {
                if (retrofit == null) {
                    builder.baseUrl(config.getBaseUrl());
                    httpClient.addInterceptor(RequestInterceptor.create(config));
                    httpClient.callTimeout(10, java.util.concurrent.TimeUnit.SECONDS);
                    httpClient.connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS);
                    builder.client(httpClient.build());
                    builder.addConverterFactory(ConverterFactory.create(config));
                    retrofit = builder.build();
                }
            }
        }
        return retrofit;
    }
}
