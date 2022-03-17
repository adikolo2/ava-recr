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
        FizzBuzz.run(3);
        FizzBuzz.run(6);
        FizzBuzz.run(9);
        //assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testMultiplesOfFive() {
        //arrange
        final String expected = "i:5 - Buzz\r\ni:10 - Buzz\r\ni:20 - Buzz";
        //act
        FizzBuzz.run(5);
        FizzBuzz.run(10);
        FizzBuzz.run(20);
        //assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testMultiplesOfFiveAndThree() {
        //arrange
        final String expected = "i:15 - FizzBuzz\r\ni:30 - FizzBuzz\r\ni:60 - FizzBuzz";
        //act
        FizzBuzz.run(15);
        FizzBuzz.run(30);
        FizzBuzz.run(60);
        //assert
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}