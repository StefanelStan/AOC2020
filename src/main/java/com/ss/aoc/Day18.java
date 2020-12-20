package com.ss.aoc;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class Day18 extends AOCDay {

    public Day18() {
        this.testDataFilename = "day18test.txt";
        this.dataFileName = "day18.txt";
    }

    @Override
    long task1(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        final long[] sum = { 0 };
        lines.forEach(line -> sum[0] += getResultOFParanthesisOperation(line));
        return sum[0];
    }

    private long getResultOFParanthesisOperation(String line) {
        StringBuilder stb = new StringBuilder();
        List<Integer> lop = new LinkedList<>();
        int elementContor = -1;
        for (char element : line.toCharArray()) {
            if (element != ' ') {
                elementContor++;
                if (element == '(') {
                    lop.add(elementContor);
                    stb.append(element);
                } else if (element == ')') {
                    stb.replace(lop.get(lop.size() - 1), elementContor,
                            String.valueOf(getResultOfPlainOperation(stb.substring(lop.get(lop.size() - 1) + 1))));
                    elementContor = stb.length() - 1;
                    lop.remove(lop.size() - 1);
                } else {
                    stb.append(element);
                }

            }
        }
        return (lop.isEmpty()) ? getResultOfPlainOperation(stb.toString()) : getResultOFParanthesisOperation(stb.toString());
    }

    private long getResultOfPlainOperation(String operation) {
        String[] numbers = StringUtils.split(operation, "*+");
        long result = Long.parseLong(numbers[0]);
        int signIndex = 0;
        for (char c : operation.toCharArray()) {
            if (c == '*' || c == '+') {
                signIndex++;
                result = calculateOperation(result, c, Long.parseLong(numbers[signIndex]));
            }
        }
        return result;
    }

    private long calculateOperation(long left, char operation, long right) {
        return operation == '+' ? left + right : left * right;
    }


    @Override
    long task2(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        final long[] sum = { 0 };
        lines.forEach(line -> {
            long partialSum = getResultOFParanthesisOperationAdvanced(line);
            sum[0] += partialSum;
        });
        return sum[0];
    }

    private long getResultOFParanthesisOperationAdvanced(String line) {
        StringBuilder stb = new StringBuilder();
        List<Integer> lop = new LinkedList<>();
        int elementContor = -1;
        for (char element : line.toCharArray()) {
            if (element != ' ') {
                elementContor++;
                if (element == '(') {
                    lop.add(elementContor);
                    stb.append(element);
                } else if (element == ')') {
                    stb.replace(lop.get(lop.size() - 1), elementContor,
                            String.valueOf(getResultOfPlainOperationAdvanced(stb.substring(lop.get(lop.size() - 1) + 1))));
                    elementContor = stb.length() - 1;
                    lop.remove(lop.size() - 1);
                } else {
                    stb.append(element);
                }

            }
        }
        return (lop.isEmpty()) ? getResultOfPlainOperationAdvanced(stb.toString()) : getResultOFParanthesisOperationAdvanced(stb.toString());
    }

    private long getResultOfPlainOperationAdvanced(String operation) {
        String[] segmentsToProcess = StringUtils.split(operation, "*");
        long result = 1;
        for (String segment : segmentsToProcess) {
            result *= getValueOfSegment(segment);
        }
        return result;
    }

    private long getValueOfSegment(String segment) {
        String[] numbers = StringUtils.split(segment, "+");
        long result = 0;
        for (String number : numbers) {
            result += Long.parseLong(number);
        }
        return result;
    }
}
