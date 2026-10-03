import java.util.*;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    protected double hours;

    protected static final double COST_PER_UNIT = 8.0;

    public Appliance(double hours) {
        this.hours = hours;
    }

    protected abstract double getPowerWatts();

    public double calculateUnits() {
        return (getPowerWatts() * hours) / 1000.0;
    }

    public double calculateCost() {
        return calculateUnits() * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {

    public Fridge(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {

    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 1500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    public TV(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {

    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class P5_HomeApplianceEnergyReport {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String applianceType = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            // Check whether SAVER is present
            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested = true;
            }

            Appliance appliance;

            switch (applianceType) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AirConditioner(hours);
                    break;

                case "TV":
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;

                default:
                    continue;
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(
                        applianceType + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = units * 8.0;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    applianceType,
                    units,
                    cost
            );

            totalCost += cost;
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                totalCost
        );

        sc.close();
    }
}