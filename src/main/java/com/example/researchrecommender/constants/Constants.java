package com.example.researchrecommender.constants;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public final class Constants {
    private Constants() {}
    public static Set<String> STOP_WORDS = new HashSet<>(Arrays.asList( "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", "yourselves",
            "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself", "they", "them", "their",
            "theirs", "themselves", "what", "which", "who", "whom", "this", "that", "these", "those", "am", "is", "are",
            "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing", "a", "an",
            "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for", "with", "about",
            "against", "between", "into", "through", "during", "before", "after", "above", "below", "to", "from", "up",
            "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when",
            "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "no", "nor",
            "not", "only", "own", "same", "so", "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now"));

    public static ArrayList<String> SYMBOLS = new ArrayList<>(Arrays.asList(".", ",", "!", "?", ";", ":", "-", "—", "(", ")", "[", "]", "{", "}", "'", "\"", "/", "\\", "@", "#", "$",
            "%", "^", "&", "*", "_", "+", "=", "<", ">", "|", "~", "’"));

    public static String COMMA_DELIMITER = ",";

    public final String FILE_URL = "https://res.cloudinary.com/dsz4woagj/raw/upload/v1689238662/data_po2dzf.csv";

    public static String DEFAULT_EMAIL = "htyagi066@gmail.com";
}