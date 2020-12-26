package com.ss.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day23 extends AOCDay {


    public Day23() {
    }

    @Override
    long task1(boolean isTest) {
        List<Integer> numbers = getNumbers(isTest);
        String labels = runGameAndGetLabels(numbers, 100);

        return Long.parseLong(labels);
    }

    private String runGameAndGetLabels(List<Integer> numbers, int rounds) {
        int currentPosition = 0;
        int currentCup = numbers.get(0);
        for (int i = 0; i < rounds; i++) {
            List<Integer> threeCups = getThreeCups(numbers, currentPosition);
            currentPosition = moveThreeCups(numbers, threeCups, currentCup);
            currentPosition = currentPosition + 1 > numbers.size() - 1 ? 0 : currentPosition + 1;
            currentCup = numbers.get(currentPosition);
        }
        return getNumbersAroundOne(numbers);
    }

    private int moveThreeCups(List<Integer> numbers, List<Integer> threeCups, int currentCup) {
        // first determine the position of currentCup and max of others and min of nextCup
        int maxCupInNumbers = -1;
        int maxCupInNumbersIndex = -1;
        int maxCupUnderCurrentCup = -1;
        int maxCupUnderCurrentCupIndex = -1;
        int i = 0;
        // find maxcup, maxMinCup and indexes
        for (Integer number : numbers) {
            if (number != currentCup) {
                if (number > maxCupUnderCurrentCup && number < currentCup) {
                    maxCupUnderCurrentCup = number;
                    maxCupUnderCurrentCupIndex = i;
                }
                if (number > currentCup && number > maxCupInNumbers) {
                    maxCupInNumbers = number;
                    maxCupInNumbersIndex = i;
                }
            }
            i++;
        }

        // based on indexes, insert the 3 cups
        int insertionIndex = maxCupUnderCurrentCup == -1 ? maxCupInNumbersIndex : maxCupUnderCurrentCupIndex;
        numbers.addAll(insertionIndex + 1, threeCups);

        // return index of where the currentCup index has been moved
        return numbers.indexOf(currentCup);
    }

    private List<Integer> getThreeCups(List<Integer> numbers, int currentPosition) {
        List<Integer> threeCups = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            int positionToRemove = currentPosition + 1 > numbers.size() - 1 ? 0 : currentPosition + 1;
            threeCups.add(numbers.remove(positionToRemove));
        }
        return threeCups;
    }

    private String getNumbersAroundOne(List<Integer> numbers) {
        StringBuilder beforeOne = new StringBuilder();
        StringBuilder afterOne = new StringBuilder();
        boolean foundOne = false;
        for (int number : numbers) {
            if (number == 1) {
                foundOne = true;
            } else {
                if (!foundOne) {
                    beforeOne.append(number);
                } else {
                    afterOne.append(number);
                }
            }
        }
        return afterOne.toString() + beforeOne.toString();
    }

    private String runGameAndGetLabelsPart2(List<Integer> numbers, int rounds) {
        int currentPosition = 0;
        int currentCup = numbers.get(0);
        for (int i = 0; i < rounds; i++) {
            if (i % 10000 == 0) {
                System.out.println(i);
            }
            List<Integer> threeCups = getThreeCups(numbers, currentPosition);
            currentPosition = moveThreeCupsPart2(numbers, threeCups, currentCup);
            currentPosition = currentPosition + 1 > numbers.size() - 1 ? 0 : currentPosition + 1;
            currentCup = numbers.get(currentPosition);
        }
        return getNumbersAfterOne(numbers);
    }

    private String getNumbersAfterOne(List<Integer> numbers) {
        int nr1, nr2;
        int indexOfOne = numbers.indexOf(1);
        int nr1Index, nr2Index;

        nr1Index = indexOfOne + 1 >= numbers.size() ? 0 : indexOfOne + 1;
        nr2Index = indexOfOne + 2 >= numbers.size() ? (indexOfOne + 2 - numbers.size()) : indexOfOne + 2;

        return numbers.get(nr1Index) + "/" + numbers.get(nr2Index);
    }

    private int moveThreeCupsPart2(List<Integer> numbers, List<Integer> threeCups, int currentCup) {
        // first determine the position of currentCup and max of others and min of nextCup

        int maxMinCup = calculateMaxMinCup(currentCup, threeCups);
        int maxCupOfOthers = calculateMaxCupOfOthers(currentCup, threeCups);


        // based on indexes, insert the 3 cups
        int insertionIndex = maxMinCup == -1 ? numbers.indexOf(maxCupOfOthers) : numbers.indexOf(maxMinCup);
        numbers.addAll(insertionIndex + 1, threeCups);

        // return index of where the currentCup index has been moved
        return numbers.indexOf(currentCup);
    }

    private int calculateMaxMinCup(int currentCup, List<Integer> threeCups) {
        for (int i = currentCup - 1; i > 0; i--) {
            if (!threeCups.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private int calculateMaxCupOfOthers(int currentCup, List<Integer> threeCups) {
        for (int i = 1000000; i > currentCup; i--) {
            if (!threeCups.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private List<Integer> getNumbers(boolean isTest) {
        return isTest ? new ArrayList<>(Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7)) : new ArrayList<>(Arrays.asList(7, 3, 9, 8, 6, 2, 5, 4, 1));
    }

    private List<Integer> getNumbersTask2(boolean isTest) {
        List<Integer> numbers = getNumbers(isTest);
        for (int i = 10; i < 1000001; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    @Override
    /**
     * With compliments to https://github.com/Bogdanp/
     */

    long task2(boolean isTest) {
        List<Integer> numbers = getNumbers(isTest);
        Map<Integer, CircularLinkedList.Node> indexToNode = new HashMap<>();
        CircularLinkedList cll = new CircularLinkedList();

        numbers.forEach(number -> indexToNode.put(number, cll.addNode(number)));

        for (int i = 10; i <= 1_000_000; i++) {
            indexToNode.put(i, cll.addNode(i));
        }

        runGames(cll, indexToNode, 10_000_000);

        CircularLinkedList.Node nodeOne = indexToNode.get(1);
        return (long) nodeOne.getNextNode().getValue() * nodeOne.getNextNode().getNextNode().getValue();
    }

    private void runGames(CircularLinkedList cll, Map<Integer, CircularLinkedList.Node> indexToNode, int games) {
        CircularLinkedList.Node currentNode = cll.getHead();

        for (int i = 0; i < games; i++) {
            List<CircularLinkedList.Node> nodesToMove = List.of(currentNode.getNextNode(), currentNode.getNextNode().getNextNode(),
                    currentNode.getNextNode().getNextNode().getNextNode());
            CircularLinkedList.Node destination = getDestination(nodesToMove, currentNode, indexToNode, cll.getSize());

            CircularLinkedList.Node lastThreeNode = nodesToMove.get(nodesToMove.size() - 1);
            currentNode.setNextNode(lastThreeNode.getNextNode());

            CircularLinkedList.Node firstThreeNode = nodesToMove.get(0);
            lastThreeNode.setNextNode(destination.getNextNode());
            destination.setNextNode(firstThreeNode);

            currentNode = currentNode.getNextNode();
        }
    }

    private CircularLinkedList.Node getDestination(List<CircularLinkedList.Node> threeCups,
                                                   CircularLinkedList.Node currentCup, Map<Integer,
                                                    CircularLinkedList.Node> indexToNode, int size) {

        int underCup = currentCup.getValue() - 1;
        if (underCup < 1) {
            underCup = size;
        } else while (threeCups.contains(indexToNode.get(underCup))) {
            underCup--;
            if (underCup < 1) {
                underCup = size;
                break;
            }
        }
        return indexToNode.get(underCup);
    }
}

class CircularLinkedList {

    private Node head = null;
    private Node tail = null;
    private int size;

    public Node addNode(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
        size++;

        return newNode;
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    static class Node {
        private int value;
        private Node nextNode;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}

