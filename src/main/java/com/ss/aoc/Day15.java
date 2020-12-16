package com.ss.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day15 extends AOCDay {


    public Day15() {
        this.testDataFilename = "";
        this.dataFileName = "";
    }

    @Override
    long task1(boolean isTest) {
//        List<Integer> input = new ArrayList<>(Arrays.asList(0, 3, 6));
//        List<Integer> input = new ArrayList<>(Arrays.asList(3,1,2));
        List<Integer> input = new ArrayList<>(Arrays.asList(0,8,15,2,12,1,4));
        return playSayNumbers(2019, input);
    }

    @Override
    long task2(boolean isTest) {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 8, 15, 2, 12, 1, 4));
        return playSayNumbers(29999999, input);
    }

    private long playSayNumbers(int positionToReturn, List<Integer> input) {
        Map<Integer, Integer> spokenNumbers = getMapFromInput(input);
        Map<Integer, int[]> positions = getMapOfPositionsFromInput(input);
        int lengthOfStop = input.size() + positionToReturn;
        for (int i = input.size() - 1; i <= lengthOfStop; i++) {
            Integer nr = spokenNumbers.get(input.get(i));
            if (nr != null && nr == 1) {
                spokenNumbers.merge(0, 1, Integer::sum);
                input.add(0);
                addPositionToMap(positions, 0, i + 1);
            } else {
                int difference = positions.get(input.get(i))[1] - positions.get(input.get(i))[0];
                input.add(difference);
                addPositionToMap(positions, difference, i + 1);
                spokenNumbers.merge(difference, 1, Integer::sum);
            }
            // logic here
        }

        return input.get(positionToReturn);
    }

    private void addPositionToMap(Map<Integer, int[]> positions, Integer integer, int i) {
        if(positions.get(integer) != null) {
            positions.get(integer)[0] = positions.get(integer)[1];
            positions.get(integer)[1] = i;
        } else {
            int[] poz = new int[2];
            poz[1] = i;
            positions.put(integer, poz);
        }
    }

    private Map<Integer, int[]> getMapOfPositionsFromInput(List<Integer> input) {
        Map<Integer, int[]> positions = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            int[] poz = positions.get(input.get(i));
            if (poz == null) {
                poz = new int[2];
                poz[1] = i;
                positions.put(input.get(i), poz);
            }
        }
        return positions;
    }

    private Map<Integer, Integer> getMapFromInput(List<Integer> input) {
        Map<Integer, Integer> numbers = new HashMap<>();
        input.forEach(element -> numbers.put(element, 1));
        return numbers;
    }

    private int getBeforeLastSpoken(int lastSpoken, Integer searched, List<Integer> input) {
        for (int i = lastSpoken - 1; i >= 0; i--) {
            if (input.get(i).equals(searched)) {
                return i;
            }
        }
        return -1;
    }
}
