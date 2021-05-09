package com.tradestore.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tradestore.model.TradeStoreException;
import com.tradestore.model.dto.TradeStoreRequest;
import com.tradestore.model.dto.TradeStoreResponse;
import com.tradestore.service.TradeStoreService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
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
