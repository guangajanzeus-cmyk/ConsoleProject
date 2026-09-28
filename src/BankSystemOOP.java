import java.util.Scanner;

    public class BankSystemOOP {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Bank bank = new Bank();
            bank.start();

            User1 newUser = createAccount(scanner, bank);
            System.out.println("================================");
            System.out.println("Account created successfully!");
            System.out.println("Type: " + newUser.getAccountType());
            System.out.println("Account Number: " + newUser.getAccountNumber());
            System.out.println("Username: " + newUser.getUsername());
            System.out.println("================================");

            User1 loggedInUser = login(scanner, bank);

            bankMenu(scanner, loggedInUser);
            scanner.close();
        }

        private static User1 createAccount(Scanner scanner, Bank bank) {
            System.out.println("================================");
            System.out.println("Create Your Account");
            System.out.println("================================");

            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Choose account type (1 = Savings, 2 = Checking, 3 = Business): ");
            String accountTypeInput = scanner.nextLine().trim();

            String accountType;
            switch (accountTypeInput) {
                case "1":
                    accountType = "Savings";
                    break;
                case "2":
                    accountType = "Checking";
                    break;
                case "3":
                    accountType = "Business";
                    break;
                default:
                    System.out.println("Invalid account type. Defaulting to Savings.");
                    accountType = "Savings";
                    break;
            }

            System.out.print("Create a PIN: ");
            String pin = scanner.nextLine().trim();

            return bank.createAccount(username, pin, accountType);
        }

        private static User1 login(Scanner scanner, Bank bank) {
            User1 loggedInUser = null;

            while (loggedInUser == null) {
                System.out.println("================================");
                System.out.println("Login to Your Account");
                System.out.println("================================");

                System.out.print("Account Number: ");
                String accountNumber = scanner.nextLine().trim();

                System.out.print("Username: ");
                String username = scanner.nextLine().trim();

                System.out.print("PIN: ");
                String pin = scanner.nextLine().trim();

                loggedInUser = bank.login(accountNumber, username, pin);

                if (loggedInUser == null) {
                    System.out.println("Invalid account number, username, or PIN. Please try again.");
                }
            }

            System.out.println("Login successful!");
            return loggedInUser;
        }

        private static void bankMenu(Scanner scanner, User1 user) {
            boolean exit = false;

            while (!exit) {
                System.out.println("================================");
                System.out.println("Welcome, " + user.getUsername() + "!");
                System.out.println("Account Type: " + user.getAccountType());
                System.out.println("================================");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("===============================");
                        System.out.println("Current balance: ₱" + user.getBalance());
                        break;
                    case "2":
                        System.out.print("Enter amount to deposit: ");
                        try {
                            double amount = Double.parseDouble(scanner.nextLine());
                            user.deposit(amount);
                            System.out.println("===============================");
                            System.out.println("Deposit successful. New balance: ₱" + user.getBalance());
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                        break;
                    case "3":
                        System.out.print("Enter amount to withdraw: ");
                        try {
                            double amount = Double.parseDouble(scanner.nextLine());
                            user.withdraw(amount);
                            System.out.println("===============================");
                            System.out.println("Withdrawal successful. New balance: ₱" + user.getBalance());
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "4":
                        System.out.println("===============================");
                        System.out.println("Thank you for using the bank system.");
                        System.out.println("===============================");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
