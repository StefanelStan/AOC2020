package com.ss.aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 extends AOCDay{
    private final String testDataFilename = "day14test.txt";
    private final String dataFileName = "day14.txt";

    @Override
    protected String getTestDataFileName() {
        return this.testDataFilename;
    }

    @Override
    protected String getDataFileName() {
        return this.dataFileName;
    }

    @Override
    long task1(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        return processLinesAndGetFinalByte(lines);
    }

    @Override
    long task2(boolean isTest) {
        return 0;
    }

    private long processLinesAndGetFinalByte(List<String> lines) {
        Map<Integer, String> memory = new HashMap<>();
        String mask = null;
        for(String line: lines) {
            if(line.contains("mask")) {
                mask = line.substring(7);
            } else {
                // read line, applyMask and put in map
                applyMaskAndWriteToMemory(line, mask, memory);
            }

        }
        long[] sum = new long[1];
        memory.values().forEach(value -> { sum[0] += Long.parseLong(value, 2);});
        return sum[0];
    }

    private void applyMaskAndWriteToMemory(String line, String mask, Map<Integer, String> memory) {
        int address = Integer.parseInt(line.substring(4, line.indexOf(']')));
        final StringBuffer result = new StringBuffer();
        final StringBuffer number = new StringBuffer("000000000000000000000000000000000000");
        String binaryInt = Integer.toString(Integer.parseInt(line.substring(line.indexOf("= ") + 2)), 2);
        number.replace(number.length() - binaryInt.length(), number.length(), binaryInt);
        for (int i = 0; i < mask.length(); i++) {
            if(mask.charAt(i) == 'X') {
                result.append(number.charAt(i));
            } else {
                result.append(mask.charAt(i));
            }
        }
        memory.put(address, result.toString());
    }
}
