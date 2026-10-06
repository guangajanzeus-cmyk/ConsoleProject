import java.util.ArrayList;
import java.util.Random;

public class Inventory2point0 {

    private static ArrayList<ProductManagement> products = new ArrayList<>();
    private static Random random = new Random();

    public static void addProducts(ProductManagement product) {
        int id = 100000 + random.nextInt(900000);
        product.setID(id);
        products.add(product);
        System.out.println("Saved with ID: " + id);
    }

    public static ArrayList<ProductManagement> ViewAllProducts() {
        return products;
    }

    public static ProductManagement searchById(int id) {
        for (ProductManagement p : products) {
            if (p.getID() == id) {
                return p;
            }
        }
        return null;
    }
}