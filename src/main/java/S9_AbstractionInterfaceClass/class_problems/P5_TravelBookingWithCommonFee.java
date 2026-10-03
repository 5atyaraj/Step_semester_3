import java.util.*;

abstract class TravelBooking {

    // Common booking fee - change only this line if required
    protected static final double BOOKING_FEE = 50.0;

    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    // Each mode provides its own base fare
    protected abstract double calculateBaseFare();

    // Common calculation for every booking
    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {

    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {

    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {

    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500 + (distanceKm * 4.0);
    }
}

public class P5_TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<TravelBooking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distanceKm = sc.nextDouble();

            modes.add(mode);

            switch (mode) {
                case "BUS":
                    bookings.add(new BusBooking(distanceKm));
                    break;

                case "TRAIN":
                    bookings.add(new TrainBooking(distanceKm));
                    break;

                case "FLIGHT":
                    bookings.add(new FlightBooking(distanceKm));
                    break;
            }
        }

        for (int i = 0; i < bookings.size(); i++) {
            double total = bookings.get(i).calculateTotal();

            System.out.printf(
                    "%s: %.2f%n",
                    modes.get(i),
                    total
            );
        }

        sc.close();
    }
}