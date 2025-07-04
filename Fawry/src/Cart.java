import java.util.ArrayList;

public class Cart {
private ArrayList<Product> products=new ArrayList<>();
private  ArrayList<Integer> quantities=new ArrayList<>();
private static final double shippingFee=30;
private Customer customer;

    public Cart(Customer customer) {
        this.customer = customer;
    }
    public void addProduct(Product product,int q)
    { //start of addProduct method
        //To check if product is expired or no
        if (product.isExpired())
        {
            System.out.println("Cannot add expired products: "+product.getName());
            return;
        }
        //to check there is enough stock or no
        if (product.getQuantity()<q){
            System.out.println("No enough stock: "+product.getName());
            return;
        }
        //to check is product in cart or no
        int isInCart=products.indexOf(product);
        if (isInCart>0)
        {
            quantities.set(isInCart,quantities.get(isInCart)+q);
        }
        else {
            products.add(product);
            quantities.add(q);
        }
        product.decreaseProductQuantity(q);
        System.out.println("Added  "+q+"x "+product.getName()+" to cart");
    }// END of addProduct method

    //get total prices of product without shipping
    public double subTotal()
    {//start of subTotal method
        double total=0;
        for (int i=0;i<products.size();i++)
        {
            total+=products.get(i).getPrice()*quantities.get(i);
        }
        return total;
    }// End of subTotal Method

    public boolean isShippableProduct()
    {//start of isShippableProduct method
        for (Product p: products)
        {
            if(p instanceof Shippable)
            {
                return true;
            }
        }
        return false;
    }//End of isShippableProduct method
    public double Total()
    {//start of Total method
        double shipping=0;
        if (isShippableProduct())
        {
            shipping=shippingFee;
        }
        return subTotal()+shipping;
    }//end of Total method

    public boolean checkout()
    { //start of checkout Method
        if (products.isEmpty())
        {
            System.out.println("Cart is Empty");
            return false;
        }

       for (int i=0;i<products.size();i++)
       {
            Product p= products.get(i);
            if (p.isExpired())
            {
                System.out.println("Checkout Failed, Product Expired: "+p.getName());
                return false;
            }
       }//end of for loop

        double totalAmount=Total();
        if (!customer.checkBalance(totalAmount)){
            System.out.println("Insufficient Balance");
            return false;
        }
        //Handling Shipping Service
        ArrayList<Shippable> shippedProducts=new ArrayList<>();
        for (int i=0;i<products.size();i++){
            Product p= products.get(i);
            int q= quantities.get(i);
            if(p instanceof Shippable)
            {
                for (int j=0;j<q;j++)
                {
                    shippedProducts.add((Shippable) p);
                }
            }
        }
        if(!shippedProducts.isEmpty())
        {
            ShippingService.shipingItems(shippedProducts);
        }
        printReceipt();
        return true;
    }// End of checkout method
    //Print final receipt
    public void printReceipt(){
        System.out.println("\n ** Checkout Receipt **");
        for (int i=0;i<products.size();i++)
        {
            Product p=products.get(i);
            int q=quantities.get(i);
            double total=p.getPrice()*q;
            System.out.println(q + "x " + p.getName() + "\t" + total);
        }
        System.out.println("----------------------------");
        System.out.println("Subtotal:\t" + subTotal());
        if (isShippableProduct())
        {
            System.out.println("Shipping:\t"+shippingFee);
        }
        else {
            System.out.println("Shipping:\t"+"0");
        }
        System.out.println("Total:\t\t" + Total());
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}// end of class
