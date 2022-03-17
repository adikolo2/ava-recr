package com.ava.tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 * Test class for {@link FizzBuzz}
 */
class FizzBuzzTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testMultiplesOfThree() {
        //arrange
        final String expected = "i:3 - Fizz\r\ni:6 - Fizz\r\ni:9 - Fizz";
        //act
        FizzBuzz.execute(3);
        FizzBuzz.execute(6);
        FizzBuzz.execute(9);
        //assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testMultiplesOfFive() {
        //arrange
        final String expected = "i:5 - Buzz\r\ni:10 - Buzz\r\ni:20 - Buzz";
        //act
        FizzBuzz.execute(5);
        FizzBuzz.execute(10);
        FizzBuzz.execute(20);
        //assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testMultiplesOfFiveAndThree() {
        //arrange
        final String expected = "i:15 - FizzBuzz\r\ni:30 - FizzBuzz\r\ni:60 - FizzBuzz";
        //act
        FizzBuzz.execute(15);
        FizzBuzz.execute(30);
        FizzBuzz.execute(60);
        //assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}