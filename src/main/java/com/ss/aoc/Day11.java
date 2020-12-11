package com.ss.aoc;

import java.util.Arrays;
import java.util.List;

public class Day11 {
    private final static char EMPTY_SEAT = 'L';
    private final static char OCCUPIED_SEAT = '#';

    private String inputTestData = "L.LL.LL.LL\n" +
            "LLLLLLL.LL\n" +
            "L.L.L..L..\n" +
            "LLLL.LL.LL\n" +
            "L.LL.LL.LL\n" +
            "L.LLLLL.LL\n" +
            "..L.L.....\n" +
            "LLLLLLLLLL\n" +
            "L.LLLLLL.L\n" +
            "L.LLLLL.LL";
    private String inputData = "";

    public int getOccupiedSeats() {
        return getOccupiedSeats(this.inputTestData);
    }

    private int getOccupiedSeats(String data) {
        List<char[][]> layouts = getLayoutFromData(data);
        char[][] layout = layouts.get(0);
        char[][] tempLayout = layouts.get(1);

        boolean shouldContinue = true;
        for (int round = 0; round < 10 && shouldContinue; round++) {
            shouldContinue = false;
            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[i].length; j++) {
                    if (layout[i][j] == EMPTY_SEAT && !hasSpecificNearbySeats(OCCUPIED_SEAT, 0, i, j, layout)) {
                        tempLayout[i][j] = '#';
                        shouldContinue = true;
                    } else if (layout[i][j] == OCCUPIED_SEAT && hasSpecificNearbySeats(OCCUPIED_SEAT, 3, i, j, layout)) {
                        tempLayout[i][j] = 'L';
                        shouldContinue = true;
                    }
                }
            }
            cloneMatrix(tempLayout, layout);
        }

        return getNumberOfMarkedSeats(EMPTY_SEAT, layout);
    }

    private void cloneMatrix(char[][] source, char[][] destination) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                destination[i][j] = source[i][j];
            }
        }
    }

    private List<char[][]> getLayoutFromData(String data) {
        String[] chunks = data.split("\n");
        char[][] layout = new char[chunks.length][chunks[0].length()];
        char[][] layout2 = new char[chunks.length][chunks[0].length()];
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = chunks[i].charAt(j);
                layout2[i][j] = chunks[i].charAt(j);
            }
        }
        return Arrays.asList(layout, layout2);
    }

    private boolean hasSpecificNearbySeats(char seatMark, int minValue , int i, int j, char[][] layout) {
        int markedSeats = 0;
        if ((markedSeats += getMarkedSeatsOnLeftSide(seatMark, i, j, layout)) > minValue) {
            return true;
        }
        if ((markedSeats += getMarkedSeatsOnUpDownSide(seatMark, i, j, layout)) > minValue) {
            return true;
        }
        return (markedSeats += getMarkedSeatsOnRightSide(seatMark, i, j, layout)) > minValue;
    }

    private int getMarkedSeatsOnLeftSide(char seatMark, int i, int j, char[][] layout) {
        int markedSeats = 0;
        if (j - 1 >= 0) {
            if (i - 1 >= 0 && layout[i - 1][j - 1] == seatMark) {
                markedSeats++;
            }
            if (layout[i][j - 1] == seatMark) {
                markedSeats++;
            }
            if (i + 1 < layout.length && layout[i + 1][j - 1] == seatMark) {
                markedSeats++;
            }
        }
        return markedSeats;
    }

    private int getMarkedSeatsOnUpDownSide(char seatMark, int i, int j, char[][] layout) {
        int markedSeats = 0;
        if (i - 1 >= 0 && layout[i - 1][j] == seatMark) {
            markedSeats++;
        }
        if (i + 1 < layout.length && layout[i + 1][j] == seatMark) {
            markedSeats++;
        }

        return markedSeats;
    }

    private int getMarkedSeatsOnRightSide(char seatMark, int i, int j, char[][] layout) {
        int markedSeats = 0;
        if (j + 1 < layout[i].length) {
            // check every row
            if (i - 1 >= 0 && layout[i - 1][j + 1] == seatMark) {
                markedSeats++;
            }
            if (layout[i][j + 1] == seatMark) {
                markedSeats++;
            }
            if (i + 1 < layout.length && layout[i + 1][j + 1] == seatMark) {
                markedSeats++;
            }
        }
        return markedSeats;
    }

    private int getNumberOfMarkedSeats(char seatMark, char[][] layout) {
        int numberOfEmptySeats = 0;
        for (char[] chars : layout) {
            for (char aChar : chars) {
                if (aChar == 'L') {
                    numberOfEmptySeats++;
                }
            }
        }
        return numberOfEmptySeats;
    }
}
