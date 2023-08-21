package com.example.numbers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class NumbersService {
    private final Random random = new Random();

    int getRandomNumberFromRange(int from, int to) {
        int diff = to - from;
        return from + random.nextInt(diff + 1);
    }

    List<Integer> getEvenNumbersFromRange(int from, int to) {
        return IntStream.range(from, to + 1)
                .filter(NumbersService::isEven)
                .boxed()
                .toList();
    }
    List<Integer> getOddNumbersFromRange(int from, int to) {
        return IntStream.range(from, to + 1)
                .filter(NumbersService::isOdd)
                .boxed()
                .toList();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}