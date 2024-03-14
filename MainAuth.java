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

        // current user data
        String currentUsername = "";
        // temp placeholder account
        Account initialAcc = new Account("init", "initpw", "0");
        // this will later store the user's current account, for now only uses
        // placeholder
        Account currentAccount = initialAcc;

        while (true) {
            ui.displayMenu();
            String userInput = scnr.nextLine();

            switch (userInput) {
                // sign up
                case "1":
                    ui.askForNewUsername();
                    String username = scnr.nextLine();

                    // handling taken usernames
                    while (db.usernameExists(username)) {
                        ui.notifyUsernameTaken();
                        ui.askForNewUsername();
                        username = scnr.nextLine();
                    }

                    // asking user for pw & store
                    ui.askForNewPassword();
                    String password = scnr.nextLine();

                    // checking if password meets requirements
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

                    // handling password confirmation mismatch
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

                    // create acc with user's info
                    Account acc = new Account(username, password, identifier);
                    db.addAccount(acc);
                    ui.notifyAccountCreationSuccess(acc);
                    currentUsername = acc.getUsername();
                    currentAccount = acc;
                    break;
                // log in
                case "2":
                    // checking if the user is "already logged in"
                    if (!currentUsername.isEmpty()) {
                        ui.notifyUserAlreadyLoggedIn(currentAccount.getUsername());
                        break;
                    }
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
                // logout
                case "3":

                    if (currentAccount.equals(initialAcc)) {
                        ui.notifyNotLoggedIn();
                        break;
                    }
                    // asking user to confirm logout
                    ui.askConfirmLogout(currentUsername);
                    String userLogoutResponse = scnr.nextLine();
                    boolean isValidResponse = userLogoutResponse.equalsIgnoreCase("Yes")
                            || userLogoutResponse.equalsIgnoreCase("No");

                    // handling invalid user response to logout confirmation
                    while (!isValidResponse) {
                        ui.notifyInvalidLogoutConfirmationResponse();
                        userLogoutResponse = scnr.nextLine();
                        isValidResponse = userLogoutResponse.equalsIgnoreCase("Yes")
                                || userLogoutResponse.equalsIgnoreCase("No");
                    }

                    // deciding based on user response
                    if (userLogoutResponse.equalsIgnoreCase("No")) {
                        ui.notifyReturningToMenu();
                        break;
                    } else {
                        currentAccount = initialAcc;
                        ui.notifySuccessfulLogout(currentUsername);
                        currentUsername = "";
                    }
                    break;
            }
        }

    }

}