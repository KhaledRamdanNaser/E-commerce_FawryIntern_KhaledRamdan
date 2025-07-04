public class Customer {
    private String name;
    private Address address;
    private double balance;

    public Customer() {
    }

    public Customer(String name, Address address, double balance) {
        this.name = name;
        this.address = address;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public boolean checkBalance(double amount)
    {
        if(balance>=amount)
        {
            balance-=amount;
            return true;
        }
        else {
            return false;
        }
    }
    public void addBalance(double amount)
    {
        if(amount>0)
        {
            balance+=amount;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", balance=" + balance +
                '}';
    }
}
