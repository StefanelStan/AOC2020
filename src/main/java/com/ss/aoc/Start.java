package com.ss.aoc;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();

//        start.day05();
//        start.day06();
        start.day07();
    }

    private void day05() {
        Day05 day05 = new Day05();

        System.out.println("357 == " + day05.getHighestSeatId("FBFBBFFRLR"));
        System.out.println("119 == " + day05.getHighestSeatId("FFFBBBFRRR"));
        System.out.println("820 == " +day05.getHighestSeatId("BBFFBBFRLL"));
        System.out.println("MaxId == " +day05.getHighestSeatId());
        System.out.println("Missing Seat == " +day05.getMissingSeat());
    }

    private void day06() {
        Day06 day06 = new Day06();
        System.out.println(day06.sumOfYesAnswers());
        System.out.println(day06.sumOfGroupYesAnwers());
    }

    private void day07() {
//        String rule = "dotted gold bags contain 4 striped violet bags.";
        String rule2 = "drab orange bags contain 3 wavy violet bags, 1 dark fuchsia bag, 2 mirrored green bags.";
//
//        System.out.println(Arrays.toString(rule.substring(rule.indexOf("contain ") + 8, rule.indexOf('.')).split(",")));
//        String[] split = rule2.substring(rule2.indexOf("contain ") + 8, rule2.indexOf('.')).split(",");
//        for (String chunk: split) {
//            String noSpace = chunk.trim();
//            String bagType = noSpace.substring(noSpace.indexOf(' ') + 1, noSpace.indexOf("bag") + 3);
//            int quantity = Integer.parseInt(String.valueOf(noSpace.charAt(0)));
//            System.out.println(bagType + quantity);
//        }
        Day07 day07 = new Day07();
//        System.out.println(day07.howManyBagsContain("shiny gold bag"));
        System.out.println(day07.howManyBagsInside("shiny gold bag"));
    }
}
