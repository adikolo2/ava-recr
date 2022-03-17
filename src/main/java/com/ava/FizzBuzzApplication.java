package com.ava;

import com.ava.tasks.FizzBuzz;

/**
 * Execution of FizzBuzz task
 */
public class FizzBuzzApplication {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
        FizzBuzz.run(i);
        }
    }
}
