package com.ava.tasks;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link RpsGame}
 */
class RpsGameTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    private Scanner scanner;
    private RpsGame rpsGame;

    @Test
    public void testRockAndScissors() {
        //arrange
        Mockito.when(this.scanner.nextLine()).thenReturn("r", "s");
        final var expected = "*** Starting Rock - Paper - Scissors ***\n" +
                "Please type corresponding letter to choose your shape\n" +
                "Rock - r\n" +
                "Paper - p\n" +
                "Scissors - s\n" +
                "May the better win!\n" +
                "\r\n" +
                "Choose the first shape\r\n" +
                "You have chosen: ROCK\r\n" +
                "Choose the second shape\r\n" +
                "You have chosen: SCISSORS\r\n" +
                "Fight!\r\n" +
                "ROCK wins!\r\n" +
                "Thank you for playing!";

        //act
        this.rpsGame.play();

        //assert
        Assertions.assertEquals(expected,this.outputStreamCaptor.toString().trim());
    }

    @Test
    public void testPaperAndRock() {
        //arrange
        Mockito.when(this.scanner.nextLine()).thenReturn("p", "r");
        final var expected = "*** Starting Rock - Paper - Scissors ***\n" +
                "Please type corresponding letter to choose your shape\n" +
                "Rock - r\n" +
                "Paper - p\n" +
                "Scissors - s\n" +
                "May the better win!\n" +
                "\r\n" +
                "Choose the first shape\r\n" +
                "You have chosen: PAPER\r\n" +
                "Choose the second shape\r\n" +
                "You have chosen: ROCK\r\n" +
                "Fight!\r\n" +
                "PAPER wins!\r\n" +
                "Thank you for playing!";

        //act
        this.rpsGame.play();

        //assert
        Assertions.assertEquals(expected,this.outputStreamCaptor.toString().trim());
    }

    @Test
    public void testPaperAndPaper() {
        //arrange
        Mockito.when(this.scanner.nextLine()).thenReturn("p", "p");
        final var expected = "*** Starting Rock - Paper - Scissors ***\n" +
                "Please type corresponding letter to choose your shape\n" +
                "Rock - r\n" +
                "Paper - p\n" +
                "Scissors - s\n" +
                "May the better win!\n" +
                "\r\n" +
                "Choose the first shape\r\n" +
                "You have chosen: PAPER\r\n" +
                "Choose the second shape\r\n" +
                "You have chosen: PAPER\r\n" +
                "Fight!\r\n" +
                "A truce!\r\n" +
                "Thank you for playing!";
        //act
        this.rpsGame.play();

        //assert
        Assertions.assertEquals(expected,this.outputStreamCaptor.toString().trim());
    }

    @Test
    public void testIncorrectInputs() {
        //arrange
        Mockito.when(this.scanner.nextLine()).thenReturn("wrong", "p", "wrong", "r");
        final var expected = "*** Starting Rock - Paper - Scissors ***\n" +
                "Please type corresponding letter to choose your shape\n" +
                "Rock - r\n" +
                "Paper - p\n" +
                "Scissors - s\n" +
                "May the better win!\n" +
                "\r\n" +
                "Choose the first shape\r\n" +
                "Please type correct shape\r\n" +
                "You have chosen: PAPER\r\n" +
                "Choose the second shape\r\n" +
                "Please type correct shape\r\n" +
                "You have chosen: ROCK\r\n" +
                "Fight!\r\n" +
                "PAPER wins!\r\n" +
                "Thank you for playing!";

        //act
        this.rpsGame.play();

        //assert
        Assertions.assertEquals(expected,this.outputStreamCaptor.toString().trim());
    }


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.rpsGame = new RpsGame(this.scanner);
        System.setOut(new PrintStream(this.outputStreamCaptor));
    }


    @AfterEach
    public void tearDown() {
        System.setOut(this.standardOut);
    }
}