package org.example.service;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String getUserInputAsString() {
        return scanner.next();
    }

    public int getUserInputAsInt() {
        return scanner.nextInt();
    }

    public char getUserInputAsChar() {return scanner.next().charAt(0);}
}
