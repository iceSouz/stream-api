package com.task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("1, 2, 0", "4, 5");
        String result = getSortedNumbers(input);
        System.out.println(result);
    }

    public static String getSortedNumbers(List<String> input) {
        return input.stream()
                .flatMap(s -> Stream.of(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
