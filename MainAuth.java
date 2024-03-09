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
                    System.out.println("Type the username you would like to use on the new account.");
                    String username = scnr.nextLine();
                    System.out.println("Type your new account's password.");
                    String password = scnr.nextLine();

                    Account acc = new Account(username, password);
                    db.addAccount(acc);
                    break;
            }
        }
    }

}