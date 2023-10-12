public class Item {
    private String name;
    private String sku;
    private double price;
    private int quantity;

    public Item(String name, String sku, double price, int quantity) {
        this.name = name;
        this.sku = sku;
        setPrice(price);
        setQuantity(quantity);
    }

    public double getTotalPrice(){
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        if ( price < 0 ){
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if ( quantity < 0 ){
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }
}
