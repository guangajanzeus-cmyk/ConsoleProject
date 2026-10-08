public class ProductManagement {

    private final String viewAllProducts;
    private int quantities;
    private int ID;

    public ProductManagement(String addProducts, String searchProductByID, int quantities)
    {
        this.viewAllProducts = addProducts;
        this.quantities = quantities;
    }

    public ProductManagement(String addProducts, int quantity)
    {
        this.viewAllProducts = addProducts;
        this.quantities = quantity;
    }

    public String viewProducts()
    {
        return this.viewAllProducts;
    }

    public int getQuantity()
    {
        return quantities;
    }

    public void setQuantity(int quantity)
    {
        this.quantities = quantity;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }
}