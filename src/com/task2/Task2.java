package com.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Alex", "Peter", "John", "Michael", "Anna");

        List<String> result = getSortedUpperCaseNames(names);
        System.out.println(result);
    }

    public static List<String> getSortedUpperCaseNames(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
