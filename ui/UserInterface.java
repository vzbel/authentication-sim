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
        System.out.println(
                "Type your new account's password. (It must be at least 8 characters long, have no empty spaces, and contain a special character.)");
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

    public void notifyInsufficientPasswordComplexity() {
        System.out.println(
                "Please choose a stronger password. (Did you add a special character? Is the password at least 8 characters long?)");

    }

    public void notifyAccountCreationSuccess(Account a) {
        System.out.println("Success! Your new account" + " (" + a.getUsername() + ") " + "has been created. ");
    }

    public void notifyPasswordIsTheSameAsUsername() {
        System.out.println("The password cannot be the same as the username. Please try again.");
    }

    public void loginPromptUsername() {
        System.out.println("Enter your username: ");
    }

    public void loginPromptPassword() {
        System.out.println("Enter your password: ");
    }

    public void notifyUsernameDoesNotExist() {
        System.out.println("The username does not exist. Try again.");
    }

    public void notifyIncorrectPassword() {
        System.out.println("Incorrect Password. Try again.");
    }

    public void notifySuccessfulLogin(String username) {
        System.out.println("Success! You are now logged in as: " + username);
    }
}
