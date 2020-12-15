package com.ss.aoc;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();

//        start.day05();
//        start.day06();
//        start.day07();
//        start.day08();
//        start.day09();
//        start.day10();
//        start.day11();
//        start.day12();
//        start.day13();
        start.day14();
    }


    private void day05() {
        Day05 day05 = new Day05();

        System.out.println("357 == " + day05.getHighestSeatId("FBFBBFFRLR"));
        System.out.println("119 == " + day05.getHighestSeatId("FFFBBBFRRR"));
        System.out.println("820 == " + day05.getHighestSeatId("BBFFBBFRLL"));
        System.out.println("MaxId == " + day05.getHighestSeatId());
        System.out.println("Missing Seat == " + day05.getMissingSeat());
    }

    private void day06() {
        Day06 day06 = new Day06();
        System.out.println(day06.sumOfYesAnswers());
        System.out.println(day06.sumOfGroupYesAnwers());
    }

    private void day07() {
        Day07 day07 = new Day07();
//        System.out.println(day07.howManyBagsContain("shiny gold bag"));
        System.out.println(day07.howManyBagsInside("shiny gold bag"));
    }

    private void day08() {
        Day08 day08 = new Day08();
        System.out.println(day08.getValueOfAccumulator());
    }

    private void day09() {
        Day09 day09 = new Day09();
//        System.out.println(day09.firstNonSumNumber());
        System.out.println(day09.getEncryptionWeakness());
    }

    private void day10() {
        Day10 day10 = new Day10();
        // System.out.println(day10.getJoltDifference());
        // 1856
        System.out.println(day10.getPermutations());

    }

    private void day11() {
        Day11 day11 = new Day11();
//        System.out.println(day11.getOccupiedSeats());
        System.out.println(day11.getOccupiedSeatsExtendedView());
    }

    private void day12() {
        Day12 day12 = new Day12();
//        System.out.println(day12.getManhattanDistance());
        System.out.println(day12.getManhattanWaypointDistance());
    }

    private void day13() {
        Day13 day13 = new Day13();
//        System.out.println(day13.task1(false));
        System.out.println(day13.task2(false));

    }

    private void day14() {
        Day14 day14 = new Day14();
//        System.out.println(day14.task1(false));
        System.out.println(day14.task2(false));
    }
}
