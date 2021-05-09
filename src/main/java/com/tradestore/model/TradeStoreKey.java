package com.tradestore.model;

public final class TradeStoreKey {


    private final String tradeId;
    private final String counterPartyId;

    public TradeStoreKey(String tradeId, String counterPartyId) {
        this.tradeId = tradeId;
        this.counterPartyId = counterPartyId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeStoreKey)) return false;

        TradeStoreKey that = (TradeStoreKey) o;

        if (!getTradeId().equals(that.getTradeId())) return false;
        return getCounterPartyId().equals(that.getCounterPartyId());
    }

    @Override
    public int hashCode() {
        int result = getTradeId().hashCode();
        result = 31 * result + getCounterPartyId().hashCode();
        return result;
    }
}
