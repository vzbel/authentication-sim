package accounts;

import java.util.ArrayList;

public class AccountBase {
    private ArrayList<Account> accounts;
    private ArrayList<String> usernames;

    public AccountBase() {
        this.accounts = new ArrayList<>();
        this.usernames = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
        this.usernames.add(account.getUsername());
    }

    public ArrayList<Account> getAccountList() {
        return this.accounts;
    }

    public boolean usernameExists(String username) {
        if (usernames.contains(username)) {
            return true;
        }
        return false;
    }

    public boolean passwordLengthIsValid(String password, int minLength) {
        return password.length() >= minLength;
    }
}
