package com.tradestore.service;

import com.tradestore.model.TradeStore;
import com.tradestore.model.TradeStoreException;
import com.tradestore.model.TradeStoreKey;
import com.tradestore.model.dto.TradeStoreRequest;
import com.tradestore.model.dto.TradeStoreResponse;
import com.tradestore.repository.TradeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TradeStoreService {

    @Autowired
    private TradeStoreRepository tradeStoreRepository;

    public TradeStoreResponse storeTrade(TradeStoreRequest tradeStoreRequest) throws TradeStoreException {
        TradeStoreKey tradeStoreKey = new TradeStoreKey(tradeStoreRequest.getTradeId(),
                tradeStoreRequest.getCounterPartyId());
        TradeStore tradeStore = new TradeStore(tradeStoreRequest.getBookId(),
                tradeStoreRequest.getMaturityDate(),
                new Date(), false);
        if (!tradeStoreRepository.isKeyPresent(tradeStoreKey)) {
            tradeStoreRepository.createTradeForNewKey(tradeStoreKey, tradeStore, tradeStoreRequest.getVersion());
        } else {
            if (tradeStoreRequest.getVersion() >= tradeStoreRepository.getMaxVerionForKey(tradeStoreKey)) {
                tradeStoreRepository.updateTradeStore(tradeStoreKey, tradeStore, tradeStoreRequest.getVersion());
            } else {
                throw new TradeStoreException("The requested version is rejected because next version is already present for this trade");
            }
        }
        return tradeStoreRepository.getTradeByKey(tradeStoreKey, tradeStoreRequest.getVersion());
    }

    public List<TradeStoreResponse> getAllTrades() {
        return tradeStoreRepository.getAllTrades();
    }

    @Scheduled(cron = "0 10 0 * * ?")
    //@Scheduled(cron = "0 */5 * * * *")
    private void updateExpireFlag() {
        try {
            tradeStoreRepository.updateExpireFlag();
        } catch (Exception e) {

        }
    }


}
