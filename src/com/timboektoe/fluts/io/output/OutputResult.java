package com.timboektoe.fluts.io.output;

import com.timboektoe.fluts.model.ProfitResult;

import java.util.List;
import java.util.Set;

public interface OutputResult {
    //void printMaxProfitResults(Integer schuurs, Integer maxProfit, Set<Integer> positions);
    void printMaxProfitResult(List<ProfitResult> profitResults);
}