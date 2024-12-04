package com.weathercli;

import java.util.Scanner;

public class UserInputHandler {
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city name or ZIP Code:");
        return scanner.nextLine();
    }
}
