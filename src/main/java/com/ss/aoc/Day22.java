package com.ss.aoc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Day22 extends AOCDay {
    public Day22() {
        this.dataFileName = "day22.txt";
        this.testDataFilename = "day22test.txt";
    }

    @Override
    long task1(boolean isTest) {
        List<String> dataLines = getDataAsStringLines(isTest);
        Queue<Integer> player1 = getPlayerCards(1, (dataLines.size() - 1) / 2 - 1, dataLines);
        Queue<Integer> player2 = getPlayerCards((dataLines.size() - 1) / 2 + 2, dataLines.size() - 1, dataLines);

        return play(player1, player2);
    }

    @Override
    long task2(boolean isTest) {
        return 0;
    }

    private Queue<Integer> getPlayerCards(int start, int end, List<String> dataLines) {
        Queue<Integer> numbers = new LinkedList<>();
        numbers.hashCode();
        for (int i = start; i <= end; i++) {
            numbers.add(Integer.parseInt(dataLines.get(i)));
        }
        return numbers;
    }

    private long play(Queue<Integer> player1, Queue<Integer> player2) {
        Set<Integer> deckHashes = new HashSet<>();
        int rounds = 1;
        while (!player1.isEmpty() && !player2.isEmpty()) {
//            System.out.println("Round " + rounds);
            if (!deckHashes.add(player1.hashCode()) && deckHashes.add(player2.hashCode())) {
                return getWinner(player1);
            }
            int p1Card = player1.poll();
            int p2Card = player2.poll();
            if (p1Card <= player1.size() && p2Card <= player2.size()) {
                boolean isPlayerOneWinner = playSubgame(getSubqueue(player1, p1Card), getSubqueue(player2, p2Card));
                if (isPlayerOneWinner) {
                    player1.offer(p1Card);
                    player1.offer(p2Card);
                } else {
                    player2.offer(p2Card);
                    player2.offer(p1Card);
                }
            } else {
                if (p1Card > p2Card) {
                    player1.offer(p1Card);
                    player1.offer(p2Card);
                } else {
                    player2.offer(p2Card);
                    player2.offer(p1Card);
                }
            }
            rounds++;
        }

        return getWinner(player1.isEmpty() ? player2 : player1);
    }

    private Queue<Integer> getSubqueue(Queue<Integer> queue, int numberOfCards) {
        Queue<Integer> subqueue = new LinkedList<>();
        Iterator<Integer> iterator = queue.iterator();
        for (int i = 0; i < numberOfCards; i++) {
            subqueue.offer(iterator.next());
        }
        return subqueue;
    }

    private boolean playSubgame(Queue<Integer> player1, Queue<Integer> player2) {
        Set<Integer> deckHashes = new HashSet<>();
        int rounds = 1;
        while (!player1.isEmpty() && !player2.isEmpty()) {
//            System.out.println("Round " + rounds);
            if (!deckHashes.add(player1.hashCode()) && deckHashes.add(player2.hashCode())) {
                return true;
            }
            int p1Card = player1.poll();
            int p2Card = player2.poll();
            if (p1Card <= player1.size() && p2Card <= player2.size()) {
                boolean isPlayerOneWinner = playSubgame(getSubqueue(player1, p1Card), getSubqueue(player2, p2Card));
                if (isPlayerOneWinner) {
                    player1.offer(p1Card);
                    player1.offer(p2Card);
                } else {
                    player2.offer(p2Card);
                    player2.offer(p1Card);
                }
            } else {
                if (p1Card > p2Card) {
                    player1.offer(p1Card);
                    player1.offer(p2Card);
                } else {
                    player2.offer(p2Card);
                    player2.offer(p1Card);
                }
            }
            rounds++;
        }
        return player2.isEmpty();
    }

    private long getWinner(Queue<Integer> integers) {
        long sum = 0;
        for (int i = integers.size(); i >= 1; i--) {
            sum += i * integers.poll();
        }
        return sum;
    }

}

