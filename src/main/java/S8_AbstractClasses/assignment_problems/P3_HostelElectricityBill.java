import java.util.*;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getRoomType();
}

class SingleRoom extends Room {

    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        // Single room: Rs.8 per unit
        return units * 8.0;
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {

    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        // Shared room: Rs.6 per unit,
        // divided equally among occupants
        return (units * 6.0) / occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }
}

class ACRoom extends Room {

    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        // AC room: Rs.10 per unit + Rs.200 fixed charge
        return (units * 10.0) + 200.0;
    }

    @Override
    public String getRoomType() {
        return "AC";
    }
}

public class P3_HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;

                case "AC":
                    rooms.add(new ACRoom(units));
                    break;
            }
        }

        double total = 0.0;

        // Polymorphic processing
        for (Room room : rooms) {
            double bill = room.calculateBill();

            System.out.printf(Locale.US, "%s: %.2f%n", room.getRoomType(), bill);

            total += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);

        sc.close();
    }
}
