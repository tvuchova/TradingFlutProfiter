package com.timboektoe.fluts.model;

import java.util.Set;

public final class ProfitResult {
    private final Integer schuuleNumber;

    private final Integer maxProfit;

    private final Set<Integer> orderOfFlutsToBuy;

    public ProfitResult(Integer schuuleNumber, Integer maxProfit, Set<Integer> orderOfFlutsToBuy) {
        this.schuuleNumber = schuuleNumber;
        this.maxProfit = maxProfit;
        this.orderOfFlutsToBuy = orderOfFlutsToBuy;
    }

    public Integer getSchuuleNumber() {
        return schuuleNumber;
    }

    public Integer getMaxProfit() {
        return maxProfit;
    }

    public Set<Integer> getOrderOfFlutsToBuy() {
        return orderOfFlutsToBuy;
    }
}
