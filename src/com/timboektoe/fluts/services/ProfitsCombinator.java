package com.timboektoe.fluts.services;

import com.timboektoe.fluts.model.ProfitResult;

import java.util.*;

public class ProfitsCombinator {
    ProfitProcessor processor = new ProfitProcessor();

    public ProfitResult combineAllPilesInSchuurs(List<List<Integer>> schuuleTable, Integer schuuleCount) {
        Integer maxProfit = 0;
        List<List<Integer>> positions = new ArrayList<>();
        for (List<Integer> flutsList : schuuleTable) {
            List<Integer> profitList = processor.processPile(flutsList);
            if (checkForPositiveProfit(profitList)) {
                Integer maxValue = findMaxValue(profitList);
                maxProfit += maxValue;
                positions.add(findMaxElementPositions(profitList, maxValue));
            }
        }
        Set<Integer> flutNumbers = new TreeSet<>();
        if (!positions.isEmpty() && maxProfit > 0) {
            flutNumbers = combineAllPositions(positions);
        }

        //output.printMaxProfitResults(schuuleCount, maxProfit, flutNumbers);

        return new ProfitResult(schuuleCount, maxProfit, flutNumbers);
    }

    private boolean checkForPositiveProfit(List<Integer> profitList) {
        for (Integer integer : profitList) {
            if (integer > 0) {
                return true;
            }
        }
        return  false;
    }

    Integer findMaxValue(List<Integer> flutsList) {
        return Collections.max(flutsList);
    }

    List<Integer> findMaxElementPositions(List<Integer> flutsList, Integer max) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < flutsList.size(); i++) {
            if (flutsList.get(i).equals(max)) {
                positions.add(i + 1);
            }
        }
        return positions;
    }

    Set<Integer> combineAllPositions(List<List<Integer>> positionsTable) {
        Set<List<Integer>> combs = getFluteCombinations(positionsTable);
        Set<Integer> result = new TreeSet<>();
        int count = 0;
        for (List<Integer> list : combs) {
            count += 1;
            result.add(list.stream().reduce(0, Integer::sum));
            if (count > 10) return result;
        }

        return result;
    }

    public static <T> Set<List<T>> getFluteCombinations(List<List<T>> lists) {
        Set<List<T>> combinations = new HashSet<>();
        Set<List<T>> newCombinations;

        int index = 0;
        // extract each of the integers in the first list
        // and add each to ints as a new list
        for (T i : lists.get(0)) {
            List<T> newList = new ArrayList<>();
            newList.add(i);
            combinations.add(newList);
        }
        index++;
        while (index < lists.size()) {
            List<T> nextList = lists.get(index);
            newCombinations = new HashSet<>();
            for (List<T> first : combinations) {
                for (T second : nextList) {
                    List<T> newList = new ArrayList<>(first);
                    newList.add(second);
                    newCombinations.add(newList);
                }
            }
            combinations = newCombinations;

            index++;
        }

        return combinations;
    }
}
