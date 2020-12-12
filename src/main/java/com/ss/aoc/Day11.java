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
    private String inputData = "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLL..LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLL.L\n" +
            "LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "......L.LL.....L.L..L.....L.L..LL.L.LL.L...L..L..............L..L......LL.....LL...L.L.....\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLLLLLLLLL..LLLLLLLLLLLL.LLLLLLLL.LLLLLLLL..LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLL.LLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL..LLL.LLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "...L..L....LL.L.L......LLLLL.....LL....L.......L.LL.L.L.L..LL...LLLLLL.LL........L.L.......\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            ".LLLLLLLL.LLLL..LLLL.LLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL.LL.LLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLL.LL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.L.LL.LLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "......L.L..L.L...LLL.....L.L..L......LL...L..L..L.L......L.L..L....LLLL....L..L....L.L..L.L\n" +
            "LLLLLL.LL.LLLLLLLLLL.LLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLL.LLL.LLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLL.LLLL.LLLLLLLLL..LLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLL.LLL.LLLLLLLLLLL.LLL.LL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLL.LL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLL.LLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.L.LL.LLLLL.LLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            ".LLL......L........L.....L..LL.L..L..L.L....L.L............L...........LLL..L..LL....LL..L.\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLL..LLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLL.L.LLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            ".......LL..L.LLL.L....L..L....L......L..L...LL...L.L...LL....L.L........L...L...L.L.......L\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL..LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLL.LL.LLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            ".L..LLL.L....LL.L..L..LL..L.LL.L......L........LLL.....L..LL...L.LL.LL.....L....L..LL.L....\n" +
            "LLLLLLLLLLL.LL.LLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLL.LLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLL..LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "L..L.LL....L..LL.L.....L.....L...L..L..L...L....L.L.L..LL.L......L...L......L....L.....L.L.\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLL..LLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.L.LLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLL.L.LLLLL.LLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            ".L..L.L...LLL.LL.L.L...L........LLLLL.L..L......L.....L....L.LL.L.LLL...LL..LL.LL..LL.....L\n" +
            "LLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLL.LLLLLLLL..LLLLLLL.LLLLLLLL\n" +
            "..L.L..L...L..L.L........L.L.LLL..L.L...LLL..L..........L........L....LLLL.LL...L......LL..\n" +
            "LLLLLLLLL.LLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLL..LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLL\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLL.LL.LLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "....LL.L..L...LL......L.....L..LL.L.......LL...L....LLLLL..L..L.LLL.......LL..LL...LL.....L\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.L.LLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.L.LLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLL.LLLLLLL.\n" +
            ".L.LL..L.LLL.L...L.......L..LLL.....L...LL...LLL...L.LL............L.L....LL.....L.L..LL..L\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLL.LLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.L.L.LLLLLLLLLLL.LLLL.L.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLLL.L.LLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLL..L....L.LL..L.L.LLL.LL..L.......L.LL..L..L....L..L...L...L.L..L.L.L.L.L.L.LLL.L.....L.L\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.LL.LLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLL.LLLLLL.LL.LLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            ".L..L..LL.L..L..L.L.L.LL..L....L.....L.LL..........L..L...LLL.L....LL...LL...L.LL.L.....LL.\n" +
            "LLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            ".LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLL.LLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL.LL.L.LLLLLL.LL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL\n" +
            "LLLLLLLLL.LLLL..LLLL.LLLLLL.LLLLLLLL.LL.L.LLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLL.LLLLLL.LLLLL.LLLLLLL.LL.LLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL..LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLL.LLLLL\n";

    public int getOccupiedSeats() {
        return getOccupiedSeats(this.inputData);
    }

    public int getOccupiedSeatsExtendedView() {
        return getOccupiedSeatsExtendedView(this.inputData);
    }

    private int getOccupiedSeats(String data) {
        List<char[][]> layouts = getLayoutFromData(data);
        char[][] layout = layouts.get(0);
        char[][] tempLayout = layouts.get(1);

        boolean shouldContinue = true;
        while (shouldContinue) {
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

        return getNumberOfMarkedSeats(OCCUPIED_SEAT, layout);
    }

    private void cloneMatrix(char[][] source, char[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
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

    private boolean hasSpecificNearbySeats(char seatMark, int minValue, int i, int j, char[][] layout) {
        int markedSeats = 0;
        if ((markedSeats += getMarkedSeatsOnLeftSide(seatMark, i, j, layout)) > minValue) {
            return true;
        }
        if ((markedSeats += getMarkedSeatsOnUpDownSide(seatMark, i, j, layout)) > minValue) {
            return true;
        }
        return markedSeats + getMarkedSeatsOnRightSide(seatMark, i, j, layout) > minValue;
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
                if (aChar == seatMark) {
                    numberOfEmptySeats++;
                }
            }
        }
        return numberOfEmptySeats;
    }


    private int getOccupiedSeatsExtendedView(String data) {
        List<char[][]> layouts = getLayoutFromData(data);
        char[][] layout = layouts.get(0);
        char[][] tempLayout = layouts.get(1);

        boolean shouldContinue = true;
        while (shouldContinue) {
            shouldContinue = false;
            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[i].length; j++) {
                    if (layout[i][j] == EMPTY_SEAT && !hasSpecificExtendedNearbySeats(OCCUPIED_SEAT, 0, i, j, layout)) {
                        tempLayout[i][j] = '#';
                        shouldContinue = true;
                    } else if (layout[i][j] == OCCUPIED_SEAT && hasSpecificExtendedNearbySeats(OCCUPIED_SEAT, 4, i, j, layout)) {
                        tempLayout[i][j] = 'L';
                        shouldContinue = true;
                    }
                }
            }
            cloneMatrix(tempLayout, layout);
        }

        return getNumberOfMarkedSeats(OCCUPIED_SEAT, layout);
    }

    private boolean hasSpecificExtendedNearbySeats(char seatMark, int minValue, int i, int j, char[][] layout) {
        int markedSeats = 0;
        if ((markedSeats += getMarkedSeatsOnExtendedLeftSide(seatMark, i, j, layout)) > minValue) {
            return true;
        }
        if ((markedSeats += getMarkedSeatsOnExtendedUpDownSide(seatMark, i, j, layout)) > minValue) {
            return true;
        }
        return markedSeats + getMarkedSeatsOnExtendedRightSide(seatMark, i, j, layout) > minValue;
    }

    private int getMarkedSeatsOnExtendedLeftSide(char seatMark, int iIndex, int jIndex, char[][] layout) {
        int markedSeats = 0;
        // top left diagonal
        for (int i = iIndex - 1, j = jIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (layout[i][j] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[i][j] != '.') {
                break;
            }
        }

        // left
        for (int j = jIndex - 1; j >= 0; j--) {
            if (layout[iIndex][j] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[iIndex][j] != '.') {
                break;
            }
        }

        // bottom left diagonal
        for (int i = iIndex + 1, j = jIndex - 1; i < layout.length && j >= 0; i++, j--) {
            if (layout[i][j] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[i][j] != '.') {
                break;
            }
        }

        return markedSeats;
    }

    private int getMarkedSeatsOnExtendedUpDownSide(char seatMark, int iIndex, int jIndex, char[][] layout) {
        int markedSeats = 0;
        // up
        for (int i = iIndex - 1; i >= 0; i--) {
            if (layout[i][jIndex] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[i][jIndex] != '.') {
                break;
            }
        }

        // down
        for (int i = iIndex + 1; i <layout.length; i++) {
            if (layout[i][jIndex] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[i][jIndex] != '.') {
                break;
            }
        }

        return markedSeats;
    }


    private int getMarkedSeatsOnExtendedRightSide(char seatMark, int iIndex, int jIndex, char[][] layout) {
        int markedSeats = 0;
        // top right diagonal
        for (int i = iIndex -1, j = jIndex + 1; i >= 0 && j < layout[i].length; i--, j++) {
            if (layout[i][j] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[i][j] != '.') {
                break;
            }
        }
        // right side
        for (int j = jIndex + 1; j < layout[iIndex].length; j++) {
            if (layout[iIndex][j] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[iIndex][j] != '.') {
                break;
            }
        }

        // bottom right diagonal
        for (int i = iIndex + 1, j = jIndex + 1; i < layout.length && j < layout[i].length; i++, j++) {
            if (layout[i][j] == seatMark) {
                markedSeats++;
                break;
            } else if (layout[i][j] != '.') {
                break;
            }
        }

        return markedSeats;
    }

}
