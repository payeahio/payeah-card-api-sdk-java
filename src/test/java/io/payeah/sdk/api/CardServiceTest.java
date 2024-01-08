package io.payeah.sdk.api;

import io.payeah.sdk.config.PayeahCardConfig;
import io.payeah.sdk.request.CardCloseCmd;
import io.payeah.sdk.request.CardCreateCmd;
import io.payeah.sdk.request.CardInfoQry;
import io.payeah.sdk.request.CardModifyCmd;
import io.payeah.sdk.request.CardOpsQry;
import io.payeah.sdk.request.CardRechargeCmd;
import io.payeah.sdk.request.CardRefundCmd;
import io.payeah.sdk.request.CardTransQry;
import io.payeah.sdk.response.AuthTansInfoCO;
import io.payeah.sdk.response.CardInfoCO;
import io.payeah.sdk.response.CardOpsTransInfoCO;
import io.payeah.sdk.response.CreateCardCO;
import io.payeah.sdk.response.OrderCmdCO;
import io.payeah.sdk.response.OrderMofifyCmdCO;
import io.payeah.sdk.response.PageCO;
import io.payeah.sdk.response.SettlementTansInfoCO;
import io.payeah.sdk.utils.ServiceCreator;
import io.payeah.sdk.utils.ServiceExecutor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import retrofit2.Call;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author : david.chen
 * email : david@payeah.io
 * created : 2023/12/4
 * description :
 **/
@Slf4j
public class CardServiceTest {
    private CardService cardService;

    @Before
    public void setUp() throws Exception {
        Yaml yaml = new Yaml();
        PayeahCardConfig payeahCardConfig = yaml.loadAs(this.getClass().getClassLoader().getResourceAsStream("config.yml"), PayeahCardConfig.class);
        cardService = ServiceCreator.create(CardService.class, payeahCardConfig);
    }

    @Test
    public void createCard() {
        CardCreateCmd cardCreateCmd = new CardCreateCmd();
        cardCreateCmd.setClientOrderId(UUID.randomUUID().toString());
        cardCreateCmd.setLocalCurrency("USD");
        cardCreateCmd.setStartDate(new Date());
        cardCreateCmd.setEndDate(DateUtils.addDays(new Date(), 7));
        cardCreateCmd.setAuthLimitAmount(1000.0);
        cardCreateCmd.setEnableMultiUse(1);
        cardCreateCmd.setEnableCurrencyCheck(1);
        cardCreateCmd.setCardAlias("api-test");
        cardCreateCmd.setBinRangeId("522981");
        Call<CreateCardCO> call = cardService.createCard(cardCreateCmd);
        CreateCardCO execute = ServiceExecutor.execute(call);
        assertNotNull(execute);
        log.info("createCardCO = {}", execute);
    }

    @Test
    public void closeCard() {
        CardCloseCmd cardCloseCmd = new CardCloseCmd();
        cardCloseCmd.setClientOrderId(UUID.randomUUID().toString());
        cardCloseCmd.setCardId("2312041349000014743");
        Call<OrderCmdCO> call = cardService.closeCard(cardCloseCmd);
        OrderCmdCO execute = ServiceExecutor.execute(call);
        assertNotNull(execute);
        log.info("orderCmdCO = {}", execute);
    }

    @Test
    public void cardRecharge() {
        CardRechargeCmd cardRechargeCmd = new CardRechargeCmd();
        cardRechargeCmd.setClientOrderId(UUID.randomUUID().toString());
        cardRechargeCmd.setCardId("2312041349000014743");
        cardRechargeCmd.setAmount(100.00);
        Call<OrderCmdCO> call = cardService.cardRecharge(cardRechargeCmd);
        OrderCmdCO execute = ServiceExecutor.execute(call);
        assertNotNull(execute);
        log.info("orderCmdCO = {}", execute);
    }

    @Test
    public void getCardInfo() {
        CardInfoQry cardInfoQry = new CardInfoQry();
        cardInfoQry.setCardId("2401081008000015635");
        Call<CardInfoCO> call = cardService.getCardInfo(cardInfoQry);
        CardInfoCO execute = ServiceExecutor.execute(call);
        assertNotNull(execute);
        log.info("CardInfoCO = {}", execute);
    }

    @Test
    public void getCardAuthTransactionList() {
        CardTransQry cardTransQry = new CardTransQry();
        cardTransQry.setBeginTime(DateUtils.addDays(new Date(), -40));
        cardTransQry.setEndTime(new Date());
        cardTransQry.setPageSize(1);
        cardTransQry.setCurrentPage(1);
        Call<PageCO<AuthTansInfoCO>> cardAuthTransactionList = cardService.getCardAuthTransactionList(cardTransQry);
        PageCO<AuthTansInfoCO> execute = ServiceExecutor.execute(cardAuthTransactionList);
        assertNotNull(execute);
        log.info("PageCO<AuthTansInfoCO> = {}", execute);
    }

    @Test
    public void getCardSettlementTransactionList() {
        CardTransQry cardTransQry = new CardTransQry();
        cardTransQry.setBeginTime(DateUtils.addDays(new Date(), -40));
        cardTransQry.setEndTime(new Date());
        cardTransQry.setPageSize(1);
        cardTransQry.setCurrentPage(1);
        Call<PageCO<SettlementTansInfoCO>> cardAuthTransactionList = cardService.getCardSettlementTransactionList(cardTransQry);
        PageCO<SettlementTansInfoCO> execute = ServiceExecutor.execute(cardAuthTransactionList);
        assertNotNull(execute);
        log.info("PageCO<SettlementTansInfoCO> = {}", execute);
    }

    @Test
    public void cardRefund() {
        CardRefundCmd cardRefundCmd = new CardRefundCmd();
        cardRefundCmd.setClientOrderId(UUID.randomUUID().toString());
        cardRefundCmd.setCardId("2312041349000014743");
        cardRefundCmd.setRefundAmount(100.00);
        Call<OrderCmdCO> call = cardService.cardRefund(cardRefundCmd);
        OrderCmdCO execute = ServiceExecutor.execute(call);
        assertNotNull(execute);
        log.info("orderCmdCO = {}", execute);
    }

    @Test
    public void modifyCard() {
        CardModifyCmd cardModifyCmd = new CardModifyCmd();
        cardModifyCmd.setClientOrderId(UUID.randomUUID().toString());
        cardModifyCmd.setCardId("2312041349000014743");
        cardModifyCmd.setCardAlias("api-test-modify");
        cardModifyCmd.setCardLabel("api-test-modify");
        cardModifyCmd.setStatus(1);
        Call<OrderMofifyCmdCO> call = cardService.modifyCard(cardModifyCmd);
        OrderMofifyCmdCO execute = ServiceExecutor.execute(call);
        assertNotNull(execute);
        log.info("OrderModifyCmdCO = {}", execute);
    }

    @Test
    public void getCardOpsTransactionList() {
        CardOpsQry cardOpsQry = new CardOpsQry();
        cardOpsQry.setBeginTime(DateUtils.addDays(new Date(), -40));
        cardOpsQry.setEndTime(new Date());
        cardOpsQry.setPageSize(1);
        cardOpsQry.setCurrentPage(1);
        Call<PageCO<CardOpsTransInfoCO>> cardOpsTransactionList = cardService.getCardOpsTransactionList(cardOpsQry);
        PageCO<CardOpsTransInfoCO> execute = ServiceExecutor.execute(cardOpsTransactionList);
        assertNotNull(execute);
        log.info("PageCO<CardOpsTransInfoCO> = {}", execute);
    }
}