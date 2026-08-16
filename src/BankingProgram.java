import java.util.Scanner;

public class BankingProgram {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        //JAVA BANKING PROGRAM

        double bal = 40.00;
        int choice;
        boolean isRunning = true;



        while (isRunning) {


            System.out.println("***************");
            System.out.println("BANKING PROGRAM");
            System.out.println("***************");
            System.out.println("1. check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. WithDraw");
            System.out.println("4. Exit");
            System.out.println("***************");


            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            scanner.nextLine();


            switch (choice){
                case 1 -> showBalance(bal);
                case 2 -> bal += deposit();
                case 3 -> bal -= withDraw(bal);
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");
            }

        }



    }

    static void showBalance(double bal){
        System.out.println("***************");
        System.out.printf("₱%.2f\n", bal);
    }
    static double deposit(){

        double amount;

        System.out.print("Enter the amount to deposit: ");
        amount = scanner.nextDouble();

        if (amount <= 0){
            System.out.println("Amount can't be NEGATIVE!");
            return 0;
        }
        else {
            return amount;
        }

    }
    static double withDraw(double bal){

        double amount;

        System.out.print("Enter the amount you want to deposit: ");
        amount = scanner.nextDouble();

        if (amount > bal){

            System.out.println("INSUFFICIENT FUNDS");
            return 0;

        }
        else if(amount <= 0){

            System.out.println("amount you withdraw can't be negative");
            return 0;
        }
        else {
            return amount;
        }

    }
}
