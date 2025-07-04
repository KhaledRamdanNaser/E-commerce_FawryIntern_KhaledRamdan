public class Electronics extends Product implements Shippable{
    private double weight;

    public Electronics(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    public boolean isExpired(){
        return false;
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
