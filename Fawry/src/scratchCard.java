public class scratchCard extends Product {
    public scratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    public boolean isExpired()
    {
        return false;

    }

}
