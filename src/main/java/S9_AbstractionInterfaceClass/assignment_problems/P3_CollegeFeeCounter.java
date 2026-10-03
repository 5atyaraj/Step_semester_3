import java.util.*;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    protected static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();

    public String getName() {
        return name;
    }
}

class DayScholar extends Student implements BusUser {

    private static final double TUITION_FEE = 40000.0;

    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return TUITION_FEE + getTransportFee();
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {

    private static final double TUITION_FEE = 40000.0;
    private static final double HOSTEL_FEE = 60000.0;

    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return TUITION_FEE + HOSTEL_FEE;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    private static final double SCHOLARSHIP_TUITION = 20000.0;

    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return SCHOLARSHIP_TUITION + getTransportFee();
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class P3_CollegeFeeCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;

                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;

                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
            }
        }

        double totalCollected = 0.0;

        for (Student student : students) {
            double fee = student.calculateFee();

            System.out.printf(
                    "%s: %.2f%n",
                    student.getName(),
                    fee
            );

            totalCollected += fee;
        }

        System.out.printf(
                "Total Collected: %.2f%n",
                totalCollected
        );

        sc.close();
    }
}