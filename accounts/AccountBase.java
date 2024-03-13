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
        return usernames.contains(username);
    }

    public boolean passwordLengthIsValid(String password, int minLength) {
        return password.length() >= minLength;
    }

    public boolean verifyLogin(String username, String password) {
        for (Account i : this.accounts) {
            if (i.getUsername().equals(username) && i.verifyPassword(password)) {
                return true;
            }
        }
        return false;
    }

}
