package com.task4;

import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = System.currentTimeMillis();

        Stream<Long> randomNumbersStream = getRandomNumbersStream(a, c, m, seed);
        randomNumbersStream.forEach(System.out::println);
    }

    public static Stream<Long> getRandomNumbersStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}

