package main.java.S2_StringOperations.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class Q5WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // Convert to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Create HashMap
        HashMap<String, Integer> frequency = new HashMap<>();

        // Count words
        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            // Check whether word is a stop word
            for (int j = 0; j < stopWords.length; j++) {

                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count frequency
            if (frequency.containsKey(words[i])) {

                frequency.put(
                    words[i],
                    frequency.get(words[i]) + 1
                );

            } else {

                frequency.put(words[i], 1);
            }
        }

        // Convert map entries into an array
        @SuppressWarnings("unchecked")
        Map.Entry<String, Integer>[] entries =
            frequency.entrySet().toArray(new Map.Entry[0]);

        // Sort by frequency in descending order
        for (int i = 0; i < entries.length - 1; i++) {

            for (int j = i + 1; j < entries.length; j++) {

                if (entries[i].getValue() < entries[j].getValue()) {

                    Map.Entry<String, Integer> temp = entries[i];

                    entries[i] = entries[j];
                    entries[j] = temp;
                }
            }
        }

        // Print result
        for (int i = 0; i < entries.length; i++) {

            System.out.println(
                entries[i].getKey() +
                " : " +
                entries[i].getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}