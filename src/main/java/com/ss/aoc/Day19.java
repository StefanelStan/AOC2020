package com.ss.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day19 extends AOCDay {

    public Day19() {
        this.testDataFilename = "day19part2test.txt";
        this.dataFileName = "day19.txt";
    }

    @Override
    long task1(boolean isTest) {
        String[] data = getDataAsString(isTest).split("\r\n\r\n");
        List<String> ruleZero = extractRuleZero(data[0]);
        return getNumberOfRespectedRules(ruleZero, data[1]);
    }

    private List<String> extractRuleZero(String listOfRules) {
        List<String> linesOfRules = new ArrayList<>(Arrays.asList(listOfRules.split("\r\n")));
        int numberOfRules = linesOfRules.size();
        List<String> zeroRule = new LinkedList<>();
        // magic goes here. use a map maybe?
        Map<Integer, List<String>> rulesMap = new HashMap<>();
        String pl = linesOfRules.get(linesOfRules.size() - 2);
        String ll = linesOfRules.get(linesOfRules.size() - 1);
        rulesMap.put(Integer.parseInt(pl.substring(0, pl.indexOf(':'))), Arrays.asList(pl.substring(pl.indexOf('"') + 1, pl.length() - 1)));
        rulesMap.put(Integer.parseInt(ll.substring(0, ll.indexOf(':'))), Arrays.asList(ll.substring(ll.indexOf('"') + 1, ll.length() - 1)));
        linesOfRules.remove(linesOfRules.size() - 1);
        linesOfRules.remove(linesOfRules.size() - 1);
        List<Rule> rules = formatLinesToRules(linesOfRules);
        while (rulesMap.size() != numberOfRules) {
            rules.removeIf(nextRule -> processRuleIfPossible(nextRule, rulesMap));
        }

        return rulesMap.get(0);
    }

    private List<Rule> formatLinesToRules(List<String> linesOfRules) {
        List<Rule> rules = new LinkedList<>();
        int semicolon = 0;
        int separator = -1;
        int ruleNumber = 0;
        for (String rule : linesOfRules) {
            semicolon = rule.indexOf(':');
            separator = rule.indexOf('|');
            ruleNumber = Integer.parseInt(rule.substring(0, semicolon));
            if (separator < 0) { // has 1-2-3 single rules but no separator
                String[] nrs = rule.substring(semicolon + 2).split(" ");
                List<Integer> singleChain = new LinkedList<>();
                for (String nr : nrs) {
                    singleChain.add(Integer.parseInt(nr));
                }
                rules.add(new Rule(ruleNumber, singleChain));
            } else {
                List<Integer> firstHalf = new LinkedList<>();
                List<Integer> secondHalf = new LinkedList<>();
                String[] nrs = rule.substring(semicolon + 2, separator - 1).split(" ");
                String[] nrs2 = rule.substring(separator + 2).split(" ");
                for (int i = 0; i < nrs.length; i++) {
                    firstHalf.add(Integer.parseInt(nrs[i]));
                    secondHalf.add(Integer.parseInt(nrs2[i]));
                }
                rules.add(new Rule(ruleNumber, firstHalf, secondHalf));
            }
        }
        return rules;
    }

    private long getNumberOfRespectedRules(List<String> ruleZero, String data) {
        String[] dataInputs = data.split("\r\n");
        int respectedRules = 0;
        for (String line : dataInputs) {
            if (isRespectingRule(ruleZero, line)) {
                respectedRules++;
            }
        }
        return respectedRules;
    }

    private boolean isRespectingRule(List<String> ruleZero, String line) {
        for (String combination : ruleZero) {
            if (combination.equalsIgnoreCase(line)) {
                return true;
            }
        }
        return false;
    }


    private boolean processRuleIfPossible(Rule nextRule, Map<Integer, List<String>> rulesMap) {
        if (rulesAreDefinedInMap(nextRule, rulesMap)) {
            List<String> ruleCombinations = new LinkedList<>();
            if (nextRule.isSingleChainRule()) {
                ruleCombinations.addAll(getChainedCombinationsOfrules(nextRule, rulesMap));
            } else {
                ruleCombinations.addAll(getCombinationsOfTwo(nextRule.getFirstHalf(), rulesMap));
                ruleCombinations.addAll(getCombinationsOfTwo(nextRule.getSecondHalf(), rulesMap));
            }
            rulesMap.put(nextRule.getNumber(), ruleCombinations);
            // add rules to map
            return true;
        }
        return false;
        // verify is all the chained or list of rules are containedWithin the rulesMap
    }

    private Collection<String> getChainedCombinationsOfrules(Rule nextRule, Map<Integer, List<String>> rulesMap) {
        List<String> ruleCombinations = new LinkedList<>();
        if (nextRule.getSingleChain().size() == 1) {
            return rulesMap.get(nextRule.getSingleChain().get(0));
        } else if (nextRule.getSingleChain().size() == 2) {
            for (String fHalf : rulesMap.get(nextRule.getSingleChain().get(0))) {
                for (String sHalf : rulesMap.get(nextRule.getSingleChain().get(1))) {
                    ruleCombinations.add(fHalf + sHalf);
                }
            }
        } else if (nextRule.getSingleChain().size() == 3) {
            for (String fThird : rulesMap.get(nextRule.getSingleChain().get(0))) {
                for (String sThird : rulesMap.get(nextRule.getSingleChain().get(1))) {
                    for (String tThird : rulesMap.get(nextRule.getSingleChain().get(2))) {
                        ruleCombinations.add(fThird + sThird + tThird);
                    }
                }
            }
        }
        return ruleCombinations;
    }

    private Collection<String> getCombinationsOfTwo (List<Integer> firstHalf, Map<Integer, List<String>> rulesMap) {
        List<String> ruleCombinations = new LinkedList<>();
        if (firstHalf.size() == 1) {
            return rulesMap.get(firstHalf.get(0));
        } else if (firstHalf.size() == 2) {
            for (String fHalf : rulesMap.get(firstHalf.get(0))) {
                for (String sHalf : rulesMap.get(firstHalf.get(1))) {
                    ruleCombinations.add(fHalf + sHalf);
                }
            }
        } else if (firstHalf.size() == 3) {
            for (String fThird : rulesMap.get(firstHalf.get(0))) {
                for (String sThird : rulesMap.get(firstHalf.get(1))) {
                    for (String tThird : rulesMap.get(firstHalf.get(2))) {
                        ruleCombinations.add(fThird + sThird + tThird);
                    }
                }
            }
        }
        return ruleCombinations;
    }

    private boolean rulesAreDefinedInMap(Rule nextRule, Map<Integer, List<String>> rulesMap) {
        if (nextRule.isSingleChainRule()) {
            return rulesMap.keySet().containsAll(nextRule.getSingleChain());
        } else {
            return rulesMap.keySet().containsAll(nextRule.getFirstHalf()) && rulesMap.keySet().containsAll(nextRule.getSecondHalf());
        }
    }


    @Override
    long task2(boolean isTest) {
        return 0;
    }


    private static class Rule {
        private int number;
        private List<Integer> singleChain;

        private List<Integer> firstHalf;

        private List<Integer> secondHalf;

        public Rule(int number, List<Integer> singleChain) {
            this.number = number;
            this.singleChain = singleChain;
        }

        public Rule(int number, List<Integer> firstHalf, List<Integer> secondHalf) {
            this.number = number;
            this.firstHalf = firstHalf;
            this.secondHalf = secondHalf;
        }

        private boolean isSingleChainRule() {
            return singleChain != null && !singleChain.isEmpty();
        }

        public int getNumber() {
            return number;
        }

        public List<Integer> getSingleChain() {
            return singleChain;
        }

        public List<Integer> getFirstHalf() {
            return firstHalf;
        }

        public List<Integer> getSecondHalf() {
            return secondHalf;
        }
    }
}
