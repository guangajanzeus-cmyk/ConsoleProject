import java.util.Scanner;

class Total {

    private int price;
    private int quantity;

    public void setPrice(int price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public double calculateTotal(){
        return (double)  price * quantity;
    }

}

public class ShoppingCart {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Total total = new Total();

        System.out.println("*********************");
        System.out.println("Shopping Cart Program");
        System.out.println("*********************");
        System.out.println("1. Think of an Item");
        System.out.println("2. Price of the item you bought");
        System.out.println("3. How many items did you buy");
        System.out.println("4. Total");
        System.out.println("5. Exit");
        System.out.println("*********************");

        String item = "";
        int price = 0;
        int quantity = 0;
        char currency = '₱';
        boolean isRunning = true;
        int choice;

        while (isRunning) {

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> item = Item();
                case 2 -> {
                    price = Price();
                    total.setPrice(price);
                }
                case 3 -> {
                    quantity = Quantity();
                    total.setQuantity(quantity);
                }
                case 4 -> {
                    total.setPrice(price);
                    total.setQuantity(quantity);
                    System.out.printf("Current Total: %c%,.2f\n", currency, total.calculateTotal());
                }
                case 5 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");
            }
        }

        System.out.println("\nYou have bought " + quantity + " " + item + "(s)");
        System.out.printf("Your final total is %c%,.2f\n", currency, total.calculateTotal());
        System.out.println("THANKS FOR BUYING!!");

        scanner.close();
    }

    static String Item() {
        System.out.print("What would you like to buy: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Please put an Item you want to buy");
            return "";
        }
        return input;
    }

    static int Price() {
        System.out.print("What is the price for each: ");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (input < 0) {
            System.out.println("Can't buy for nothing");
            return 0;
        }
        return input;
    }

    static int Quantity() {
        System.out.print("How many item would you like to buy: ");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (input < 0) {
            System.out.println("No one is buying an Invisible item");
            return 0;
        }
        return input;
    }
}
