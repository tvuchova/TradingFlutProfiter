package com.timboektoe.fluts.io.input;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleDataReader implements Reader {
    public List<List<Integer>> readAllSchuurs(Scanner scanner, int numberSchuurs) {
        List<List<Integer>> pricePilesTable = new ArrayList<>();

        for (int i = 0; i < numberSchuurs; i++) {
            String lineFluts = scanner.nextLine();
            while (lineFluts.length() < 3 || !lineFluts.contains(" ") || Character.getNumericValue(lineFluts.charAt(0)) != getLineCountIntervals(lineFluts)) {
                System.out.println("Please enter the line again as it's not valid..");
                lineFluts = scanner.nextLine();
            }

            List<Integer> intFluts = Arrays.stream(lineFluts.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            pricePilesTable.add(intFluts);
        }
        return pricePilesTable;
    }

    private long getLineCountIntervals(String lineFluts) {
        return lineFluts.chars().filter(c -> c == (int) ' ').count();
    }
}
