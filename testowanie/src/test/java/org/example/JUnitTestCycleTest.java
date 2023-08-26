package org.example;

import org.junit.jupiter.api.*;

import java.util.Random;

public class JUnitTestCycleTest {

    private Random random;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @BeforeEach
    public void init(){
        System.out.println("init");
        random = new Random();
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
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
