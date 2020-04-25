package com.timboektoe.fluts.services;

import com.timboektoe.fluts.FlutParameters;


import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ProfitProcessor {
    public <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> futuresList) {
        CompletableFuture<Void> allFuturesResult =
                CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]));
        return allFuturesResult.thenApply(v ->
                futuresList.stream().
                        map(CompletableFuture::join).
                        collect(Collectors.toList())
        );
    }

    public List<Integer> processPile(List<Integer> flutsList) {
        List<Integer> profits = new ArrayList<>();
        //flutsList.get(0) validaion with size
        //if (flutsList.get(0) != flutsList.size()) throw new ValidationException("Invalid input")
        for (int i = 1; i < flutsList.size(); i++) {
            if (i != 1) {
                profits.add(FlutParameters.SELLING_PRICE.getNumber() - flutsList.get(i) + profits.get(i - 2));
            } else {
                profits.add(FlutParameters.SELLING_PRICE.getNumber() - flutsList.get(i));
            }
        }

        return profits;
    }


}
