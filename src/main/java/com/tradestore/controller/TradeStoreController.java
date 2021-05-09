package com.tradestore.controller;

import com.tradestore.model.TradeStoreException;
import com.tradestore.model.dto.TradeStoreRequest;
import com.tradestore.model.dto.TradeStoreResponse;
import com.tradestore.service.TradeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TradeStoreController {

    @Autowired
    private TradeStoreService tradeStoreService;

    @PostMapping("/storeTrade")
    public TradeStoreResponse storeTrade(@Valid @RequestBody TradeStoreRequest tradeStoreRequest) throws TradeStoreException {
        return tradeStoreService.storeTrade(tradeStoreRequest);
    }

    @GetMapping("/getAllTrades")
    public List<TradeStoreResponse> getAllTrades() throws TradeStoreException {
        List<TradeStoreResponse> tradeStoreResponseList = tradeStoreService.getAllTrades();
        return tradeStoreResponseList;
    }

}
