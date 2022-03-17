package com.ava.tasks;

/**
 * Implementation of a FizzBuzz problem
 */
public class FizzBuzz {

    public static void run(int i) {
        if (i == 0) return;
        if (i % 15 == 0) {
            System.out.printf("i:%d - FizzBuzz%n", i);
        } else if (i % 3 == 0) {
            System.out.printf("i:%d - Fizz%n", i);
        } else if (i % 5 == 0) {
            System.out.printf("i:%d - Buzz%n", i);
        }
    }
}
