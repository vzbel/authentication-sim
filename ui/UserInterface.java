package ui;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("\nChoose an option (1 - 3):");
        System.out.println("1: Create new Account");
        System.out.println("2: Login");
        System.out.println("3: Logout\n");
    }

}
