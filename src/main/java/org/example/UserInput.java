package org.example;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String getUserInputAsString() {
        return scanner.nextLine();
    }

    public int getUserInputAsInt() {
        return scanner.nextInt();
    }
}
