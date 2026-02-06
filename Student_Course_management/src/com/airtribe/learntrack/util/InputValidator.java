package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) throws InvalidInputException {
        return getIntInput(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getIntInput(String prompt, int min, int max) throws InvalidInputException {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    throw new InvalidInputException("Value must be between " + min + " and " + max);
                }
                return value;
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter a valid number.");
            }
        }
    }
}
