import java.util.Scanner;
import java.util.Random;

class ColorGame {
    String name;
    double balance;

    String dice1;
    String dice2;
    String dice3;

    void bet(String color, double amount) {
        if (amount > balance) {
            System.out.println("Not enough balance!");
            return;
        }

        balance -= amount;
        System.out.println(name + " placed a bet of " + amount + " on " + color);

        rollDice();
        checkResult(color, amount);
    }

    void rollDice() {
        String[] colors = {"Red", "Yellow", "Blue", "Green", "White", "Pink"};
        Random rng = new Random();

        dice1 = colors[rng.nextInt(colors.length)];
        dice2 = colors[rng.nextInt(colors.length)];
        dice3 = colors[rng.nextInt(colors.length)];

        System.out.println("Dice result: " + dice1 + " " + dice2 + " " + dice3);
    }

    void checkResult(String color, double amount) {
        int matches = 0;

        if (dice1.equalsIgnoreCase(color)) matches++;
        if (dice2.equalsIgnoreCase(color)) matches++;
        if (dice3.equalsIgnoreCase(color)) matches++;

        if (matches > 0) {
            double prize = amount * matches * 1.50; // more matches = bigger prize
            balance = prize + balance;
            System.out.println(name + " won " + prize + "! Balance: " + balance);
        } else {
            System.out.println(name + " lost. No prize. Balance: " + balance);
        }
    }
}

public class colorGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ColorGame game = new ColorGame();

        System.out.print("Enter your name: ");
        game.name = sc.nextLine();
        game.balance = 100; // starting balance

        System.out.println("Welcome, " + game.name + "! Starting balance: " + game.balance);
        System.out.println("Colors: Red, Yellow, Blue, Green, White, Pink");

        boolean playing = true;
        while (playing && game.balance > 0) {
            System.out.print("\nBet color (or 'quit'): ");
            String color = sc.next().toLowerCase();

            if (color.equalsIgnoreCase("quit")) {
                playing = false;
                continue;
            }

            System.out.print("Bet amount: ");
            double amount = sc.nextDouble();

            game.bet(color, amount);
        }

        System.out.println("\nThanks for playing, " + game.name + "! Final balance: " + game.balance);
        sc.close();
    }
}

