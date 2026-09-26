import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected LocalDate borrowDate;

    public LibraryItem(String title, LocalDate borrowDate) {
        this.title = title;
        this.borrowDate = borrowDate;
    }

    public abstract LocalDate calculateDueDate();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title, LocalDate borrowDate) {
        super(title, borrowDate);
    }

    @Override
    public LocalDate calculateDueDate() {
        return borrowDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    public DVD(String title, LocalDate borrowDate) {
        super(title, borrowDate);
    }

    @Override
    public LocalDate calculateDueDate() {
        return borrowDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, LocalDate borrowDate) {
        super(title, borrowDate);
    }

    @Override
    public LocalDate calculateDueDate() {
        return borrowDate.plusDays(3);
    }
}

public class P2_LibraryItemDue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int spaceIndex = line.indexOf(' ');

            String type = line.substring(0, spaceIndex);
            String title = line.substring(spaceIndex + 1).trim();

            // Remove surrounding quotation marks
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            switch (type) {
                case "BOOK":
                    items.add(new Book(title, currentDate));
                    break;

                case "DVD":
                    items.add(new DVD(title, currentDate));
                    break;

                case "MAGAZINE":
                    items.add(new Magazine(title, currentDate));
                    break;
            }
        }

        // Polymorphic processing
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate());
        }

        sc.close();
    }
}