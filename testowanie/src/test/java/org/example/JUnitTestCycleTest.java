package org.example;

import org.junit.jupiter.api.*;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class JUnitTestCycleTest {

    private Random random;

    private int counter = 0;

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

    @Test
    public void test3(){
        counter++;
        System.out.println("Test 3, counter: " + counter);
    }

    @Test
    public void test4(){
        counter++;
        System.out.println("Test 4, counter: " + counter);
    }

}
