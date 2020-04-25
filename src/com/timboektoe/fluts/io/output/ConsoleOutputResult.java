package com.timboektoe.fluts.io.output;

import com.timboektoe.fluts.model.ProfitResult;

import java.util.List;
import java.util.Set;

public class ConsoleOutputResult implements OutputResult {
    private static void printPosition(Integer p) {
        System.out.print(p + " ");
    }

    /*public void printMaxProfitResults(Integer schuurs, Integer maxProfit, Set<Integer> positions) {
        //  profitResults.forEach(result -> {
        System.out.printf("schuurs %d\n", schuurs);
        System.out.printf("Maximum profit is %d.\n", maxProfit);
        System.out.print("Number of fluts to buy: ");
        positions.forEach(ConsoleOutputResult::printPosition);
        System.out.println();
        // });

    }*/

    public void printMaxProfitResult(List<ProfitResult> profitResults) {
        profitResults.forEach(result -> {
            System.out.printf("schuurs %d\n", result.getSchuuleNumber());
            System.out.printf("Maximum profit is %d.\n", result.getMaxProfit());
            System.out.print("Number of fluts to buy: ");
            result.getOrderOfFlutsToBuy().forEach(ConsoleOutputResult::printPosition);
            System.out.println();
        });

    }
}
