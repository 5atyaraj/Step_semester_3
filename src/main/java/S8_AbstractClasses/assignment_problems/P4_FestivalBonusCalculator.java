import java.util.*;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        // Full-time employees get 10% bonus
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        // Part-time employees get 5% bonus
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        // Interns get a fixed bonus of Rs.2000
        return 2000.0;
    }
}

public class P4_FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double monthlySalary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees.add(new FullTimeEmployee(name, monthlySalary));
                    break;

                case "PARTTIME":
                    employees.add(new PartTimeEmployee(name, monthlySalary));
                    break;

                case "INTERN":
                    employees.add(new Intern(name, monthlySalary));
                    break;
            }
        }

        double totalBonus = 0.0;

        // Polymorphic processing
        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();

            System.out.printf(Locale.US, "%s: %.2f%n", employee.getName(), bonus);

            totalBonus += bonus;
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}
