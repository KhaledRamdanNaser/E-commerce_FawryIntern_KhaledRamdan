import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Shipping case\n");
        System.out.println("----------------------------");
        Address address = new Address("Cairo","Nasr St.","10A","01000000000");
        Customer customer = new Customer("Ahmed", address, 10000);
        Dairy cheese = new Dairy("Cheese", 100, 5, 400, LocalDate.of(2025, 8, 1));
        Electronics tv = new Electronics("TV", 6000, 2, 7000);
        scratchCard card = new scratchCard("Scratch Card", 50, 10);
        Snack biscuit=new Snack("biscuit",10,5,LocalDate.now().minusYears(2));
        Snack chocolate=new Snack("chocolate",20,5,LocalDate.now().plusYears(10));

        Cart cart = new Cart(customer);
        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 1);
        cart.addProduct(card, 3);
        cart.addProduct(biscuit,3);
        cart.addProduct(chocolate,2);
        cart.checkout();

        System.out.println("\n With no shipping case\n");
        System.out.println("----------------------------");

        Address address2 = new Address("Cairo","Nasr St.","10A","01000000000");
        Customer customer2 = new Customer("Ahmed", address2, 10000);
        scratchCard card2 = new scratchCard("Scratch Card", 50, 10);
        Cart cart2 = new Cart(customer2);
        cart2.addProduct(card2, 3);
        cart2.checkout();

        System.out.println("\n Expired Product case \n");
        System.out.println("----------------------------");

        Address address3 = new Address("Cairo","Nasr St.","10A","01000000000");
        Customer customer3 = new Customer("Ahmed", address3, 10000);
        Dairy cheese3 = new Dairy("Cheese", 100, 5, 400, LocalDate.of(2023, 8, 1));
        Electronics tv3 = new Electronics("TV", 6000, 2, 7000);
        scratchCard card3 = new scratchCard("Scratch Card", 50, 10);
        Cart cart3 = new Cart(customer3);
        cart3.addProduct(cheese3, 2);
        cart3.addProduct(tv3, 1);
        cart3.addProduct(card3, 3);
        cart3.checkout();

        System.out.println("\n Cart is empty case \n");
        System.out.println("----------------------------");

        Address address4 = new Address("Cairo","Nasr St.","10A","01000000000");
        Customer customer4 = new Customer("Ahmed", address4, 10000);
        Dairy cheese4 = new Dairy("Cheese", 100, 5, 400, LocalDate.of(2025, 8, 1));
        Electronics tv4 = new Electronics("TV", 6000, 0, 7000);
        Cart cart4 = new Cart(customer4);
        cart4.addProduct(cheese4, 6);
        cart4.addProduct(tv4, 1);
        cart4.checkout();

        System.out.println("\n One Product out of stock case \n");
        System.out.println("----------------------------");

        Address address5 = new Address("Cairo","Nasr St.","10A","01000000000");
        Customer customer5 = new Customer("Ahmed", address5, 10000);
        Dairy cheese5 = new Dairy("Cheese", 100, 5, 400, LocalDate.of(2025, 8, 1));
        Electronics tv5 = new Electronics("TV", 6000, 0, 7000);
        Cart cart5 = new Cart(customer5);
        cart5.addProduct(cheese5, 4);
        cart5.addProduct(tv5, 1);
        cart5.checkout();

        System.out.println("\n **Insufficient Balance Case** \n");
        System.out.println("----------------------------");

        Address address6 = new Address("Cairo","Nasr St.","10A","01000000000");
        Customer customer6 = new Customer("Ahmed", address5, 100);
        Dairy cheese6 = new Dairy("Cheese", 100, 5, 400, LocalDate.of(2025, 8, 1));
        Electronics tv6 = new Electronics("TV", 6000, 0, 7000);
        Cart cart6 = new Cart(customer6);
        cart6.addProduct(cheese6, 4);
        cart6.addProduct(tv6, 1);
        cart6.checkout();
    }
}