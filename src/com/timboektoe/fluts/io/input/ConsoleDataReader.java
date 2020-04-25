package com.timboektoe.fluts.io.input;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleDataReader {
    public List<List<Integer>> readAllSchuurs(Scanner scanner, int numberSchuurs) {
        List<List<Integer>> pricePilesTable = new ArrayList<>();

        for (int i = 0; i < numberSchuurs; i++) {
            String lineFluts = scanner.nextLine();
            if  (lineFluts.contains(" ")) {
                List<Integer> intFluts = Arrays.stream(lineFluts.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                pricePilesTable.add(intFluts);
            }
        }
        return pricePilesTable;
    }
}
