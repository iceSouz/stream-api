package com.task5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {
    public static void main(String[] args) {
        Stream<String> first = Stream.of("A", "B", "C");
        Stream<String> second = Stream.of("1", "2", "3", "4");

        Stream<String> zipped = zip(first, second);
        zipped.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zippedIterator = new Iterator<T>() {
            private boolean firstTurn = true;

            @Override
            public boolean hasNext() {
                return firstTurn ? firstIterator.hasNext() : secondIterator.hasNext();
            }

            @Override
            public T next() {
                T result;
                if (firstTurn && firstIterator.hasNext()) {
                    result = firstIterator.next();
                } else if (!firstTurn && secondIterator.hasNext()) {
                    result = secondIterator.next();
                } else {
                    throw new NoSuchElementException("No elements left in either of the streams.");
                }
                firstTurn = !firstTurn;
                return result;
            }
        };

        Iterable<T> zippedIterable = () -> zippedIterator;
        return StreamSupport.stream(zippedIterable.spliterator(), false);
    }
}
