package com.ac.simulator.utility;

import java.util.Scanner;

public class CommandLineUtility {

    private final Scanner scanner = new Scanner(System.in);

    public void printMessage(String message) {
        System.out.print(message);
    }

    public String takeInput() {
        return scanner.nextLine();
    }

    public void printFormattedMessage(String message, Object... vars) {
        System.out.printf(message, vars);
    }
}
