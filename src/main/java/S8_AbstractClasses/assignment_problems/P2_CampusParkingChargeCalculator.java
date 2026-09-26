import java.util.*;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getVehicleType();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // Bike: Rs.10 per hour
        return 10.0 * hours;
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // First hour: Rs.30
        // Each additional hour: Rs.20
        return 30.0 + (hours - 1) * 20.0;
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // Truck: Rs.50 per hour
        // Minimum charge: Rs.100
        double charge = 50.0 * hours;
        return Math.max(charge, 100.0);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }
}

public class P2_CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;

                case "CAR":
                    vehicles.add(new Car(hours));
                    break;

                case "TRUCK":
                    vehicles.add(new Truck(hours));
                    break;
            }
        }

        double total = 0.0;

        // Polymorphic processing
        for (Vehicle vehicle : vehicles) {

            double charge = vehicle.calculateCharge();

            System.out.printf(Locale.US, "%s: %.2f%n", vehicle.getVehicleType(), charge);

            total += charge;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);

        sc.close();
    }
}
