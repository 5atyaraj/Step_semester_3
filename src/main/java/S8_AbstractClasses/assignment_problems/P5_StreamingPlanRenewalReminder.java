import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate calculateRenewalDate();

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        // Basic plan is valid for 30 days
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        // Standard plan is valid for 90 days
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        // Premium plan is valid for 365 days
        return startDate.plusDays(365);
    }
}

public class P5_StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<SubscriptionPlan> subscriptions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            switch (planType) {

                case "BASIC":
                    subscriptions.add(new BasicPlan(name, startDate));
                    break;

                case "STANDARD":
                    subscriptions.add(new StandardPlan(name, startDate));
                    break;

                case "PREMIUM":
                    subscriptions.add(new PremiumPlan(name, startDate));
                    break;
            }
        }

        // Polymorphic processing
        for (SubscriptionPlan plan : subscriptions) {
            LocalDate renewalDate = plan.calculateRenewalDate();

            System.out.println(plan.getName() + ": " + renewalDate);
        }

        sc.close();
    }
}