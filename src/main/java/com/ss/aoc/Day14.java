package com.ss.aoc;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 extends AOCDay {
    private String testDataFilename = "day14test.txt";
    private final String dataFileName = "day14.txt";

    @Override
    long task1(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        return processLinesAndGetFinalByte(lines);
    }

    @Override
    long task2(boolean isTest) {
        this.testDataFilename = "day14test2.txt";
        List<String> lines = getDataAsStringLines(isTest);
        return processLinesAndGetFinalSum(lines);
    }

    private long processLinesAndGetFinalSum(List<String> lines) {
        Map<Long, Integer> memory = new HashMap<>();
        Map<Integer, String[]> binaryCombinations = new HashMap<>();
        String mask = null;
        for (String line : lines) {
            if (line.contains("mask")) {
                mask = line.substring(7);
            } else {
                // read line, applyMask and put in map
                applyMaskAndWriteToMemoryLines(line, mask, memory, binaryCombinations);
            }

        }
        long[] sum = new long[1];
        memory.values().forEach(value -> sum[0] += value);
        return sum[0];
    }

    private long processLinesAndGetFinalByte(List<String> lines) {
        Map<Integer, String> memory = new HashMap<>();
        String mask = null;
        for (String line : lines) {
            if (line.contains("mask")) {
                mask = line.substring(7);
            } else {
                // read line, applyMask and put in map
                applyMaskAndWriteToMemory(line, mask, memory);
            }

        }
        long[] sum = new long[1];
        memory.values().forEach(value -> sum[0] += Long.parseLong(value, 2));
        return sum[0];
    }

    private void applyMaskAndWriteToMemory(String line, String mask, Map<Integer, String> memory) {
        int address = Integer.parseInt(line.substring(4, line.indexOf(']')));
        final StringBuilder result = new StringBuilder();
        final StringBuilder number = new StringBuilder("000000000000000000000000000000000000");
        String binaryInt = Integer.toString(Integer.parseInt(line.substring(line.indexOf("= ") + 2)), 2);
        number.replace(number.length() - binaryInt.length(), number.length(), binaryInt);
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == 'X') {
                result.append(number.charAt(i));
            } else {
                result.append(mask.charAt(i));
            }
        }
        memory.put(address, result.toString());
    }


    private void applyMaskAndWriteToMemoryLines(String line, String mask, Map<Long, Integer> memory, Map<Integer, String[]> binaryCombinations) {
        int address = Integer.parseInt(line.substring(4, line.indexOf(']')));
        String[] derivedAddresses = getDerivedAddresses(address, mask, binaryCombinations);
        for (String derivedAddress : derivedAddresses) {
            memory.put(Long.valueOf(derivedAddress, 2), Integer.parseInt(line.substring(line.indexOf("= ") + 2)));
        }
    }

    private String[] getDerivedAddresses(int address, String mask, Map<Integer, String[]> binaryCombinations) {
        final StringBuilder binaryAddress = new StringBuilder("000000000000000000000000000000000000");
        final StringBuilder floatingAddress = new StringBuilder();
        String binaryInt = Integer.toString(address, 2);
        binaryAddress.replace(binaryAddress.length() - binaryInt.length(), binaryAddress.length(), binaryInt);
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == 'X') {
                floatingAddress.append('X');
            } else if (mask.charAt(i) == '1') {
                floatingAddress.append('1');
            } else {
                floatingAddress.append(binaryAddress.charAt(i));
            }
        }
        return getAllDerivedAddresses(floatingAddress, binaryCombinations);
    }

    private String[] getAllDerivedAddresses(StringBuilder floatingAddress, Map<Integer, String[]> binaryCombinations) {
        int floatingPoints = (int) floatingAddress.chars().filter(c -> c == 'X').count();
        String[] rawBinaryCombinations = getBinaryCombinations(floatingPoints, binaryCombinations);
        String[] derivedAddresses = new String[rawBinaryCombinations.length];
        StringBuilder stb;
        for (int i = 0; i <rawBinaryCombinations.length; i++) {
            int floatingIndex = 0;
            stb  = new StringBuilder(floatingAddress);
            for (int j = 0; j < floatingAddress.length(); j++) {
                if (floatingAddress.charAt(j) == 'X') {
                    stb.setCharAt(j, rawBinaryCombinations[i].charAt(floatingIndex));
                    floatingIndex++;
                }
            }
            derivedAddresses[i] = stb.toString();
        }
        return derivedAddresses;
    }

    private String[] getBinaryCombinations(int floatingPoints, Map<Integer, String[]> binaryCombinations) {
        if (binaryCombinations.containsKey(floatingPoints)) {
            return binaryCombinations.get(floatingPoints);
        } else {
            int maxCombinations = (int) (Math.pow(2, floatingPoints));
            StringBuilder stamp = getStringBuilderStamp(floatingPoints);
            StringBuilder tempStb;
            String binaryRepr;
            String[] combinations = new String[maxCombinations];
            for (int i = 0; i < maxCombinations; i++) {
                binaryRepr = Integer.toString(i, 2);
                tempStb = new StringBuilder(stamp);
                tempStb.replace(tempStb.length() - binaryRepr.length(), tempStb.length(), binaryRepr);
                combinations[i] = tempStb.toString();
            }
            binaryCombinations.put(floatingPoints, combinations);
            return combinations;
        }
    }

    private StringBuilder getStringBuilderStamp(int floatingPoints) {
        StringBuilder stb = new StringBuilder();
        stb.append("0".repeat(Math.max(0, floatingPoints)));
        return stb;
    }
}
