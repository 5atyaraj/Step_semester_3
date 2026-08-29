package main.java.S3_ControlFlow.class_problems;

import java.util.Scanner;

public class Q3PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int origNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        if (reversedNumber == origNumber) {
            System.out.println("Is the number " + origNumber + " a Palindrome? true");
        } else {
            System.out.println("Is the number " + origNumber + " a Palindrome? false");
        }

        sc.close();
    }
}