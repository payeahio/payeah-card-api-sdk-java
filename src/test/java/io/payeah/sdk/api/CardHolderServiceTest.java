package io.payeah.sdk.api;

import io.payeah.sdk.config.PayeahCardConfig;
import io.payeah.sdk.request.CardHolderCreateCmd;
import io.payeah.sdk.request.CardHolderDelCmd;
import io.payeah.sdk.request.CardHolderInfoQry;
import io.payeah.sdk.response.CardHolderCmdCO;
import io.payeah.sdk.response.CardHolderInfoCO;
import io.payeah.sdk.utils.ServiceCreator;
import io.payeah.sdk.utils.ServiceExecutor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import retrofit2.Call;

import static org.junit.Assert.*;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/4
 * description :
 **/
@Slf4j
public class CardHolderServiceTest {
    private CardHolderService cardHolderService;

    @Before
    public void setUp() throws Exception {
        Yaml yaml = new Yaml();
        PayeahCardConfig payeahCardConfig = yaml.loadAs(this.getClass().getClassLoader().getResourceAsStream("config.yml"), PayeahCardConfig.class);
        cardHolderService = ServiceCreator.create(CardHolderService.class, payeahCardConfig);
    }

    @Test
    public void createCardHolder() {
        CardHolderCreateCmd cardHolderCreateCmd = new CardHolderCreateCmd();
        cardHolderCreateCmd.setFirstName("david");
        cardHolderCreateCmd.setLastName("chen");
        cardHolderCreateCmd.setEmail("test@gmail.com");
        cardHolderCreateCmd.setMobilePrefix("1");
        cardHolderCreateCmd.setMobile("1234567890");
        cardHolderCreateCmd.setBirthDate("1990-01-01");
        cardHolderCreateCmd.setCountryCode("USA");
        cardHolderCreateCmd.setBillingState("AR");
        cardHolderCreateCmd.setBillingCity("test");
        cardHolderCreateCmd.setBillingAddress("test");
        cardHolderCreateCmd.setBillingZipCode("123456");
        Call<CardHolderCmdCO> cardHolder = cardHolderService.createCardHolder(cardHolderCreateCmd);
        CardHolderCmdCO execute = ServiceExecutor.execute(cardHolder);
        assertNotNull(execute);
        log.info("execute = {}", execute);
    }

    @Test
    public void getCardHolderInfo() {
        CardHolderInfoQry cardHolderInfoQry = new CardHolderInfoQry();
        cardHolderInfoQry.setCardUserId("2312041208000000727");
        Call<CardHolderInfoCO> cardHolder = cardHolderService.getCardHolderInfo(cardHolderInfoQry);
        CardHolderInfoCO execute = ServiceExecutor.execute(cardHolder);
        assertNotNull(execute);
        log.info("execute = {}", execute);
    }

    @Test
    public void deleteCardHolder() {
        CardHolderDelCmd cardHolderCmd = new CardHolderDelCmd();
        cardHolderCmd.setCardUserId("2312041208000000727");
        Call<CardHolderCmdCO> cardHolder = cardHolderService.deleteCardHolder(cardHolderCmd);
        CardHolderCmdCO execute = ServiceExecutor.execute(cardHolder);
        assertNotNull(execute);
        log.info("execute = {}", execute);
    }
}