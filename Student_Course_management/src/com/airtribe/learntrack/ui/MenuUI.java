package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.util.InputValidator;
import com.airtribe.learntrack.exception.InvalidInputException;

import java.util.Scanner;

public abstract class MenuUI {
    protected final Scanner scanner = new Scanner(System.in);

    protected int getMenuChoice(String[] options) {
        while (true) {
            printMenu(options);
            try {
                int choice = InputValidator.getIntInput("Enter choice: ", 0, options.length );
                return choice;
            } catch (InvalidInputException e) {
                System.out.println( e.getMessage());
            }
        }
    }

    protected void printMenu(String[] options) {
        System.out.println("\n=== " + getMenuTitle() + " ===");
        for (int i = 0; i < options.length ; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("0. Back");
    }

    protected abstract String getMenuTitle();
}
