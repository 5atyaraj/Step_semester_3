import java.util.*;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    protected double km;

    protected static final double MINIMUM_FARE = 100.0;

    public Cab(double km) {
        this.km = km;
    }

    protected abstract double getRatePerKm();

    public double calculateFare() {
        double fare = km * getRatePerKm();

        // Common minimum fare rule
        return Math.max(fare, MINIMUM_FARE);
    }
}

class MiniCab extends Cab {

    public MiniCab(double km) {
        super(km);
    }

    @Override
    protected double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {

    public SedanCab(double km) {
        super(km);
    }

    @Override
    protected double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {

    public SUV(double km) {
        super(km);
    }

    @Override
    protected double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class P4_CityCabFareMeter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (cabType) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;

                case "SEDAN":
                    cab = new SedanCab(km);
                    break;

                case "SUV":
                    cab = new SUV(km);
                    break;

                default:
                    continue;
            }

            // Night service requested
            if (time.equals("NIGHT")) {

                if (!(cab instanceof NightService)) {
                    System.out.println(
                            cabType + ": night service not available"
                    );
                    continue;
                }

                double fare = cab.calculateFare();

                fare = ((NightService) cab).applyNightCharge(fare);

                System.out.printf(
                        "%s: %.2f%n",
                        cabType,
                        fare
                );

                total += fare;

            } else {
                double fare = cab.calculateFare();

                System.out.printf(
                        "%s: %.2f%n",
                        cabType,
                        fare
                );

                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}