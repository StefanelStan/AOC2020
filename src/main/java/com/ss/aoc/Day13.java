package com.ss.aoc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;

public class Day13 extends AOCDay{
    private String testDataFilename = "day13test.txt";
    private String dataFileName = "day13.txt";

    @Override
    long task1(boolean isTest) {
        List<String> data = getDataAsStringLines(isTest, testDataFilename, dataFileName);
        int time = Integer.parseInt(data.get(0));
        List<Integer> busses = getBussesFromData(data.get(1));
        int minModuloDifference = Integer.MAX_VALUE;
        int currentDifference;
        int earliestBus = 0;
        int modulo = 0;
        for (Integer bus : busses) {
            modulo = time % bus;
            if(modulo == 0) {
                minModuloDifference = modulo;
                earliestBus = bus;
                break;
            }
            currentDifference = bus - modulo;
            if (currentDifference < minModuloDifference) {
                minModuloDifference = currentDifference;
                earliestBus = bus;
            }
            if(minModuloDifference == 0) {
                break;
            }
        }
        return minModuloDifference * earliestBus;
    }

    @Override
    long task2(boolean isTest) {
        List<String> data = getDataAsStringLines(isTest, testDataFilename, dataFileName);
        Map<Long, Integer> busses = getBussesAndOffsetFromData(data.get(1));
        List<Long> onlyBusses = new ArrayList<>(busses.keySet());
        List<Long> remainders = new ArrayList<>();
        busses.forEach((bus, offset) -> remainders.add(getRealOffsetForBus(bus, offset)));
        long[] numbers = new long[busses.size()];
        long[] rmds = new long[busses.size()];
        for (int i = 0; i < remainders.size(); i++) {
            numbers[i] = onlyBusses.get(i);
            rmds[i] = remainders.get(i);
        }

        return chineseRemainder(numbers, rmds);
    }

    private List<Integer> getBussesFromData(String data) {
        List<Integer> busses = new ArrayList<>();
        StringBuilder stb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isDigit(c)) {
                stb.append(c);
            } else {
                if(!stb.isEmpty()) {
                    busses.add(Integer.parseInt(stb.toString()));
                    stb.setLength(0);
                }
            }
        }
        if(!stb.isEmpty()) {
            busses.add(Integer.parseInt(stb.toString()));
        }
        return busses;
    }

    private Map<Long, Integer> getBussesAndOffsetFromData(String data) {
        String[] chunks = data.split(",");
        Map<Long, Integer> bussesAndOffsets = new LinkedHashMap<>();
        for (int i = 0; i < chunks.length; i++) {
            if(chunks[i].length() > 1 || Character.isDigit(chunks[i].charAt(0))) {
                bussesAndOffsets.put(Long.valueOf(chunks[i]), i);
            }
        }
        return bussesAndOffsets;
    }

    private Long getRealOffsetForBus(Long bus, Integer offset) {
        if (offset < bus) {
            return bus - offset;
        } else {
            return bus - (offset % bus);
        }
    }

    private long chineseRemainder(long[] n, long[] a) {

        long prod = stream(n).reduce(1, (i, j) -> i * j);

        long p, sm = 0;
        for (int i = 0; i < n.length; i++) {
            p = prod / n[i];
            sm += a[i] * mulInv(p, n[i]) * p;
        }
        return sm % prod;
    }

    private long mulInv(long a, long b) {
        long b0 = b;
        long x0 = 0;
        long x1 = 1;

        if (b == 1)
            return 1;

        while (a > 1) {
            long q = a / b;
            long amb = a % b;
            a = b;
            b = amb;
            long xqx = x1 - q * x0;
            x1 = x0;
            x0 = xqx;
        }

        if (x1 < 0)
            x1 += b0;

        return x1;
    }
}
