package com.tradestore.repository;

import com.tradestore.model.TradeStore;
import com.tradestore.model.TradeStoreKey;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Date;


public class TradeStoreRepositoryTest {

    @InjectMocks
    private TradeStoreRepository tradeStoreRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        TradeStoreKey tradeStoreKey = new TradeStoreKey("T1", "CP-1");
        TradeStore tradeStore = new TradeStore("B1", new Date(), new Date(), false);
        tradeStoreRepository.createTradeForNewKey(tradeStoreKey, tradeStore, 2);
    }

    @Test
    public void test_createTradeForNewKey() {
        TradeStoreKey tradeStoreKey = new TradeStoreKey("T2", "CP-2");
        TradeStore tradeStore = new TradeStore("B2", new Date(), new Date(), false);
        tradeStoreRepository.createTradeForNewKey(tradeStoreKey, tradeStore, 1);
        Assert.assertNotNull(tradeStoreRepository.getTradeByKey(tradeStoreKey, 1));
    }

    @Test
    public void test_updateTradeStore() {
        TradeStoreKey tradeStoreKey = new TradeStoreKey("T1", "CP-1");
        TradeStore tradeStore = new TradeStore("B2", new Date(), new Date(), false);
        tradeStoreRepository.updateTradeStore(tradeStoreKey, tradeStore, 2);
        Assert.assertNotNull(tradeStoreRepository.getTradeByKey(tradeStoreKey, 2));
        Assert.assertSame("B2", tradeStoreRepository.getTradeByKey(tradeStoreKey, 2).getBookId());
    }

    public void test_getMaxVerionForKey() {
        TradeStoreKey tradeStoreKey = new TradeStoreKey("T1", "CP-1");
        Integer result = tradeStoreRepository.getMaxVerionForKey(tradeStoreKey);
        Assert.assertSame(2, result);
    }

}
