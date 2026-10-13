import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MiniInventory
{
    static Scanner scanner = new Scanner(System.in);
    static boolean ProductRunning = true;

    public static void main (String[] args)
    {


        Random random = new Random();

        //int mainChoice;
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
                case 3 ->
                {
                    InventoryReports();
                }
                case 4 -> ProductRunning = false;
                default -> System.out.println("INVALID CHOICE!");
            }
        }
        System.out.println("Come back AGAIN!!!");
        System.out.println("Thanks for using the Computer Program");

        scanner.close();

    }

    static int InventoryReports()
    {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("***********************");
            System.out.println("1. Total Product Types");
            System.out.println("2. Total Units in stock");
            System.out.println("3. Low-stock products");
            System.out.println("4. Inventory Listing");
            System.out.println("5. Exit the Menu Program");
            System.out.println("6 Exit clearly in the program");
            System.out.println("***********************");

            System.out.print("Enter your Choice (1-4) : ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1: {
                    int totalItems = Inventory2point0.ViewAllProducts().size();
                    System.out.println("Total Product Types: "+totalItems);
                    break;
                }
                case 2 : {

                    int totalQuantity = 0;
                    ArrayList<ProductManagement> totalQuantities = Inventory2point0.ViewAllProducts();
                    for (ProductManagement item : Inventory2point0.ViewAllProducts())
                    {
                        totalQuantity += item.getQuantity();
                    }
                    System.out.println("*******************");
                    System.out.println("Total Units in stock: " + totalQuantity);
                    break;
                }
                case 3 : {

                    for (ProductManagement lowStockProducts : Inventory2point0.ViewAllProducts()) {
                        if (lowStockProducts.getQuantity() <= 10) {

                                System.out.println("Item: " + lowStockProducts.viewProducts()+"\n" + "Quantity: " + lowStockProducts.getQuantity() + "\n**************");

                        }
                    }

                    break;
                }
                case 4 :
                {
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
                case 5 : {
                    isRunning = false;
                    break;
                }
                case 6 : {
                    isRunning = false;
                    ProductRunning = false;
                    break;
                }
                default :
                    System.out.println("Invalid Choice");
            }
        }


     return 0;
    }
}
