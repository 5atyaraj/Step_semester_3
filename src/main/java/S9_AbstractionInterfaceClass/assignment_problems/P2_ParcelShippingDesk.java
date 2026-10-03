import java.util.*;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public double calculateInsurance() {
        return 0.0;
    }

    public double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {

    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weightKg);
    }
}

class ExpressParcel extends Parcel implements Insurable {

    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {

    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        // Standard charge + handling fee
        return 40.0 + (10.0 * weightKg) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class P2_ParcelShippingDesk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Parcel> parcels = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            types.add(type);

            switch (type) {
                case "STANDARD":
                    parcels.add(
                            new StandardParcel(weight, declaredValue)
                    );
                    break;

                case "EXPRESS":
                    parcels.add(
                            new ExpressParcel(weight, declaredValue)
                    );
                    break;

                case "FRAGILE":
                    parcels.add(
                            new FragileParcel(weight, declaredValue)
                    );
                    break;
            }
        }

        double grandTotal = 0.0;

        for (int i = 0; i < parcels.size(); i++) {
            Parcel parcel = parcels.get(i);

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    types.get(i),
                    charge,
                    insurance,
                    total
            );

            grandTotal += total;
        }

        System.out.printf(
                "Grand Total: %.2f%n",
                grandTotal
        );

        sc.close();
    }
}