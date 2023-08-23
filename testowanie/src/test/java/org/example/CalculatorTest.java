package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldTestSth() {
        // given
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 2;

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertEquals(7, result);

    }

}