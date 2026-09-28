public class User1 {
    private String accountNumber;
    private String username;
    private String PIN;
    private String accountType;
    private double balance;

    public User1(String accountNumber, String username, String PIN, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.PIN = PIN;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPIN() {
        return PIN;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance or invalid amount.");
        }
    }
}

