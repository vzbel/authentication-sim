package ui;

import java.util.Scanner;
import accounts.Account;

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

    public void askForNewUsername() {
        System.out.println("Type the username you would like to use on the new account.");
    }

    public void askForNewPassword() {
        System.out.println("Type your new account's password.");
    }

    public void askForNewPasswordConfirm() {
        System.out.println("Type your new account's password again.");
    }

    public void notifyNewPasswordMismatch() {
        System.out.println("The passwords do not match. Try again.");
    }

    public void notifyUsernameTaken() {
        System.out.println("The username is already taken. Please choose another.");
    }

    public void notifyAccountCreationSuccess(Account a) {
        System.out.println("Success! Your new account" + " (" + a.getUsername() + ") " + "has been created. ");
    }

}
