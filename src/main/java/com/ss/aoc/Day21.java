package com.ss.aoc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Day21 extends AOCDay {

    public Day21() {
        this.dataFileName = "day21.txt";
        this.testDataFilename = "day21test.txt";
    }

    @Override
    long task1(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        List<Food> food = getFoodFromList(lines);
        Map<String, Set<String>> enAllergens = new HashMap<>();
        Map<String, Set<Set<String>>> bucketOfIngredients = new HashMap<>();
        // loop over list of common allergens and if have one, extract the common list.
        // sort out the possible allergens from remaining list
        putFoodInAllergensBucket(food, bucketOfIngredients);
        // we have the map of allergen - foods. Let's try to filter it.
        filterBucketOfAllergensAndIngredients(bucketOfIngredients, enAllergens);
        Map<String, String> allergenMap = new TreeMap<>();
        Map<String, String> reverseAllergenMap = new HashMap<>();
        putAllergensIntoMap(enAllergens, allergenMap, reverseAllergenMap, enAllergens.size());
        long[] sum = { 0 };

        for (Food f : food) {
            for (String ingredient : f.getIngredients()) {
                if(!reverseAllergenMap.containsKey(ingredient)) {
                    sum[0]++;
                }
            }
        }

        StringBuilder stb = new StringBuilder();
        allergenMap.forEach((key, value) -> {
            stb.append(value);
            stb.append(',');
        });
        System.out.println(stb.substring(0, stb.length() -1));
        return sum[0];
    }

    private void putFoodInAllergensBucket(List<Food> food, Map<String, Set<Set<String>>> bucketOfIngredients) {
        for (int i = 0; i < food.size() - 1; i++) {
            final Food currentFood = food.get(i);
            for (String allergen : currentFood.getAllergens()) {
                Set<Set<String>> ingredientSet = bucketOfIngredients.get(allergen);
                if (ingredientSet == null) {
                    ingredientSet = new HashSet<>();
                }
                ingredientSet.add(currentFood.getIngredients());
                bucketOfIngredients.put(allergen, ingredientSet);
            }
        }
    }

    private void filterBucketOfAllergensAndIngredients(Map<String, Set<Set<String>>> bucketOfIngredients,
                                                       Map<String, Set<String>> enAllergens) {

        for (Map.Entry<String, Set<Set<String>>> entry : bucketOfIngredients.entrySet()) {
            Iterator<Set<String>> iterator = entry.getValue().iterator();
            Set<String> ingredients = new HashSet<>(iterator.next());
            while (iterator.hasNext()) {
                Set<String> nextElements = iterator.next();
                ingredients.retainAll(nextElements);
            }

            if (!ingredients.isEmpty()) {
                enAllergens.put(entry.getKey(), ingredients);
            }
        }
    }

    private void putAllergensIntoMap(Map<String, Set<String>> allergenMap, Map<String, String> allergens,
                                     Map<String, String> reverseAllergenMap, int stop) {
        while (allergens.size() != stop) {
            for (Map.Entry<String, Set<String>> entry : allergenMap.entrySet()) {
                if (!allergens.containsKey(entry.getKey()) && entry.getValue().size() == 1) {
                    String foreignAllergen = entry.getValue().iterator().next();
                    allergens.put(entry.getKey(), foreignAllergen);
                    reverseAllergenMap.put(foreignAllergen, entry.getKey());
                    allergenMap.forEach((key, value) -> {
                        if (value.size() != 1) {
                            value.remove(foreignAllergen);
                        }
                    });
                }
            }
        }
    }

    private List<Food> getFoodFromList(List<String> lines) {
        List<Food> food = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split(" ");
            List<String> ingredients = new LinkedList<>();
            List<String> allergens = new LinkedList<>();
            boolean metContains = false;
            for (String word : words) {
                if (metContains) {
                    allergens.add(word.substring(0, word.length() - 1));
                } else if (word.equals("(contains")) {
                    metContains = true;
                } else {
                    ingredients.add(word);
                }
            }
            food.add(new Food(ingredients, allergens));
        }
        return food;
    }

    @Override
    long task2(boolean isTest) {
        return task1(isTest);
    }

    private static class Food {
        private final Set<String> ingredients;
        private final Set<String> allergens;
        private boolean isFullyIdentified;

        public Food(Collection<String> ingredients, Collection<String> allergens) {
            this.ingredients = new HashSet<>(ingredients);
            this.allergens = new HashSet<>(allergens);
        }

        public Set<String> getIngredients() {
            return ingredients;
        }

        public Set<String> getAllergens() {
            return allergens;
        }

        public void setFullyIdentified() {
            isFullyIdentified = true;
        }

        public boolean isFullyIdentified() {
            return isFullyIdentified;
        }
    }
}
