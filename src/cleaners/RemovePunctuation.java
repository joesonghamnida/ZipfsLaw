package cleaners;

import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class RemovePunctuation {

    public static ArrayList<String> removePunctuation(ArrayList<String> rawText) {
        ArrayList<String> cleanedText = new ArrayList<>();
        String[] punctuationMarks = {".", ",", ":", ";", "?","<", ">", "\\", "'","{", "}", "*","-","_","(",")","[","]","|", "!", "/", "@", "#", "$", "%", "^", "&", "\"", "+", "~", "`", "="};

        for (String word : rawText) {

            String cleanedWord = "";

            for (String punctuation : punctuationMarks) {
                if (word.contains(punctuation)) {
                    cleanedWord = word.replace(punctuation, "");
                    cleanedWord.trim();
                    word = cleanedWord;
                } else {
                    cleanedWord = word;
                }
            }
            cleanedText.add(cleanedWord.toLowerCase());
        }

        return cleanedText;
    }

}
