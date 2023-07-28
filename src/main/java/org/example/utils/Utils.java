package org.example.utils;

import java.util.*;

import static org.example.Constants.Constants.STOP_WORDS;
import static org.example.Constants.Constants.SYMBOLS;

public class Utils {

    public static void extractKeywords(String text) {

        // filter all sentence characters
        for (String symbol : SYMBOLS) {
            if (text.contains(symbol)) {
                text = text.replace(symbol, " ");
            }
        }

        // Preprocessing
        String[] words = text.toLowerCase().split("\\s+");

        // Stop Word Removal (using a simple predefined list)
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (!STOP_WORDS.contains(word)) {
                filteredWords.add(word);
            }
        }

        // Frequency Count
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : filteredWords) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Filter Keywords (threshold: at least 2 occurrences)
        List<String> keywords = new ArrayList<>();
        int frequencyThreshold = 1;

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() >= frequencyThreshold) {
                keywords.add(entry.getKey());
            }
        }

        // Print the extracted keywords
        System.out.println("Extracted Keywords:");
        for (String keyword : keywords) {
            System.out.println(keyword);
        }
        System.out.println();
    }
}
