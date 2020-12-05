package com.ss.aoc;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();

        start.day05();
    }

    private void day05() {
        Day05 day05 = new Day05();

        System.out.println("357 == " + day05.getHighestSeatId("FBFBBFFRLR"));
        System.out.println("119 == " + day05.getHighestSeatId("FFFBBBFRRR"));
        System.out.println("820 == " +day05.getHighestSeatId("BBFFBBFRLL"));
        System.out.println("MaxId == " +day05.getHighestSeatId());
        System.out.println("Missing Seat == " +day05.getMissingSeat());
    }
}
