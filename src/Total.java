public class Total {

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
