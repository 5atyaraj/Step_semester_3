package main.java.S3_ControlFlow.assignment_problems;
public class Q2L1NaturalNumberSum {

    static void sumOfNaturalNumbers(int n) {

        int counter = 1;
        int sum = 0;

        while (counter <= n) {

            sum = sum + counter;
            counter++;
        }

        System.out.println(
            "Sum of numbers from 1 to " + n + " = " + sum
        );
    }

    public static void main(String[] args) {

        sumOfNaturalNumbers(5);
    }
}