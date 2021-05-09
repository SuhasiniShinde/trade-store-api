package com.tradestore.controller;

import com.tradestore.model.TradeStoreException;
import com.tradestore.model.dto.TradeStoreRequest;
import com.tradestore.model.dto.TradeStoreResponse;
import com.tradestore.service.TradeStoreService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

public class TradeStoreControllerTest {

    @InjectMocks
    private TradeStoreController tradeStoreController;

    @Mock
    private TradeStoreService tradeStoreService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_storeTrade() throws TradeStoreException {
        TradeStoreRequest tradeStoreRequest = Mockito.mock(TradeStoreRequest.class);
        Mockito.when(tradeStoreService.storeTrade(tradeStoreRequest)).thenReturn(Mockito.mock(TradeStoreResponse.class));
        TradeStoreResponse response = tradeStoreController.storeTrade(tradeStoreRequest);
        assertNotNull(response);
    }

}
