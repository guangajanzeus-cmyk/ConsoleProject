import java.util.*;

 public class InventoryManagementSystem{

     public static void main(String[] args){

         int choice;
         boolean isRunning = true;

         Scanner scanner = new Scanner(System.in);

         System.out.println("*********************************");
         System.out.println("***Inventory Management System***");
         System.out.println("*********************************");
         System.out.println("*********************************");
         System.out.println("IMS Option : ");
         System.out.println("1. Add Product");
         System.out.println("2. View All Product");
         System.out.println("3. Update Quantity");
         System.out.println("4. Remove Product");
         System.out.println("5. Exit");
         System.out.println("*********************************");


         System.out.println();

         Inventory inventory = new Inventory();

         while (isRunning){


             System.out.print("Choose an Option: ");
             choice = scanner.nextInt();

             switch (choice) {
                 case 1 :        System.out.print("Enter the Name of the Product: ");
                                 String name = scanner.next();
                                 scanner.nextLine();
                                 System.out.print("Enter the product price: ");
                                 double price = scanner.nextDouble();
                                 System.out.print("Enter the quantity of the product: ");
                                 int quantity = scanner.nextInt();

                                 Product newProduct = new Product(name, price , quantity);
                                 inventory.addProducts(newProduct);
                                 System.out.println("Product adds successfully");
                                 break;

                 case 2 :
                     ArrayList<Product> products = inventory.getProducts();
                     if (products.isEmpty()) {
                         System.out.println("No products in Inventory");
                     }
                     else {
                         System.out.println("Products found!");
                         for (Product p : products) {
                             System.out.println("name: " + p.getName() + ", price: " + p.getPrice() + ", quantity: " + p.getQuantity());
                         }
                     }
                     break;

                 case 3 :
                     System.out.print("Enter product name to update quantity: ");
                     String updateName = scanner.next();
                     boolean found = false;
                     for (Product p : inventory.getProducts()){
                         if (p.getName().equalsIgnoreCase(updateName)) {
                             System.out.print("Enter new quantity: ");
                             int newQuantity = scanner.nextInt();
                             p.setQuantity(newQuantity);
                             System.out.println("Successfully Updated!");
                             found = true;
                             break;
                         }
                     }
                     if (!found) {
                         System.out.println("product not found");
                     }
                     break;

                 case 4 :
                     System.out.print("Enter product name to remove: ");
                     String removeName = scanner.next();
                     found = false;
                     for (Product p : inventory.getProducts()){
                         if (p.getName().equalsIgnoreCase(removeName)){
                             inventory.removeProduct(p);
                             System.out.println("Product removed Successfully!");
                             found = true;
                             break;
                         }
                     }
                     if (!found) {
                         System.out.println("Product not found");
                     }
                     break;
                 case 5 : isRunning = false;
                 break;
                 default : System.out.println("INVALID OPTION");
             }

         }

         System.out.println("Thanks for using INVENTORY MANAGEMENT SYSTEM!");
         System.out.println("PROGRAM ENDED!");



         scanner.close();
     }
 }
