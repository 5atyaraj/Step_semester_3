class PiggyBank {
    private int savings;
    private final String id;

    // Constructor
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    public void deposit(int amount) {
        savings += amount;
    }

    // Withdraw money
    public void withdraw(int amount) {
        if (amount <= savings) {
            savings -= amount;
        }
    }

    // Get current savings
    public int getSavings() {
        return savings;
    }
}

public class P1_PiggyBank{
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("savings = " + pb.getSavings());
    }
}