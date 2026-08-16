import java.util.Scanner;

public class CalculatorProgram {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        //CALCULATOR PROGRAM


        char operator;
        double result = 0;
        boolean validOperator = true;
        boolean isRunning = true;
        int choice;


        while (isRunning) {

            System.out.println("***************************");
            System.out.println("1. Calculate in Addition");
            System.out.println("2. Calculate in Subtraction");
            System.out.println("3. Calculate in Division");
            System.out.println("4. Calculate using power");
            System.out.println("5. Exit the program");
            System.out.println("***************************");

            System.out.print("Enter you choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> Adding(result);
                case 2 -> Subtract(result);
                case 3 -> Division(result);
                case 4 -> toThePowerBy(result);
                case 5 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");

            }

        }
        System.out.println("EXITED THE PROGRAM");
        System.out.println("BYE");

        scanner.close();

    }


    static double Adding(double result){

        double num1;
        double num2;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        result = num1 + num2;
        System.out.println(result);

        return num1 + num2;

    }
    static double Subtract(double result){

        double num1;
        double num2;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        result = num1 - num2;
        System.out.println(result);

        return num1 + num2;

    }
    static double Division(double result){

        double num1;
        double num2;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        result = num1 / num2;

        if (num2 == 0){
            System.out.println("Can't Divided by ZERO!!");
        }

        System.out.println(result);

        return num1 + num2;
    }
    static double toThePowerBy(double result){

        double num1;
        double num2;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        result = Math.pow(num1, num2);
        System.out.println(result);

        return num1 + num2;
    }
}
