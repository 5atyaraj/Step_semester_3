public class P1_LibraryCatalog {
    public static void main(String[] args) {

        String[] isbn = {
            "0001112223",
            "0002223334",
            "0003334445",
            "0004445556",
            "0005556667"
        };

        String[] title = {
            "Introduction to Algebra",
            "Beginning Python",
            "Classic Mythology",
            "Data and Society",
            "European History"
        };

        String target = "0003334445";

        int low = 0, high = isbn.length - 1;
        String result = "Not Found";

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = isbn[mid].compareTo(target);

            if (cmp == 0) {
                result = title[mid];
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);

        target = "0009998887";
        low = 0;
        high = isbn.length - 1;
        result = "Not Found";

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = isbn[mid].compareTo(target);

            if (cmp == 0) {
                result = title[mid];
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}