package org.example;

import org.junit.jupiter.api.Test;

public class JUnitTestCycleTest {

    private int counter = 0;

    @Test
    public void test1(){
        counter++;
        System.out.println("Test 1, counter: " + counter);
        System.out.println("Test 1 " + this);
    }

    @Test
    public void test2(){
        counter++;
        System.out.println("Test 2, counter: " + counter);
        System.out.println("Test 2 " + this);
    }

}
