package io.payeah.sdk.api;

import com.alibaba.cola.dto.SingleResponse;
import io.payeah.sdk.config.PayeahCardConfig;
import io.payeah.sdk.request.AccountBalanceQry;
import io.payeah.sdk.response.AccountBalanceCO;
import io.payeah.sdk.utils.ServiceCreator;
import io.payeah.sdk.utils.ServiceExecutor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import retrofit2.Call;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/4
 * description :
 **/
@Slf4j
public class AccountServiceTest {

    private AccountService accountService;
    @Before
    public void setUp() throws Exception {
        Yaml yaml = new Yaml();
        PayeahCardConfig payeahCardConfig = yaml.loadAs(this.getClass().getClassLoader().getResourceAsStream("config.yml"), PayeahCardConfig.class);
        accountService = ServiceCreator.create(AccountService.class, payeahCardConfig);
    }

    @Test
    public void getUserBalanceAccount() {
        AccountBalanceQry accountBalanceQry = new AccountBalanceQry();
        accountBalanceQry.setCcy("USD");
        Call<AccountBalanceCO> call = accountService.getUserBalanceAccount(accountBalanceQry);
        AccountBalanceCO response = ServiceExecutor.execute(call);
        log.info("response = {}", response);
    }
}