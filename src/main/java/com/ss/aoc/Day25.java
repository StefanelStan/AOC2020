package com.ss.aoc;

import java.util.List;

public class Day25 extends AOCDay {
    private static final int SECRET_NUMBER = 7;

    public Day25() {
        this.dataFileName = "day25.txt";
        this.testDataFilename = "day25test.txt";
    }

    @Override
    long task1(boolean isTest) {
        List<String> input = getDataAsStringLines(isTest);
        int cardPublicKey = Integer.parseInt(input.get(0));
        int doorPublicKey = Integer.parseInt(input.get(1));

        int cardLoopSize = getLoopSize(cardPublicKey, 7);
        int doorLoopSize = getLoopSize(doorPublicKey, 7);
        long encriptionKey = getEncryptionKey(doorLoopSize, cardPublicKey);
        long encriptionKey2 = getEncryptionKey(cardLoopSize, doorPublicKey);
        if (encriptionKey != encriptionKey2) {
            throw new RuntimeException("Incorrect Encription keys");
        }
        return encriptionKey;
    }

    private int getLoopSize(int cardPublicKey, int secretNumber) {
        int currentValue = 1;
        for (int i = 1;; i++) {
            currentValue = (currentValue * secretNumber) % 20201227;
            if (currentValue == cardPublicKey) {
                return i;
            }
        }
    }

    private long getEncryptionKey(int loopSize, int secretNumber) {
        long currentValue = 1;
        for (int i = 0; i < loopSize; i++) {
            currentValue = (currentValue * secretNumber) % 20201227;
        }
        return currentValue;
    }

    @Override
    long task2(boolean isTest) {
        return 0;
    }
}
