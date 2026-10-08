import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MiniInventory
{

    public static void main (String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //int mainChoice;
        boolean ProductRunning = true;
        int MainDropChoice;
        int secondChoice;

        while (ProductRunning)
        {

            System.out.println("Mini Inventory 2.0");
            System.out.println("******************");
            System.out.println("1. Product ManageMent");
            System.out.println("2. Stock Control");
            System.out.println("3. Inventory Report");
            System.out.println("4. Exit");


            System.out.print("Input your choice: ");
            int mainChoice = Integer.parseInt(scanner.nextLine().trim());

            Inventory2point0 inventory2point0 = new Inventory2point0();


            switch (mainChoice)
            {


                case 1 ->
                {

                    boolean ProductDropPlaying = true;

                    while (ProductDropPlaying) {
                        System.out.println("***********");
                        System.out.println("1. Add Product");
                        System.out.println("2. View All Product");
                        System.out.println("3. Search Product by ID");
                        System.out.println("4. Exit the Menu");
                        System.out.println("5. Exit the Program");

                        System.out.print("Input the choice (1-5): ");
                        MainDropChoice = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("******************");

                        switch (MainDropChoice) {

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
                            case 4 : ProductDropPlaying = false;
                            break;
                            case 5 : ProductDropPlaying = false; ProductRunning = false;
                            break;
                            default : System.out.println("INVALID CHOICE!");

                        }
                    }


                }
                case 2 ->
                {

                    boolean StockControlRunning = true;
                    while(StockControlRunning)
                    {

                        System.out.println("********************");
                        System.out.println("1. Restock Product");
                        System.out.println("2. Sell/Reduce Stock");
                        System.out.println("3. Check Stock");
                        System.out.println("4. Exit in the Menu");
                        System.out.println("5. Exit the Program");
                        System.out.println("********************");

                        System.out.print("Enter your choice (1-5): ");
                        secondChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (secondChoice)
                        {
                            case 1:
                            {
                                System.out.print("Input the Product ID: ");
                                int stock = scanner.nextInt();
                                System.out.print("How many products arrived? : ");
                                int restock = scanner.nextInt();

                                ProductManagement stocked = Inventory2point0.searchById(stock);

                                if (stocked == null)
                                {
                                    System.out.println("No ID product Found!");
                                }
                                else
                                {
                                    System.out.println("ID FOUND IN THE INVENTORY!");

                                    int total = stocked.getQuantity() + restock;

                                    stocked.setQuantity(total);

                                    ArrayList<ProductManagement> products =
                                            Inventory2point0.ViewAllProducts();

                                    for (ProductManagement p : products)
                                    {
                                        System.out.println(
                                                "ID: " + p.getID()
                                                        + ", name: " + p.viewProducts()
                                                        + ", Quantity: " + p.getQuantity()
                                        );
                                    }
                                }

                                break;
                            }

                            case 2 :
                            {
                                System.out.print("Enter the ID of the product: ");
                                int IDStock = scanner.nextInt();
                                System.out.print("How many stock have to be reduce? : ");
                                int reduceStock = scanner.nextInt();

                                ProductManagement reduce = Inventory2point0.searchById(IDStock);

                                if (reduce == null )
                                {
                                    System.out.println("ID DIDN'T FOUND!");
                                }
                                else
                                {
                                    System.out.println("ID FOUND!");

                                    if (reduceStock > reduce.getQuantity())
                                    {
                                        System.out.println("Wait, we only have " + reduce.getQuantity());
                                    }
                                    else
                                    {
                                        int subtract = reduce.getQuantity() - reduceStock;
                                        reduce.setQuantity(subtract);

                                        ArrayList<ProductManagement> products = Inventory2point0.ViewAllProducts();
                                        for (ProductManagement p : products) {
                                            System.out.println(
                                                    "ID: " + p.getID()
                                                            + ", name: " + p.viewProducts()
                                                            + ", Quantity: " + subtract

                                            );
                                        }
                                    }
                                    break;
                                }
                            }
                            case 3 :
                            {
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
                            case 4 : StockControlRunning = false;
                            break;
                            case 5 : ProductRunning = false;
                            break;
                            default:
                                System.out.println("INVALID CHOICE");
                        }
                    }

                }
                case 4 -> ProductRunning = false;
                default -> System.out.println("INVALID CHOICE!");
            }
        }

        scanner.close();

    }
}
