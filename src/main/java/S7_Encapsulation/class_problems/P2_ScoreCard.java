class Scorecard {
    private final boolean[] results;
    private int answerCount;

    // Constructor
    public Scorecard(int questionCount) {
        results = new boolean[questionCount];
        answerCount = 0;
    }

    // Record the next answer
    public void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        }
    }

    // Get total score
    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class P2_ScoreCard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}