package accounts;

public class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        return "Username: " + this.username;
    }
}
