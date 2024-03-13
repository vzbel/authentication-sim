import java.util.Scanner;
import ui.UserInterface;
import accounts.Account;
import accounts.AccountBase;
import java.util.ArrayList;
import java.util.Random;

public class MainAuth {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        UserInterface ui = new UserInterface(scnr);
        AccountBase db = new AccountBase();

        while (true) {
            ui.displayMenu();
            String userInput = scnr.nextLine();
            if (userInput.equals("3")) {
                break;
            }

            switch (userInput) {
                case "1":
                    ui.askForNewUsername();
                    String username = scnr.nextLine();

                    // handle taken username
                    while (db.usernameExists(username)) {
                        ui.notifyUsernameTaken();
                        ui.askForNewUsername();
                        username = scnr.nextLine();
                    }

                    // pw
                    ui.askForNewPassword();
                    String password = scnr.nextLine();

                    while (!db.passwordLengthIsValid(password, 8) || password.equals(username)) {
                        if (password.equals(username)) {
                            ui.notifyPasswordIsTheSameAsUsername();
                            password = scnr.nextLine();
                        } else if (!db.passwordLengthIsValid(password, 8)) {
                            ui.notifyInsufficientPasswordComplexity();
                            password = scnr.nextLine();
                        }
                    }

                    ui.askForNewPasswordConfirm();
                    boolean newPasswordsMatch = password.equals(scnr.nextLine());

                    // handle password confirmation mismatch
                    while (!newPasswordsMatch) {
                        ui.notifyNewPasswordMismatch();
                        ui.askForNewPassword();
                        password = scnr.nextLine();
                        ui.askForNewPasswordConfirm();
                        newPasswordsMatch = password.equals(scnr.nextLine());
                    }

                    // gen userID
                    Random random = new Random();
                    String identifier = Integer.toString(random.nextInt());

                    Account acc = new Account(username, password, identifier);
                    db.addAccount(acc);
                    ui.notifyAccountCreationSuccess(acc);
                    break;
                case "2":
                    ui.loginPromptUsername();
                    String loginUsername = scnr.nextLine();

                    while (!db.usernameExists(loginUsername)) {
                        ui.notifyUsernameDoesNotExist();
                        loginUsername = scnr.nextLine();
                    }

                    ui.loginPromptPassword();
                    String loginPassword = scnr.nextLine();
                    while (!db.verifyLogin(loginUsername, loginPassword)) {
                        ui.notifyIncorrectPassword();
                        loginPassword = scnr.nextLine();
                    }

                    ui.notifySuccessfulLogin(loginUsername);
                    break;
            }
        }

    }

}