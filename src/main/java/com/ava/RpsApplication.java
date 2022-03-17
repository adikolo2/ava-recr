package com.ava;

import com.ava.tasks.RpsGame;

/**
 * Execution of Rock-Paper-Scissors game
 */
public class RpsApplication {
    public static void main(String[] args) {
        final var rpsGame = new RpsGame();
        rpsGame.play();

    }
}
