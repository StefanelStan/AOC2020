package com.ss.aoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day10 {
    private String inputTestData1 = "16\n" +
            "10\n" +
            "15\n" +
            "5\n" +
            "1\n" +
            "11\n" +
            "7\n" +
            "19\n" +
            "6\n" +
            "12\n" +
            "4";
    private String inputTestData2 = "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3";

    private String inputData = "56\n" +
            "139\n" +
            "42\n" +
            "28\n" +
            "3\n" +
            "87\n" +
            "142\n" +
            "57\n" +
            "147\n" +
            "6\n" +
            "117\n" +
            "95\n" +
            "2\n" +
            "112\n" +
            "107\n" +
            "54\n" +
            "146\n" +
            "104\n" +
            "40\n" +
            "26\n" +
            "136\n" +
            "127\n" +
            "111\n" +
            "47\n" +
            "8\n" +
            "24\n" +
            "13\n" +
            "92\n" +
            "18\n" +
            "130\n" +
            "141\n" +
            "37\n" +
            "81\n" +
            "148\n" +
            "31\n" +
            "62\n" +
            "50\n" +
            "80\n" +
            "91\n" +
            "33\n" +
            "77\n" +
            "1\n" +
            "96\n" +
            "100\n" +
            "9\n" +
            "120\n" +
            "27\n" +
            "97\n" +
            "60\n" +
            "102\n" +
            "25\n" +
            "83\n" +
            "55\n" +
            "118\n" +
            "19\n" +
            "113\n" +
            "49\n" +
            "133\n" +
            "14\n" +
            "119\n" +
            "88\n" +
            "124\n" +
            "110\n" +
            "145\n" +
            "65\n" +
            "21\n" +
            "7\n" +
            "74\n" +
            "72\n" +
            "61\n" +
            "103\n" +
            "20\n" +
            "41\n" +
            "53\n" +
            "32\n" +
            "44\n" +
            "10\n" +
            "34\n" +
            "121\n" +
            "114\n" +
            "67\n" +
            "69\n" +
            "66\n" +
            "82\n" +
            "101\n" +
            "68\n" +
            "84\n" +
            "48\n" +
            "73\n" +
            "17\n" +
            "43\n" +
            "140\n";

    List<Integer> lines =new LinkedList<>();
    Map<Integer, Long> counter = new HashMap<>();


    public int getJoltDifference() {
        return getJoltDifference(inputData);
    }

    private int getJoltDifference(String data) {
        int[] adapters = getSortedAdapters(data);
        Map<Integer, Integer> differences = new HashMap<>();
        int currentJoltage = 0;
        int currentDifference = 0;
        for (int adapter : adapters) {
            currentDifference = adapter - currentJoltage;
            if (currentDifference <= 3) {
                differences.merge(currentDifference, 1, Integer::sum);
                currentJoltage = adapter;
            } else {
                break;
            }
        }

        return differences.get(1) * (differences.get(3) + 1);
    }

    public long getPermutations() {
        return getPermutations(inputData);
    }

    private int[] getSortedAdapters(String data) {
        String[] chunks = data.split("\n");
        int[] adapters = new int[chunks.length];
        for (int i = 0; i < chunks.length; i++) {
            adapters[i] = Integer.parseInt(chunks[i]);
        }
        Arrays.sort(adapters);
        return adapters;
    }

    private Integer[] getSortedAdaptersList(String data) {
        String[] chunks = data.split("\n");
        Integer[] adapters = new Integer[chunks.length];
        for (int i = 0; i < chunks.length; i++) {
            adapters[i] = Integer.parseInt(chunks[i]);
        }
        Arrays.sort(adapters);
        return adapters;
    }


    private long getPermutations(String data) {
        Integer[] adapters = getSortedAdaptersList(data);
        lines.addAll(Arrays.asList(adapters));
        lines.add(0, 0);
        return checkBranch(0);
    }

    private long checkBranch(int i) {
        if (i == (lines.size() - 1)) return 1;
        if (counter.containsKey(i)) return counter.get(i);
        long permutations = 0;
        for (int j = i + 1; j < lines.size(); j++) {
            if (lines.get(j) - lines.get(i) > 3) break;
            permutations += checkBranch(j);
        }
        counter.put(i, permutations);
        return permutations;
    }
}
