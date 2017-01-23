import entities.Word;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Frequencies {

    //TODO: need to make projectedWF more flexible in terms of dealing with stuff like a document is one word long,
    // only contains one word, etc - look at algorithms

    public static ArrayList<Double> projectedWordFrequency(ArrayList<String> cleanedText) {
        ArrayList<Double> projectedFrequencies = new ArrayList<>();

        double documentSize = cleanedText.size();

        for (int denominator = 1; denominator < documentSize; denominator++) {
            //TODO: figure out how to make this flexible
            double result = documentSize / (denominator);
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

    //TODO: unsigned numbers and two's complement - issue with actual - projected
    public static ArrayList<Double> compareFrequencies(ArrayList<Double> actualFrequencies, ArrayList<Double> projectedFrequencies){

        ArrayList<Double> frequencyDifferences = new ArrayList<>();

        for(int i = 0; i < actualFrequencies.size(); i++){
            double difference = projectedFrequencies.get(i) - actualFrequencies.get(i);
            frequencyDifferences.add(difference);
        }

        return frequencyDifferences;
    }
}
