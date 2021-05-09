package com.tradestore.repository;

import com.tradestore.model.TradeStore;
import com.tradestore.model.TradeStoreKey;
import com.tradestore.model.dto.TradeStoreResponse;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Repository
public class TradeStoreRepository {

    private static HashMap<TradeStoreKey, HashMap<Integer, TradeStore>> tradeStoreHashMap = new HashMap<TradeStoreKey, HashMap<Integer, TradeStore>>();

    public void createTradeForNewKey(TradeStoreKey tradeStoreKey, TradeStore tradeStore, Integer version) {
        HashMap<Integer, TradeStore> integerTradeStoreHashMap = new HashMap<Integer, TradeStore>();
        integerTradeStoreHashMap.put(version, tradeStore);
        tradeStoreHashMap.put(tradeStoreKey, integerTradeStoreHashMap);
    }

    public void updateTradeStore(TradeStoreKey tradeStoreKey, TradeStore tradeStore, Integer version) {
        tradeStoreHashMap.get(tradeStoreKey).put(version, tradeStore);
    }

    public Integer getMaxVerionForKey(TradeStoreKey tradeStoreKey) {
        Set<Integer> integerSet = tradeStoreHashMap.get(tradeStoreKey).keySet();
        return Collections.max(integerSet);
    }

    public boolean isKeyPresent(TradeStoreKey tradeStoreKey) {
        return tradeStoreHashMap.keySet().contains(tradeStoreKey);
    }

    public TradeStoreResponse getTradeByKey(TradeStoreKey tradeStoreKey, Integer version) {
        return buildTradeStoreResponse(tradeStoreKey, tradeStoreHashMap.get(tradeStoreKey).get(version), version);
    }

    public List<TradeStoreResponse> getAllTrades() {
        List<TradeStoreResponse> tradeStoreResponseList = new ArrayList<>();
        if (tradeStoreHashMap != null) {
            for (Map.Entry<TradeStoreKey, HashMap<Integer, TradeStore>> tradeStoreHashMap : tradeStoreHashMap.entrySet()) {
                for (Map.Entry<Integer, TradeStore> tradeStoreEntry : tradeStoreHashMap.getValue().entrySet()) {
                    tradeStoreResponseList.add(buildTradeStoreResponse(tradeStoreHashMap.getKey(), tradeStoreEntry.getValue(), tradeStoreEntry.getKey()));
                }
            }
        }
        return tradeStoreResponseList;
    }

    private TradeStoreResponse buildTradeStoreResponse(TradeStoreKey tradeStoreKey, TradeStore tradeStore, Integer version) {
        TradeStoreResponse tradeStoreResponse = new TradeStoreResponse();
        tradeStoreResponse.setCreatedDate(tradeStore.getCreatedDate());
        tradeStoreResponse.setMaturityDate(tradeStore.getMaturityDate());
        tradeStoreResponse.setBookId(tradeStore.getBookId());
        tradeStoreResponse.setCounterPartyId(tradeStoreKey.getCounterPartyId());
        tradeStoreResponse.setTradeId(tradeStoreKey.getTradeId());
        tradeStoreResponse.setExpired(tradeStore.getExpired());
        tradeStoreResponse.setVersion(version);
        return tradeStoreResponse;
    }

    public void updateExpireFlag() {
        if (tradeStoreHashMap != null) {
            for (Map.Entry<TradeStoreKey, HashMap<Integer, TradeStore>> tradeStoreHashMap : tradeStoreHashMap.entrySet()) {
                for (Map.Entry<Integer, TradeStore> tradeStoreEntry : tradeStoreHashMap.getValue().entrySet()) {
                    if(tradeStoreEntry.getValue() != null && tradeStoreEntry.getValue().getMaturityDate() != null) {
                        if (tradeStoreEntry.getValue().getMaturityDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(LocalDate.now())) {
                            tradeStoreEntry.getValue().setExpired(true);
                        }
                    }
                }
            }
        }
    }
}
