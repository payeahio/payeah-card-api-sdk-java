package io.payeah.sdk.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.payeah.sdk.config.PayeahCardConfig;
import io.payeah.sdk.request.SecretRequest;
import io.payeah.sdk.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/4
 * description :
 **/

@Slf4j
public class WebhookTest {

    private WebhookConverter webhookConverter;

    @Before
    public void setUp() throws Exception {
        Yaml yaml = new Yaml();
        PayeahCardConfig payeahCardConfig = yaml.loadAs(this.getClass().getClassLoader().getResourceAsStream("config.yml"), PayeahCardConfig.class);
        webhookConverter = new WebhookConverter(payeahCardConfig.getPayeahRsaPublicKey(), payeahCardConfig.getRsaPrivateKey());
    }

    @Test
    public void testWebhook() throws Exception {
        /**
         * SecretRequest(timestamp=1701691884829, key=EuyvzwaOSSBtnuVak1leqWM9+cAalkXPtB9CsyxF6w7vNEXseRoyi/270qX0i2kvxBKvxUr2hXnVUSB3iDHan5lpenuVqa7BQ8HKDbaIhvnYAJbTXXPZ0OjJhy0x3DjdhETbVDaduHrfTrT4Ws30hWMqL9tHEml18WRz372uo6iY20H59rAWe6+jWnhECM1/0YvllrauPYMT4f+Vmf+g/N+VdDd++SYPQLUhIf5zmCcz7phXBwuP5aEi2Z1OWQC+MaK2IUtg2iODn7B+3+jbKX5PsMM3qJYG7Tme704HrS051qNI05CyeZbr/asrkQQoYQ47sUzakMPqZuW+oNvkQdxCS/WCxrXV8tuDVenrrf+gsD5kaqA+LMq03iTI8D8Ry3qF14NUsub/YB7j7TrA0KNCFxcFHDiFJmZhaMp26qqvqVzkFIy25oC+kDGl5ztY8g5U0spD/UNJiJFjTVeYtIQ8kY7ki5FB2SRRYSywVFSb2RhcqVArsUCM5C70Yo9N1ig9fJXmDISmvMjMOjRrvdaAIJUaTLunWQULPSoUeZST5IxQRVRixMRL/OJXZVJCxWPRP4p4Sh/upBEEjmVFjVG7tSmjsZ4zt9oY4fCond5UPeMhSGCIuON0HQHgQbTssTxYizgb/NeP63FCsFxhDouv6tzanAdhXHb6Cc5ZYJE=, sign=DVpZXbZCR/tzaqadhBN8mBkXWUFJ+tqTwET/dLu9EC/pz1oqCzmkZxhw11yhcchS9WuVVp6zxKWZChW5KtEOh9/xqdnDyEIJgutE5CctCcIODVo7kujt6BBEsA2M41CnnzOkbvir6rQlCNqZweA14Hyzk0mSaQ9WEWC/KOG3SHnC/Af4vZn2s3B8/6tqbajTufyMwtOYuSOZSUBirlkVnOJEfo5x3bvrA4WKyqM2YdILZPO68CzYMvPlxnJE58Qe+qRf5FuizWWtLA453mrquYNm5roNhpvEbhQirVABlrBJb0dbZAY0898uoTikC9fGN9vHEbEYr9iq9Xubs7DtZlqJI6jAAzilD1tfiPkRcfudin7Gle5731kt9HrSqOV0VhVpXoosHA1pLdG+VdSP99IUTcAMOmBKVFxU8MDt7g4R/aBzGX5TJDWQR1VTljgoTsbSI+F1fsvhniydrDaFLRKTAXht44wmuRkSJKQyB0UCasORfl36tvmiZ8EfkZgqbhyktkYaH3L7lrZ4L0uNfwDyQYEK4JC7s2igmtSDV4xuB+K9ZW0DV1fM2pdiX5oby8LBrAc+1TthIKuc7sFv/N0wBfRq93qmSJldiqDxNCQjqauL7Vs3QBjeSzjPtPOeH7hy5kvRO/a2SigtSZkD5Pivh9Y7YV2UR+ck3fxxbQQ=, data=ztM3nBN0nRirENhf5S6om5szsu3UmytE+md4vHes2s390zEGm4yhYA40spJk4nrQPUe4EccSHzQhLReVRAKkyg1cQJsNCeojBlegyfD5Zm0BOfSNzgYlSbshZfJF3UMFKS7knCGquFKyFSV0hmG8K5nL7QammbYgfxmFpCxivhCIt+X++FSKor9dSA4Vh+JjAIUb7QzkaV5Y2qzstuk3VFpeo7BjF/zdawDtxDnQRVh9As8jkfvo13Wv0kpQEcJ+yvDbkP08XGTMGLjaZwInl4TnPH6PCbC4gwX8Ks+1rTiDRXcbnCj1cE4kL+mW4q5eUVMPHVtyKLYTWlF8nTOpAwz/+pZiBQm1sXRzh8/K0aPvIWJ/sbnZk5zlVMcd4MoyTbsY6TS/tGi90RsABH19gBInhhGNypULY90FYfzKhF0=)
         */
        SecretRequest request = new SecretRequest();
        String transParam = "{\"timestamp\":1701692393762,\"key\":\"U8f8hCFBoxhCuO2wjZhfTr4DulIkEYhxZx1yjn/Vspc16KZNjKRk2cVA0AWYifJ0Hx0SxHsrG20j2i09hRArA7dWOEzRDZ0uFjDAIt0AV+m3+DwBYcxcQwKxuIDwWkT1v9yOsuHEqu0jQmL/NzZLRZCsokrvN00ZyVuqRMmFfb1kvqcBI0LF113cQhZOYmrFLK2TNkjT3iB6L8NKvYsrq/xms8EvVnaWhaHSFNA6zPO9I8QNJkiGISUfQwFqSGGhBIYcSGBnIsFaJN5yy9E6NGKEqzJfYvHtfNm6aGSJ8oA8ZxsmvP7wrI+NTSvAOWQBtI6kcyQFGMWaRzW4l9ewZciTTgoiZOeuJyH+/fvfN+WsFlRbXvcRmKrXnI3MGmT2Z2GOTdIKhvqEMlOIzZYD8XVX0LmRFqvJllbTLzFgPwdPTtKkKa3n2Z44dwww3z5qwqHv/ihNRA1s3iPdFoNEvtQH9BbXT1HK/qceYXd/JViWC545P/w3MGmJDkchkqKU1VOSa4w6pVKpB3sUAvIZouKfaxeJUpW/Z6o0C96XBUz0yez33HxaYRIpHTrwtZc7HEd6d1YpWZUMexY86EY+YcX1PlygRUzd3dwxCmJKKg3XFPC/8eFu0BElTLLHbeRGKXrvMK+zIE0N8MquKchRRskmxMRZoY1Ku4hYsyVIG90=\",\"sign\":\"ex0/gmgqSlTtjY2d1PT7NJvu4I8maGDvHRSkW8j0+r+05UTK/fgYwhJAG+TF3R+jO3Kb4SOqMIroIYTdru1Aimb14JR3IBnDqjlnEpZh0qof5mqoyjKBgGAZ1oIyLAHrb0fbefsJo7OQA9CCJH9nbtdyNq3L1Xoy749Fa99qcHRN8VhPAcW/ZOOhOCABeucYXUxktDec6WRs4WnkB9HKIIkqj6iLWSU+WIB6DYwOoMbGikrrmFgVQtQLy4dCue7+xFSgh2b/Xn8Cnt59yzfnH8FPl8MKrsVR9pX8Dv56X5lrbbAFs6Z390kovU2aiQHHYjjtZKW1DrCCkESI/wi2oamyF19cQUMDz4DCsX/lqm7zBxee2IJ5gdHy4oIEW0BRj2vq6WhhdiKaNWm7ltL9NEn0tgtGrpqBs8X5aumaUZ2v48yo1NhgESJekBa4aA1VYMQ0jRwDXBonRg4PkbVbe6o9pYJRURoULU+yzL/P7uCBc3X/RHxiLiidRrZHcjcmJRh394VmotiDvfDaB0bSqZ0ZLgrjZvo7LS1cshKEEzku80/AyUMCGud8NEZwXxJ9XXeXCZ3KEz7nZceVUVEGRIyV1croDrfnPf6ShXMiuOOhxDRdp1DDXCHA3GDizt4PVOHzKDTIJIM8T/ZAOpY4soA+F14LsQ/uzZhMsiq+VX0=\",\"data\":\"9uWIK3GYOHQwIeE+LmmD7Ol/TVAPUipdrsUI+fqtaGc9gyKkp+0BvjRk/WwpgiLFy5LdSBw0KVc34Vu0th2w/m8b9cba+Y2l/1GXEz/on+3SyGrAw/oKEmiUqsaz/5EFILrPu6Yo19GNQMo0vEtjZxTbYNwyn7H9Tl5X7URfBaCDIRKfIjidg4M6MRUxEITV+7f2gafV1ZUVC1nq3iICsYN2uO10J+JgAtd+GoGxUB/7nyiVp91nccdjhfKlmAPY+Zcs+mex9qDg6NAxUZ2kklyhfldRsZbd7mQprJtLBPhCqg5WOp696g5Eh1M3kMDQCPO9AZnlzSrCcq/uAD+WmpqH6EzdzZVD6EHX2KRiI84lMNkO+uZKWHUOb8l9gt8EiOg+2LoEX9f6Ibs5ni+8yBv7LnJcJ/oNYtOMNopBAIDFu1IINH5ho2jeJxJDQn4sgAwl0q6eRNT2d65YTXZeNh4vKkl3sPVJo4Ay9A0xx8vpM85BzrRNCEKvtiE2/XIsh6b5CLE96vhhNzQA+RzMQlKJ2RWK9dqh7jhTUFYGA5xVDGfXYetuSqbHX/EWO3eYdUuWDx8fM7hAcnW9UpNbAQ==\"}";
        ObjectMapper mapper = JsonUtil.getObjectMapper();
        request = mapper.readValue(transParam, SecretRequest.class);
        WebhookParam convert = webhookConverter.convert(request);
        log.info("transParam convert = {}", convert);


        String tradeFeeParam = "{\"timestamp\":1701692397526,\"key\":\"KTQj8s4DkJ0YYRtDZ6NU6n9mUXUJkjzqAh5rLk9/YlpoIw8zsF7V8fC9Ug2YXGVjvHEx9sViU6UAILoJHxAoybRyniWElLARlLYhZN086JdSevOGT2dBRj/4imj++7Vqg9ZEeXFZQkPZ339E3GAXkd5iC4O1Ycdal4ddWuV0JeYWi99R1OdNeFg4Yvq7gF8WYcDHwTRebeDfnVTyh6jfJm8gmCZQlbyQY19xHKKovgzh9nWJbzfPd8EAGYLX0s90vXRinTMCRGb/xGMc992or0sHoYvYt2SIEZgE6rh4EKCs1QgFjZHFp4aq+cu4S7lphuk9vgaTsrCFlDL4xrbsxg2qJ3V1CUpPzwMtrOiR6HQv/cieyQ20iTYRC4TKPFpl5AnBwHt9p1esEFXXSv75GlPlJKaGKWPS/FYflnU4QGl7YLywDNN//I38UbYiKqnFCJsjUrXqxp9sYacn+TTQ89f+ck6z2D+yyzumoTl8xMpdyuSRQAd/efxf9x1lqjuYC63jCrJXtBqDA8ZRCSbMc0II4eBIP3nYcBWVuBHk4c9+Z7hKIdfXcrdz7eK37qF3NmFpL/l/VsuVKE6eBlJixYtomPDwIN+L/VbnzC7Da6QUfMIkXVkyo9Ncfet/sC7pIWfEvl87KLvd8x0VPlRd/ez6wbC5Cpli7dgiFuvLw1c=\",\"sign\":\"E1bYb36T8GacxT2mjMz05GlTvslT5R1xSxkBHHZDSRtwturxsy4Ibww21cfagazgB5QLgY5WTxp/mWFn+isBAyOni82w4KYwzff1T8246ihHG5Eje5WnWA/FWi01/5Dfi7KLfY7gdZ3hML65XFRm17wgYDwn1dTdbxmn+o/CLfON+ngw0zWxNHAepOifzzRnjXralYEm3N1kKlWUzEJviyOrDn+neVxDZt2JH8D++AKL9r0HyNidlz/L9lRI+aDnPw/GK2biYJxHp6XFpeGr9eMaBfExW1b6SunijTlvI1pPaW8RqZ2oXHFRYz++U1aXMx9BJiMIO0OZvAOvjZmcTTIKu05LfTJU4U22pFQw6NNXqq4sS3Of19CH+iDGDprmfj8q67gcvM7CxbZ2crUL5eOYFZ8F+IMoEKkzkCmiUAg9TGpgvnYymHre+p81Qy5epxBZz4nfjzjrz5IuhUeNqMItM4ezpRH0KNwyzP07CYRcMunuVP65yplHApCwfbalnfNjTMYyl5z6tXogohuWo7k9h9YiUnu0iaXwytDneK42jw3OHUjgf0IQhfHhEjXx2nYGUILCiHdogSoAIN1E0HxhBI3jQwS6c2fTLSZCk9oFlRx2REDRNXM9k0XOeQUAeHHk4mT7RnW7HqLPw8AaTujO98Tw6MLhNT2KDVeM9WM=\",\"data\":\"j406xozamuGwUCPTil0cefVN++NqUKyOZQSG5MCo/Gq7Q/sOQClHqYAZxWnxbUTsinOnO77RbujQ5yEs4pjzZyb7IG/aCuL71hu69ffg+b4FH8Xw4vn6rJTwMkpuTcL5R71iva2yWOWsfXawkB61e40a6ZhOeO1GW2vvKUDfY9UDjR7MLOQ1YlaoxTKKygzT4xSWEJlDjeiH9SCOzfBpJo8pl2YqAS4bBr57Rllx71E+DjYhoa5Q2IZopOLUEZQuplOadfRMRrDK60VI0AvdOVEVkRhDNsRx8QGrBD8IZC4IlXwqQItfJvqwMXFrEWxqUOB/lVtD1MqoPQnM1VdenzSWlFURpnINRhCR2kgQuOlNyO3I5jA235aS53uqm1jC\"}";
        request = mapper.readValue(tradeFeeParam, SecretRequest.class);
        convert = webhookConverter.convert(request);
        log.info("tradeFeeParam convert = {}", convert);


        request.setTimestamp(1701691884829L);
        request.setSign("DVpZXbZCR/tzaqadhBN8mBkXWUFJ+tqTwET/dLu9EC/pz1oqCzmkZxhw11yhcchS9WuVVp6zxKWZChW5KtEOh9/xqdnDyEIJgutE5CctCcIODVo7kujt6BBEsA2M41CnnzOkbvir6rQlCNqZweA14Hyzk0mSaQ9WEWC/KOG3SHnC/Af4vZn2s3B8/6tqbajTufyMwtOYuSOZSUBirlkVnOJEfo5x3bvrA4WKyqM2YdILZPO68CzYMvPlxnJE58Qe+qRf5FuizWWtLA453mrquYNm5roNhpvEbhQirVABlrBJb0dbZAY0898uoTikC9fGN9vHEbEYr9iq9Xubs7DtZlqJI6jAAzilD1tfiPkRcfudin7Gle5731kt9HrSqOV0VhVpXoosHA1pLdG+VdSP99IUTcAMOmBKVFxU8MDt7g4R/aBzGX5TJDWQR1VTljgoTsbSI+F1fsvhniydrDaFLRKTAXht44wmuRkSJKQyB0UCasORfl36tvmiZ8EfkZgqbhyktkYaH3L7lrZ4L0uNfwDyQYEK4JC7s2igmtSDV4xuB+K9ZW0DV1fM2pdiX5oby8LBrAc+1TthIKuc7sFv/N0wBfRq93qmSJldiqDxNCQjqauL7Vs3QBjeSzjPtPOeH7hy5kvRO/a2SigtSZkD5Pivh9Y7YV2UR+ck3fxxbQQ=");
        request.setData("ztM3nBN0nRirENhf5S6om5szsu3UmytE+md4vHes2s390zEGm4yhYA40spJk4nrQPUe4EccSHzQhLReVRAKkyg1cQJsNCeojBlegyfD5Zm0BOfSNzgYlSbshZfJF3UMFKS7knCGquFKyFSV0hmG8K5nL7QammbYgfxmFpCxivhCIt+X++FSKor9dSA4Vh+JjAIUb7QzkaV5Y2qzstuk3VFpeo7BjF/zdawDtxDnQRVh9As8jkfvo13Wv0kpQEcJ+yvDbkP08XGTMGLjaZwInl4TnPH6PCbC4gwX8Ks+1rTiDRXcbnCj1cE4kL+mW4q5eUVMPHVtyKLYTWlF8nTOpAwz/+pZiBQm1sXRzh8/K0aPvIWJ/sbnZk5zlVMcd4MoyTbsY6TS/tGi90RsABH19gBInhhGNypULY90FYfzKhF0=");
        request.setKey("EuyvzwaOSSBtnuVak1leqWM9+cAalkXPtB9CsyxF6w7vNEXseRoyi/270qX0i2kvxBKvxUr2hXnVUSB3iDHan5lpenuVqa7BQ8HKDbaIhvnYAJbTXXPZ0OjJhy0x3DjdhETbVDaduHrfTrT4Ws30hWMqL9tHEml18WRz372uo6iY20H59rAWe6+jWnhECM1/0YvllrauPYMT4f+Vmf+g/N+VdDd++SYPQLUhIf5zmCcz7phXBwuP5aEi2Z1OWQC+MaK2IUtg2iODn7B+3+jbKX5PsMM3qJYG7Tme704HrS051qNI05CyeZbr/asrkQQoYQ47sUzakMPqZuW+oNvkQdxCS/WCxrXV8tuDVenrrf+gsD5kaqA+LMq03iTI8D8Ry3qF14NUsub/YB7j7TrA0KNCFxcFHDiFJmZhaMp26qqvqVzkFIy25oC+kDGl5ztY8g5U0spD/UNJiJFjTVeYtIQ8kY7ki5FB2SRRYSywVFSb2RhcqVArsUCM5C70Yo9N1ig9fJXmDISmvMjMOjRrvdaAIJUaTLunWQULPSoUeZST5IxQRVRixMRL/OJXZVJCxWPRP4p4Sh/upBEEjmVFjVG7tSmjsZ4zt9oY4fCond5UPeMhSGCIuON0HQHgQbTssTxYizgb/NeP63FCsFxhDouv6tzanAdhXHb6Cc5ZYJE=");
        convert = webhookConverter.convert(request);
        log.info("card ops convert = {}", convert);

    }

}
