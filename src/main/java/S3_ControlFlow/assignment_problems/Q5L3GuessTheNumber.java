package main.java.S3_ControlFlow.assignment_problems;

public class Q5L3GuessTheNumber {

    static void guessTheNumber(
            int secretNumber,
            int maxTries,
            int[] guesses) {

        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && tries < guesses.length) {

            int guess = guesses[tries];

            if (guess < secretNumber) {

                System.out.println("Too low");

            } else if (guess > secretNumber) {

                System.out.println("Too high");

            } else {

                System.out.println("Correct! You guessed it");

                guessed = true;

                break;
            }

            tries++;
        }

        if (!guessed) {

            System.out.println(
                "Out of tries — the number was " + secretNumber
            );
        }
    }

    public static void main(String[] args) {

        int[] guesses = {20, 60, 42};

        guessTheNumber(42, 4, guesses);
    }
}