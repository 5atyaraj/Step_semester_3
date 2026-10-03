import java.util.*;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        double regularPay = 40 * rate;
        double overtimeHours = hours - 40;
        double overtimePay = overtimeHours * rate * 1.5;

        return regularPay + overtimePay;
    }
}

class Intern extends Staff {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class P2_WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FULLTIME":
                    staffList.add(
                            new FullTimeStaff(name, sc.nextDouble())
                    );
                    break;

                case "HOURLY":
                    staffList.add(
                            new HourlyStaff(
                                    name,
                                    sc.nextDouble(),
                                    sc.nextDouble()
                            )
                    );
                    break;

                case "INTERN":
                    staffList.add(
                            new Intern(name, sc.nextDouble())
                    );
                    break;
            }
        }

        double totalPayroll = 0;

        for (Staff staff : staffList) {
            double pay = staff.calculatePay();

            System.out.printf(
                    "%s: %.2f%n",
                    staff.getName(),
                    pay
            );

            totalPayroll += pay;
        }

        System.out.printf(
                "Total Payroll: %.2f%n",
                totalPayroll
        );

        sc.close();
    }
}