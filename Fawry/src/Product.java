import java.time.LocalDate;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void increaseProductQuantity(int q){
        if(q>0){
            quantity+=q;
        }
    }
    public void decreaseProductQuantity(int q)
    {
        if (q<=quantity){
            quantity-=q;
        }
    }
    public abstract boolean isExpired();
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
