import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MiniInventory
{

    public static void main (String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int choice;
        boolean isRunning = true;
        boolean isPlaying = true;
        int choices;

        while (isRunning)
        {

            System.out.println("Mini Inventory 2.0");
            System.out.println("******************");
            System.out.println("1. Product ManageMent");
            System.out.println("2. Stock Control");
            System.out.println("3. Inventory Report");
            System.out.println("4. Exit");


            System.out.print("Input your choice: ");
            choice = scanner.nextInt();

            Inventory2point0 inventory2point0 = new Inventory2point0();

            switch (choice)
            {
                case 1 ->
                {

                    while (isPlaying) {
                        System.out.println("***********");
                        System.out.println("1. Add Product");
                        System.out.println("2. View All Product");
                        System.out.println("3. Search Product by ID");
                        System.out.println("4. Exit the Menu");
                        System.out.println("5. Exit the Program");

                        System.out.print("Input the choice (1-5): ");
                        choices = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("******************");

                        switch (choices) {

                            case 1: {

                                System.out.print("Enter the product you want to add: ");
                                String addProduct = scanner.nextLine();
                                System.out.print("Enter the Quantity of the Product: ");
                                int quantity = scanner.nextInt();

                                ProductManagement newProduct = new ProductManagement(addProduct, quantity);
                                Inventory2point0.addProducts(newProduct);
                                System.out.println("Product Added successfully!");
                                break;
                            }

                            case 2: {
                                ArrayList<ProductManagement> products = Inventory2point0.ViewAllProducts();
                                if (products.isEmpty()) {
                                    System.out.println("No Products Found in Inventory!");
                                } else {
                                    System.out.println("Products Found!");
                                    for (ProductManagement p : products) {
                                        System.out.println(
                                                "ID: " + p.getID()
                                                        + ", name: " + p.viewProducts()
                                                        + ", Quantity: " + p.getQuantity()
                                        );
                                    }
                                }
                                break;
                            }

                            case 3: {
                                System.out.print("Enter the product ID: ");
                                int id = scanner.nextInt();

                                ProductManagement found = Inventory2point0.searchById(id);

                                if (found == null) {
                                    System.out.println("No product with that ID");
                                } else {
                                    System.out.println("ID FOUND!!");
                                    System.out.println(
                                            "ID: " + found.getID()
                                                    + ", name: " + found.viewProducts()
                                                    + ", Quantity: " + found.getQuantity()
                                    );
                                }
                                break;
                            }
                            case 4 : isPlaying = false;
                            break;
                            case 5 : isPlaying = false; isRunning = false;
                            break;
                            default : System.out.println("INVALID CHOICE!");

                        }
                    }


                }
                case 2 ->
                {

                }
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE!");
            }
        }

        scanner.close();

    }
}
