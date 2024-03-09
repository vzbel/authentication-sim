package accounts;

import java.util.ArrayList;

public class AccountBase {
    private ArrayList<Account> accounts;

    public AccountBase() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public ArrayList<Account> getAccountList() {
        return this.accounts;
    }
}
