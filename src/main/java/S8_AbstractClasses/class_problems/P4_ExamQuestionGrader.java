import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();

    public abstract String getQuestionType();
}

class MCQQuestion extends Question {

    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0.0;
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        String studentLower = studentAnswer.toLowerCase();

        int matchCount = 0;

        for (String keyword : keywords) {
            keyword = keyword.trim().toLowerCase();

            if (studentLower.contains(keyword)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }
}

public class P4_ExamQuestionGrader {
    // Extract all text enclosed inside double quotes
    public static List<String> extractQuotedStrings(String line) {
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            result.add(matcher.group(1));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            // First word is question type
            String type = line.substring(0, line.indexOf(' '));

            // Extract:
            // 1. Question text
            // 2. Correct answer
            // 3. Student answer
            List<String> quoted = extractQuotedStrings(line);

            String questionText = quoted.get(0);
            String correctAnswer = quoted.get(1);
            String studentAnswer = quoted.get(2);

            // Points are after the final quotation mark
            int lastQuote = line.lastIndexOf('"');

            double points = Double.parseDouble(
                    line.substring(lastQuote + 1).trim()
            );

            switch (type) {

                case "MCQ":
                    questions.add(new MCQQuestion(questionText, correctAnswer, studentAnswer, points));
                    break;

                case "TF":
                    questions.add(new TrueFalseQuestion(questionText, correctAnswer, studentAnswer, points));
                    break;

                case "ESSAY":
                    questions.add(new EssayQuestion(questionText, correctAnswer, studentAnswer, points));
                    break;
            }
        }

        double totalScore = 0.0;

        // Polymorphic processing
        for (Question question : questions) {
            double score = question.calculateScore();

            System.out.printf(Locale.US, "%s: %.2f%n", question.getQuestionType(), score);

            totalScore += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", totalScore);

        sc.close();
    }
}