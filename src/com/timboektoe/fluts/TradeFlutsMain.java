package com.timboektoe.fluts;

import com.timboektoe.fluts.io.input.ConsoleDataReader;

import com.timboektoe.fluts.io.output.ConsoleOutputResult;
import com.timboektoe.fluts.io.output.OutputResult;
import com.timboektoe.fluts.model.ProfitResult;
import com.timboektoe.fluts.services.ProfitProcessor;
import com.timboektoe.fluts.services.ProfitsCombinator;


import java.util.*;
import java.util.concurrent.CompletableFuture;


public class TradeFlutsMain {
    private static final String END_OF_INPUT = "0";

    public static void main(String[] args) {
        ConsoleDataReader consoleDataReader = new ConsoleDataReader();
        ProfitsCombinator processor = new ProfitsCombinator();
        ProfitProcessor profit = new ProfitProcessor();
        OutputResult output = new ConsoleOutputResult();

        System.out.println("Please enter input test cases");
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            List<CompletableFuture<ProfitResult>> completableFutures = new ArrayList<>();
            while (!line.equals(END_OF_INPUT)) {

                int numberOfSchuurs = Integer.parseInt(line);
                List<List<Integer>> priceFlutsTable = consoleDataReader.readAllSchuurs(scanner, numberOfSchuurs);

                CompletableFuture<ProfitResult> profitResultCompletableFuture = CompletableFuture.supplyAsync(() ->
                        processor.combineAllPilesInSchuurs(priceFlutsTable, numberOfSchuurs));
                completableFutures.add(profitResultCompletableFuture);

                line = scanner.nextLine();
            }
            CompletableFuture<List<ProfitResult>> listCompletableFuture = profit.allOf(completableFutures);
            List<ProfitResult> profitResultsList = listCompletableFuture.join();
            output.printMaxProfitResult(profitResultsList);
        }
    }
}
