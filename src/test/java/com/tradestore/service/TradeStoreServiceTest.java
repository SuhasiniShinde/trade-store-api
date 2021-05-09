package com.tradestore.service;

import com.tradestore.model.TradeStoreException;
import com.tradestore.model.dto.TradeStoreRequest;
import com.tradestore.model.dto.TradeStoreResponse;
import com.tradestore.repository.TradeStoreRepository;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TradeStoreServiceTest {

    @InjectMocks
    private TradeStoreService tradeStoreService;

    @Mock
    private TradeStoreRepository tradeStoreRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public void test_storeTrade() throws TradeStoreException {
        TradeStoreRequest tradeStoreRequest = Mockito.mock(TradeStoreRequest.class);
        TradeStoreResponse tradeStoreResponse = tradeStoreService.storeTrade(tradeStoreRequest);
        Assert.assertNotNull(tradeStoreResponse);
    }


}
