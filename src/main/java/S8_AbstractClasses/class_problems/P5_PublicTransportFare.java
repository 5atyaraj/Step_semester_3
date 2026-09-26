import java.util.*;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTransportType();
}

class Bus extends Transport {

    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);

        // Maximum bus fare is 10
        return Math.min(fare, 10.0);
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }
}

class Train extends Transport {

    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }
}

public class P5_PublicTransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            switch (type) {

                case "BUS":
                    journeys.add(new Bus(distance));
                    break;

                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;

                case "METRO":
                    double peakHourFactor = sc.nextDouble();
                    journeys.add(new Metro(distance, peakHourFactor)
                    );
                    break;
            }
        }

        double total = 0.0;

        // Polymorphic processing
        for (Transport transport : journeys) {
            double fare = transport.calculateFare();

            System.out.printf(Locale.US, "%s: %.2f%n", transport.getTransportType(), fare);

            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);

        sc.close();
    }
}