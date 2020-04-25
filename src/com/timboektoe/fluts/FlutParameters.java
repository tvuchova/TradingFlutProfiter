package com.timboektoe.fluts;

import java.math.BigDecimal;

public enum FlutParameters {
    SELLING_PRICE(10),MAX_NUMBER_TO_SHOW(10);

    FlutParameters(Integer  i) {
        number = i;
    }
    Integer  number;

    public Integer getNumber() {
        return number;
    }
}
