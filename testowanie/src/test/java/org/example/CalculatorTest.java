package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldAdd5To2Result7() {
        // given
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 2;

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertEquals(7, result);
    }

    @Test
    public void shouldAdd1To1Result2() {
        // given
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 1;

        // when
        int result = calculator.add(a, b);

        // then
//        Assertions.assertEquals(2, result);
        if(result != 3){
            throw new AssertionFailedError("Expected: " + 3 + " Actual: " + result);
        }
    }

}