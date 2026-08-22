import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProducts(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void removeProduct(Product product){
        products.remove(product);
    }
}

