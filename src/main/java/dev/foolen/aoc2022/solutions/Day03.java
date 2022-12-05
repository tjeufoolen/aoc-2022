package dev.foolen.aoc2022.solutions;

import dev.foolen.aoc2022.commons.utils.IOUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day03 {
    private static List<String> input;

    public static void main(String[] args) throws IOException {
        input = IOUtil.readFileAsListOfStrings( "input/day03.txt");

        solvePartOne();
        solvePartTwo();
    }

    private static void solvePartOne() {
        int sum = input.stream().mapToInt(line -> {
            String left = line.substring(0, line.length() / 2);
            String right = line.substring(line.length() / 2);
            char item = getOverlappingItemFromRucksacks(left, right);
            return getPriorityFromItem(item);
        }).sum();

        System.out.printf("[PartOne] The sum is: %d%n", sum);
        // - 7553
    }

    private static int getPriorityFromItem(char item) {
        // ascii
        // a-z -> 97,122
        // A-Z -> 65,90

        // priorities
        // a-z -> 1,26
        // A-Z -> 27,52

        boolean isLowerCase = item > 90;
        int numberCorrection = isLowerCase ? 96 : 38;

        return item - numberCorrection;
    }

    private static char getOverlappingItemFromRucksacks(String left, String right) {
        for (String lc : left.split("")) {
            if (right.contains(lc)) return lc.charAt(0);
        }
        return 0;
    }

    private static void solvePartTwo() {
        List<List<String>> groups = getElfGroups(input);
        int sum = groups.stream().mapToInt(group -> {
            char item = getOverlappingItemFromRucksacks(group.stream().toArray(String[]::new));
            return getPriorityFromItem(item);
        }).sum();

        System.out.printf("[PartTwo] The sum is: %s%n", sum);
    }

    private static List<List<String>> getElfGroups(List<String> input) {
        List<List<String>> groups = new ArrayList<>();

        List<String> group = new ArrayList<>();
        for (String line : input) {
            if (group.size() == 3) {
                groups.add(group);
                group.clear();
            }
            group.add(line);
        }

        return groups;
    }

    private static char getOverlappingItemFromRucksacks(String ...rucksacks) {
        int nbOfSacks = rucksacks.length;

        // TODO: Implement code for part two

        return 0;
    }
}
