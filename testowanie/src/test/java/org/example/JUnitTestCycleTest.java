package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class JUnitTestCycleTest {

    private Random random;

    @BeforeEach
    public void init(){
        System.out.println("init");
        random = new Random();
    }

    @AfterEach
    public void after(){
        System.out.println("after");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 " + random.nextInt());
    }

    @Test
    public void test2(){
        System.out.println("Test 2 " + random.nextInt());
    }

}
