class TrafficLight {
    private String color;
    private final String id;

    // Constructor
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    // Move to the next color
    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    // Read-only access to color
    public String getColor() {
        return color;
    }

    // Read-only access to ID
    public String getId() {
        return id;
    }
}

public class P4_TheTrafficLight {
    public static void main(String[] args) {

        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("ID: " + t.getId());
        System.out.println("Initial Color: " + t.getColor());

        t.next();
        System.out.println("After next(): " + t.getColor());

        t.next();
        System.out.println("After next(): " + t.getColor());

        t.next();
        System.out.println("After next(): " + t.getColor());

        t.next();
        System.out.println("After next(): " + t.getColor());
    }
}