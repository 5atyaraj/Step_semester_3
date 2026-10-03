import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {

    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {

    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class P3_LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            switch (type) {
                case "BOOK":
                    items.add(new Book(title, daysLate));
                    break;

                case "DVD":
                    items.add(new DVD(title, daysLate));
                    break;

                case "MAGAZINE":
                    items.add(new Magazine(title, daysLate));
                    break;
            }
        }

        double totalFines = 0;

        for (LibraryItem item : items) {
            double fine = item.calculateFine();

            System.out.printf(
                    "%s: %.2f%n",
                    item.getTitle(),
                    fine
            );

            totalFines += fine;
        }

        System.out.printf(
                "Total Fines: %.2f%n",
                totalFines
        );

        sc.close();
    }
}