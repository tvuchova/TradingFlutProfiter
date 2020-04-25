package com.timboektoe.fluts.io.output;

import com.timboektoe.fluts.model.ProfitResult;

import java.util.List;

public class FileOutputResult implements OutputResult{
    @Override
    public void printMaxProfitResult(List<ProfitResult> profitResults) {
        throw new IllegalArgumentException("Output to file will be developed in next version");
    }
}
