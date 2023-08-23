package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthCalculatorTest {

    private MonthCalculator monthCalculator = new MonthCalculator();

    @Test
    public void shouldReturn30For2018and6() {
        // when
        int result = monthCalculator.getDayCount(2018, 6);

        // then
        Assertions.assertEquals(30, result);
    }

    @Test
    public void shouldReturn31For2018and7(){
        int result = monthCalculator.getDayCount(2018,7);
        Assertions.assertEquals(31, result);
    }

    @Test
    public void shouldReturn31For2018and8(){
        int result = monthCalculator.getDayCount(2018,8);
        Assertions.assertEquals(31, result);
    }

    @Test
    public void shouldReturn28For2018and2(){
        int result = monthCalculator.getDayCount(2018,2);
        Assertions.assertEquals(28, result);
    }

    @Test
    public void shouldReturn29For2016and2(){
        int result = monthCalculator.getDayCount(2016,2);
        Assertions.assertEquals(29, result);
    }

    @Test
    public void shouldReturn28For2010and2(){
        int result = monthCalculator.getDayCount(2010,2);
        Assertions.assertEquals(28, result);
    }

    @Test
    public void shouldReturn28For2100and2(){
        int result = monthCalculator.getDayCount(2100,2);
        Assertions.assertEquals(28, result);
    }

    @Test
    public void shouldReturn29For2000and2(){
        int result = monthCalculator.getDayCount(2000,2);
        Assertions.assertEquals(29, result);
    }




}