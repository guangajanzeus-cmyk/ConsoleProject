import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<User1> accounts = new ArrayList<>();
    private int nextAccountNumber = 1001;

    public void start() {
        System.out.println("Welcome to the Bank System!");
    }

    public User1 createAccount(String username, String pin, String accountType) {
        String accountNumber = String.valueOf(nextAccountNumber++);
        User1 newUser = new User1(accountNumber, username.trim(), pin.trim(), accountType.trim(), 0.0);
        accounts.add(newUser);
        return newUser;
    }

    public User1 login(String accountNumber, String username, String pin) {
        String trimmedAccountNumber = accountNumber.trim();
        String trimmedUsername = username.trim();
        String trimmedPin = pin.trim();

        for (User1 user : accounts) {
            if (user.getAccountNumber().equals(trimmedAccountNumber)
                    && user.getUsername().equals(trimmedUsername)
                    && user.getPIN().equals(trimmedPin)) {
                return user;
            }
        }
        return null;
    }

    public List<User1> getAccounts() {
        return accounts;
    }
}
