import entities.Word;

import javax.swing.*;
import java.util.ArrayList;

public class Frequencies {

    public static ArrayList<Double> projectedWordFrequency(ArrayList<String> cleanedText) {
        ArrayList<Double> projectedFrequencies = new ArrayList<>();

        double documentSize = cleanedText.size();

        for (int denominator = 2; denominator < 10; denominator++) {
            double result = documentSize / denominator;
            result = result / documentSize;
            projectedFrequencies.add(result);
        }

        return projectedFrequencies;
    }

    public static ArrayList<Double> actualWordFrequency(ArrayList<Word> sortedWords, ArrayList<String> cleanedText) {
        ArrayList<Double> actualFrequencies = new ArrayList<>();

        for (Word word : sortedWords) {
            double average = (double) word.getFrequency() / (double) cleanedText.size();
            actualFrequencies.add(average);
        }

        return actualFrequencies;
    }

    public static void compareFrequencies(ArrayList<Double> actualFrequencies, ArrayList<Double> projectedFrequencies){

    }
}
