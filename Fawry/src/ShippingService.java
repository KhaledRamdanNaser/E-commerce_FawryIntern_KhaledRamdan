import java.util.ArrayList;

public class ShippingService {
    public static void shipingItems(ArrayList<Shippable> products) {
        double totalWeight = 0;

        System.out.println("\n ** Shipping Notice **");
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> weights = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (Shippable product : products) {
            String name = product.getName();
            double weight = product.getWeight();

            int index = names.indexOf(name);
            if (index == -1) {
                names.add(name);
                weights.add(weight);
                counts.add(1);
            } else {
                weights.set(index, weights.get(index) + weight);
                counts.set(index, counts.get(index) + 1);
            }

            totalWeight += weight;
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(counts.get(i) + "x " + names.get(i) + "\t" + weights.get(i) + "g");
        }
        System.out.printf("Total package weight: %f kg\n", totalWeight / 1000.0);
    }
}

