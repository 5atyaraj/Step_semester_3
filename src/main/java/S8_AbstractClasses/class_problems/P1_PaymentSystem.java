import java.util.*;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getPaymentType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }

    @Override
    public String getPaymentType() {
        return "BANKTRANSFER";
    }
}

public class P1_PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;

                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;

                case "BANKTRANSFER":
                    payments.add(new BankTransferPayment(amount));
                    break;
            }
        }

        double total = 0.0;

        for (Payment payment : payments) {
            double adjustedAmount = payment.calculateFinalAmount();

            System.out.printf(Locale.US, "%s: %.2f%n", payment.getPaymentType(), adjustedAmount);

            total += adjustedAmount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);

        sc.close();
    }
}