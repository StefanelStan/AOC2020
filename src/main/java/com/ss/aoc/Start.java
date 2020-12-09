package com.ss.aoc;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();

//        start.day05();
//        start.day06();
//        start.day07();
//        start.day08();
        start.day09();
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
}
