import java.time.LocalDate;

public class Dairy extends Product implements Shippable{
private double weight;
private LocalDate expiryDate;

    public Dairy(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }
    public boolean isExpired(){
        return expiryDate.isBefore(LocalDate.now());
    }
    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }

}
