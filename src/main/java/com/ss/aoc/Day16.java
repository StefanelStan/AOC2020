package com.ss.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Day16 extends AOCDay {

    public Day16() {
        this.testDataFilename = "day16test.txt";
        this.dataFileName = "day16.txt";
    }



    @Override
    long task1(boolean isTest) {
        String data = getDataAsString(isTest);
        String[] chunkedData = data.split("\r\n\r\n");
        List<Rule> rules = getRulesFromData(chunkedData[0]);
        List<Ticket> ticketList = getTickets(chunkedData[2]);
        return getErrorRate(ticketList, rules);
    }

    @Override
    long task2(boolean isTest) {
        String data = getDataAsString(isTest);
        String[] chunkedData = data.split("\r\n\r\n");
        List<Rule> rules = getRulesFromData(chunkedData[0]);
        List<Ticket> myTicket = getTickets(chunkedData[1]);
        List<Ticket> ticketList = getTickets(chunkedData[2]);
        List<Ticket> goodTickets = getGoodTickets(ticketList, rules);
        Map<Integer, List<Integer>> indexesAndRespectedRules = getIndexesAndRespectedRules(goodTickets, rules);
        // further perform common elements of all lists per rule
        Map<Integer, Integer> order = new TreeMap<>();
        getRulesOrder(indexesAndRespectedRules, order);

        return getMultiplicationOfTicketPositions(myTicket.get(0), order);
    }

    private List<Rule> getRulesFromData(String rulesData) {
        List<Rule> rules = new LinkedList<>();
        String[] lines = rulesData.split("\r\n");
        int nr1, nr2, nr3, nr4;
        for (int i = 0; i < lines.length; i++) {
            String[] bits = lines[i].split(" ");
            String fHalf = bits.length == 4 ? bits[1] : bits[2];
            String sHalf = bits.length == 4 ? bits[3] : bits[4];
            int indexOfFirstDash = fHalf.indexOf('-');
            int indexOfSecondDash = sHalf.indexOf('-');
            rules.add(new Rule(Integer.parseInt(fHalf.substring(0, indexOfFirstDash)),
                    Integer.parseInt(fHalf.substring(indexOfFirstDash + 1)),
                    Integer.parseInt(sHalf.substring(0, indexOfSecondDash)),
                    Integer.parseInt(sHalf.substring(indexOfSecondDash + 1))));
        }
        return rules;
    }

    private List<Ticket> getTickets(String ticketsData) {
        List<Ticket> tickets = new LinkedList<>();
        List<Integer> ticketNumbers;
        String[] lines = ticketsData.split("\r\n");
        for (int i = 1; i < lines.length; i++) {
            ticketNumbers = new LinkedList<>();
            String[] numbers = lines[i].split(",");
            for (String nr : numbers) {
                ticketNumbers.add(Integer.parseInt(nr));
            }
            tickets.add(new Ticket(ticketNumbers));
        }
        return tickets;
    }

    private long getErrorRate(List<Ticket> tickets, List<Rule> rules) {
        int errorRate = 0;
        for (int i = 0 ; i < tickets.size(); i++) {
            for (int ticketNumber : tickets.get(i).getNumbers()) {
                boolean isRespectingTheRule = false;
                for (Rule rule : rules) {
                    if (rule.isRespectingTheRule(ticketNumber)) {
                        isRespectingTheRule = true;
                        break;
                    }
                }
                if (!isRespectingTheRule) {
                    errorRate += ticketNumber;
                }
            }
        }
        return errorRate;
    }

    private List<Ticket> getGoodTickets(List<Ticket> tickets, List<Rule> rules) {
        List<Ticket> goodTickets = new ArrayList<>();
        boolean isBadTicket = false;
        for (int i = 0 ; i < tickets.size(); i++) {
            isBadTicket = false;
            for (int ticketNumber : tickets.get(i).getNumbers()) {
                boolean isRespectingTheRule = false;
                for (Rule rule : rules) {
                    if (rule.isRespectingTheRule(ticketNumber)) {
                        isRespectingTheRule = true;
                        break;
                    }
                }
                if (!isRespectingTheRule) {
                    isBadTicket = true;
                    break;
                }
            }
            if(!isBadTicket) {
                goodTickets.add(tickets.get(i));
            }
        }
        return goodTickets;
    }

    // let this one just return position and list of rules that is respects. Further, getRulesOrder will sort it out
    private Map<Integer, List<Integer>> getIndexesAndRespectedRules(List<Ticket> tickets, List<Rule> rules) {
        int ticketLength = tickets.get(0).getNumbers().size();
        Map<Integer, List<Integer>> indexesAndRules = new HashMap<>();
        for (int i = 0; i < ticketLength; i++) {
            List<Integer> positionOfI = getAllElementsOnPosition(i, tickets);
            List<Integer> respectedRulesOfI = getRespectedRulesOfIndex(positionOfI, rules);
            indexesAndRules.put(i, respectedRulesOfI);
        }
        return indexesAndRules;
    }

    private List<Integer> getAllElementsOnPosition(int i, List<Ticket> tickets) {
        List<Integer> elements = new ArrayList<>();
        for (Ticket ticket : tickets) {
            elements.add(ticket.getNumbers().get(i));
        }
        return elements;
    }

    /**
     * Receive all elements of position X from all valid tickets and return a common list of rules that should be fulfilled
     * @param elementsOfPosition
     * @param rules
     * @return
     */
    private List<Integer> getRespectedRulesOfIndex(List<Integer> elementsOfPosition, List<Rule> rules) {
        List<Integer> respectedRulesOnElementOne = getRulesThatRespectElement(elementsOfPosition.get(0), rules);
        for(int i = 1; i < elementsOfPosition.size(); i++) {
            respectedRulesOnElementOne.retainAll(getRulesThatRespectElement(elementsOfPosition.get(i), rules));
        }
        return respectedRulesOnElementOne;
    }

    private List<Integer> getRulesThatRespectElement(int element, List<Rule> rules) {
        List<Integer> respectedRules = new ArrayList<>();
        for(int i = 0; i < rules.size(); i++) {
            if(rules.get(i).isRespectingTheRule(element)) {
                respectedRules.add(i);
            }
        }
        return respectedRules;
    }

    private void getRulesOrder(Map<Integer, List<Integer>> indexesAndRespectedRules, Map<Integer, Integer> order) {
        if(order.size() == 20) return;
        Iterator<Map.Entry<Integer, List<Integer>>> it = indexesAndRespectedRules.entrySet().iterator();
        List<Integer> elementsToRemoveFromListFromMap = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Integer>> pair = it.next();
            if (pair.getValue().size() == 1) {
                order.put(pair.getKey(), pair.getValue().get(0));
                elementsToRemoveFromListFromMap.add(pair.getValue().get(0));
                it.remove();
            }
        }

        for(List<Integer> entry : indexesAndRespectedRules.values()) {
            entry.removeIf(elementsToRemoveFromListFromMap::contains);
        }

        getRulesOrder(indexesAndRespectedRules, order);
    }

    private long getMultiplicationOfTicketPositions(Ticket ticket, Map<Integer, Integer> order) {
        long[] multiplication = {1};
        order.entrySet().forEach(entry -> {
            if (entry.getValue() >= 0 && entry.getValue() <= 5) {
                multiplication[0] *= ticket.getNumbers().get(entry.getKey());
            }
        });
        return multiplication[0];
    }

    private static class Rule {
        private int int1, int2, int3, int4;

        public Rule(int int1, int int2, int int3, int int4) {
            this.int1 = int1;
            this.int2 = int2;
            this.int3 = int3;
            this.int4 = int4;
        }

        public boolean isRespectingTheRule(int number) {
            return (int1 <= number && number <= int2) || (int3 <= number && number <= int4);
        }
    }

    private static class Ticket {
        private final List<Integer> numbers;

        public Ticket(List<Integer> numbers) {
            this.numbers = new ArrayList<>(numbers);
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

    }
}
