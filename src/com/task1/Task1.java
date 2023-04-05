package com.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        // Task 1
        List<String> names = Arrays.asList("Ivan", "Alex", "Peter", "John", "Michael", "Anna");

        String result = getOddIndexedNames(names);
        System.out.println(result);
    }

    public static String getOddIndexedNames(List<String> names) {
        return names.stream()
                .filter(name -> names.indexOf(name) % 2 != 0)
                .map(name -> (names.indexOf(name) + 1) + ". " + name)
                .collect(Collectors.joining(", "));
    }
}