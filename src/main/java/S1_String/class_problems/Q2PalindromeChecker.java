package main.java.S1_String.class_problems;

import java.util.Scanner;

public class Q2PalindromeChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char[] original = str.toCharArray();
        char[] reverse = new char[original.length];

        int j = 0;

        for (int i = original.length - 1; i >= 0; i--) {
            reverse[j] = original[i];
            j++;
        }

        boolean palindrome = true;

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i]) {
                palindrome = false;
                break;
            }
        }

        if (palindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        sc.close();
    }
}