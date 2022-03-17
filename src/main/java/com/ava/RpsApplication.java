package com.ava;

import com.ava.tasks.RpsGame;

import java.util.Scanner;

/**
 * Execution of Rock-Paper-Scissors game
 */
public class RpsApplication {
    public static void main(String[] args) {
        final var rpsGame = new RpsGame(new Scanner(System.in));
        rpsGame.play();

    }
}
