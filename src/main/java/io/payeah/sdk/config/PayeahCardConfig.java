package io.payeah.sdk.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/3
 * description :
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayeahCardConfig {
    private String baseUrl = "";
    private String apiKey = "";
    /**
     * Your RSA private key
     */
    private String rsaPrivateKey = "";

    /**
     * Api key's payeah platform public key
     */
    private String payeahRsaPublicKey = "";
}
