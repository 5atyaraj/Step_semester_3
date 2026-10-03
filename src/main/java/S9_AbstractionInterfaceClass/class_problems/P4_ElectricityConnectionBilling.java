import java.util.*;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {

    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }
}

class ShopConnection extends ElectricityConnection {

    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8) + 100;
    }
}

class FactoryConnection extends ElectricityConnection {

    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class P4_ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            types.add(type);

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;

                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;

                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }

        double total = 0;

        for (int i = 0; i < connections.size(); i++) {
            double bill = connections.get(i).calculateBill();

            System.out.printf(
                    "%s: %.2f%n",
                    types.get(i),
                    bill
            );

            total += bill;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}