package com.ava.tasks;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

/**
 * Implementation of the Rock-Paper-Scissors game
 */
public class RpsGame {

    private static final String INTRO = """
            *** Starting Rock - Paper - Scissors ***
            Please type corresponding letter to choose your shape
            Rock - r
            Paper - p
            Scissors - s
            May the better win!
            """;

    private final static int win = 1;
    private final static int defeat = -1;
    private final static int truce = 0;
    private final Scanner scan = new Scanner(System.in);

    public void play() {

        System.out.println(INTRO);
        System.out.println("Choose the first shape");
        final RPS shapeOne = validateAndSet(scan, scan.nextLine());


        System.out.println("Choose the second shape");
        final RPS shapeTwo = validateAndSet(scan, scan.nextLine());

        System.out.println("Fight!");
        final var result = shapeOne.battleWith(shapeTwo);
        determineResult(shapeOne, shapeTwo, result);

        System.out.println("Thank you for playing!");
    }

    private void determineResult(RPS shapeOne, RPS shapeTwo, int result) {
        switch (result){
            case win -> System.out.printf("%s wins!%n", shapeOne);
            case defeat -> System.out.printf("%s wins!%n", shapeTwo);
            case truce -> System.out.println("A truce!");
        }
    }

    private RPS validateAndSet(Scanner scan, String shape) {
        while (RPS.parseShortName(shape).isEmpty()) {
            System.out.println("Please type correct shape");
            shape = scan.nextLine();
        }
        final RPS rps = RPS.parseShortName(shape).get();
        System.out.printf("You have chosen: %s%n", rps);
        return rps;
    }


    private enum RPS {
        ROCK("r"),
        PAPER("p"),
        SCISSORS("s");

        final String shortName;


        RPS(String shortName) {
            this.shortName = shortName;
        }

        public static Optional<RPS> parseShortName(String shortName) {
            return Arrays.stream(RPS.values()).filter(rps -> rps.shortName.equals(shortName))
                    .findFirst();
        }

        public int battleWith(RPS secondShape) {
            return switch (this){
                case PAPER -> facePaperOpponent(secondShape);
                case ROCK -> faceRockOpponent(secondShape);
                case SCISSORS -> faceScissorsOpponent(secondShape);
            };
        }

        private int facePaperOpponent(RPS secondShape) {
            return switch (secondShape){
                case ROCK -> win;
                case PAPER -> truce;
                case SCISSORS -> defeat;
            };
        }
        private int faceRockOpponent(RPS secondShape) {
            return switch (secondShape){
                case ROCK -> truce;
                case PAPER -> defeat;
                case SCISSORS -> win;
            };
        }
        private int faceScissorsOpponent(RPS secondShape) {
            return switch (secondShape){
                case ROCK -> defeat;
                case PAPER -> win;
                case SCISSORS -> truce;
            };
        }


    }
}
