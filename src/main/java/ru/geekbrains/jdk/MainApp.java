package ru.geekbrains.jdk;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of field: ");
        int size = scanner.nextInt();
        System.out.print("Enter win length: ");
        int winLength = scanner.nextInt();

        new GameWindow(size, winLength);
        System.out.println("Method main() is over");
    }
}
