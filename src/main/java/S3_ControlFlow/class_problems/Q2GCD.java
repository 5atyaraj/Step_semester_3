package main.java.S3_ControlFlow.class_problems;

import java.util.Scanner;

public class Q2GCD{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number1: ");
        int number1 = sc.nextInt();

        System.out.print("Enter number2: ");
        int number2 = sc.nextInt();

        int originalNumber1 = number1;
        int originalNumber2 = number2;

        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }

        System.out.println("The GCD of " + originalNumber1 + " and "
                + originalNumber2 + " is " + number1);

        sc.close();
    }
}