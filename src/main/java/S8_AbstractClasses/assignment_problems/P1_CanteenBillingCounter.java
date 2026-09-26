import java.util.*;

abstract class Customer {
    protected double billAmount;

    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}

class Student extends Customer {
    public Student(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        // Students get 10% discount
        return billAmount - (billAmount * 0.10);
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    public Staff(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        // Staff get 5% discount
        return billAmount - (billAmount * 0.05);
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    public Guest(double billAmount) {
        super(billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        // Guests pay full amount + Rs.10 service charge
        return billAmount + 10.0;
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }
}

public class P1_CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {

                case "STUDENT":
                    customers.add(new Student(amount));
                    break;

                case "STAFF":
                    customers.add(new Staff(amount));
                    break;

                case "GUEST":
                    customers.add(new Guest(amount));
                    break;
            }
        }

        double total = 0.0;

        // Polymorphic processing
        for (Customer customer : customers) {

            double finalAmount = customer.calculateFinalAmount();

            System.out.printf(Locale.US, "%s: %.2f%n", customer.getCustomerType(), finalAmount
            );

            total += finalAmount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);

        sc.close();
    }
}