package main.java.S1_String.class_problems;

import java.util.Random;
import java.util.Scanner;

public class Q1RPS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int userWins = 0;
        int computerWins = 0;
        int draws = 0;

        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("===== ROCK PAPER SCISSORS =====");
        System.out.println("1 = Rock");
        System.out.println("2 = Paper");
        System.out.println("3 = Scissors");

        for (int round = 1; round <= 5; round++) {

            System.out.println("\n------ Round " + round + " ------");

            System.out.print("Enter your choice (1-3): ");
            int userChoice = sc.nextInt();

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid Choice! Round Skipped.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("You chose      : " + choices[userChoice - 1]);
            System.out.println("Computer chose : " + choices[computerChoice - 1]);

            if (userChoice == computerChoice) {
                System.out.println("Result : Draw");
                draws++;
            }
            else if ((userChoice == 1 && computerChoice == 3) ||
                     (userChoice == 2 && computerChoice == 1) ||
                     (userChoice == 3 && computerChoice == 2)) {

                System.out.println("Result : You Win!");
                userWins++;
            }
            else {
                System.out.println("Result : Computer Wins!");
                computerWins++;
            }
        }

        System.out.println("\n========== FINAL RESULT ==========");
        System.out.println("Your Wins      : " + userWins);
        System.out.println("Computer Wins  : " + computerWins);
        System.out.println("Draws          : " + draws);

        double winPercentage = (userWins / 5.0) * 100;

        System.out.printf("Winning Percentage : %.2f%%\n", winPercentage);

        if (userWins > computerWins) {
            System.out.println("Overall Winner : You");
        }
        else if (computerWins > userWins) {
            System.out.println("Overall Winner : Computer");
        }
        else {
            System.out.println("Overall Match : Draw");
        }

        sc.close();
    }
}