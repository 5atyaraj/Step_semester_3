package main.java.S3_ControlFlow.assignment_problems;

public class Q1L1VotingEligibility {

    static void checkVotingEligibility(int age) {

        boolean eligible = age >= 18;

        if (eligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {

        checkVotingEligibility(20);
        checkVotingEligibility(16);
    }
}