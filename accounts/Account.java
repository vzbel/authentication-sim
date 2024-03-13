package accounts;

public class Account {
    private String username;
    private String password;
    private String identifier;

    public Account(String username, String password, String identifier) {
        this.username = username;
        this.password = password;
        this.identifier = identifier;
    }

    public String toString() {
        return this.username + " " + identifier;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

}
