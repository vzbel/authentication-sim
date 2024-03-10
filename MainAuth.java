import java.util.Scanner;
import ui.UserInterface;
import accounts.Account;
import accounts.AccountBase;
import java.util.ArrayList;

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
                    ui.askForNewPassword();
                    String password = scnr.nextLine();
                    ui.askForNewPasswordConfirm();
                    boolean newPasswordsMatch = password.equals(scnr.nextLine());

                    while (!newPasswordsMatch) {
                        ui.notifyNewPasswordMismatch();
                        ui.askForNewPassword();
                        password = scnr.nextLine();
                        ui.askForNewPasswordConfirm();
                        newPasswordsMatch = password.equals(scnr.nextLine());
                    }
                    Account acc = new Account(username, password);
                    db.addAccount(acc);
                    break;
            }
        }
    }

}