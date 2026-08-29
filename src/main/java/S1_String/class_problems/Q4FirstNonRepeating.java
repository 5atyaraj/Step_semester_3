package main.java.S1_String.class_problems;

import java.util.Scanner;

public class Q4FirstNonRepeating {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < str.length(); i++) {

            int count = 0;

            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println("First Non-Repeating Character: " + str.charAt(i));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No Non-Repeating Character Found.");
        }

        sc.close();
    }
}