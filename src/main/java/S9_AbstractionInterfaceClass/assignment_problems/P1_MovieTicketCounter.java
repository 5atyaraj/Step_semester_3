import java.util.*;

abstract class Ticket {
    protected int count;

    // Common fee - written in one place only
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    protected abstract double getPricePerTicket();

    public double calculateAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {

    public RegularTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {

    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {

    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    protected double getPricePerTicket() {
        return 400.0;
    }
}

public class P1_MovieTicketCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Ticket> tickets = new ArrayList<>();
        List<String> seats = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            seats.add(seat);

            switch (seat) {
                case "REGULAR":
                    tickets.add(new RegularTicket(count));
                    break;

                case "PREMIUM":
                    tickets.add(new PremiumTicket(count));
                    break;

                case "RECLINER":
                    tickets.add(new ReclinerTicket(count));
                    break;
            }
        }

        double total = 0.0;

        for (int i = 0; i < tickets.size(); i++) {
            double amount = tickets.get(i).calculateAmount();

            System.out.printf(
                    "%s: %.2f%n",
                    seats.get(i),
                    amount
            );

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}