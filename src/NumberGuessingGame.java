import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args){

        //Number Guessing Game

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int guess = 0;
        int min = 1;
        int max = 100;
        int attempt = 0;
        int randomNumber = random.nextInt(min, max + 1 );

        System.out.println("**********************");
        System.out.println("Number Guessing Game");
        System.out.println("Guess a number (1-100)");
        System.out.println("**********************");
        


            do {
                System.out.print("Enter your guess: ");
                
                try {
                    guess = scanner.nextInt();
                    attempt++;

                    if (guess > randomNumber) {
                        System.out.println("Too HIGH!!!!");
                    } else if (guess < randomNumber) {
                        System.out.println("Too LOW!!!!");
                    } else {
                        System.out.println("Correct!, The number was " + randomNumber);
                        System.out.println("# of Attempts: " + attempt);
                    }
                }
                catch(InputMismatchException e){
                        System.out.println("You might input something that is not a Number");
                    System.out.println("Please input the whole number: ");
                    scanner.next();
                    } catch(Exception e){
                        throw new RuntimeException(e);
                    }
                

            } while (guess != randomNumber);
        


        scanner.close();

    }
}
