package main.java.S2_StringOperations.assignment_problems;

public class Q4ISBNNormalizer {

    static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        String publisher = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return publisher + remaining;
    }

    static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < code.length(); i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(code.substring(0, 3));
        result.append("] YEAR: ");
        result.append(code.substring(3, 7));
        result.append(" | CATALOG: ");
        result.append(code.substring(7, 13));

        return result.toString();
    }

    public static void main(String[] args) {

        String rawCode = " pen2026004251 ";

        String normalizedCode = normalizeCode(rawCode);

        System.out.println(validateAndFormat(normalizedCode));


        String rawCode2 = "12N2026004251";

        String normalizedCode2 = normalizeCode(rawCode2);

        System.out.println(validateAndFormat(normalizedCode2));
    }
}