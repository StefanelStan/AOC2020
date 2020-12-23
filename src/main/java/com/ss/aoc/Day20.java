package com.ss.aoc;

import java.util.List;

public class Day20 extends AOCDay {

    public Day20() {
        this.dataFileName = "day20.txt";
        this.testDataFilename = "day20test.txt";
    }

    @Override
    long task1(boolean isTest) {
        // 1line of Tile and 10 lines of content
        List<String> lines = getDataAsStringLines(isTest);
        int nrOfTiles = (lines.size() + 1) / 12;
        return 1;
    }

    @Override
    long task2(boolean isTest) {
        return 0;
    }
}
