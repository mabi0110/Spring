package org.example;

public class MonthCalculator {

    int getDayCount(int year, int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
        };
    }
}
