import javax.swing.*;
import java.util.ArrayList;

public class Frequencies {

    public static ArrayList<Double> projectedWordFrequency(ArrayList<String> cleanedText){
        ArrayList<Double> projectedFrequency = new ArrayList<>();

        double documentSize = cleanedText.size();

        for(int denominator = 2; denominator < 10; denominator++){
            double result = documentSize / denominator;
            result = result / documentSize;
            projectedFrequency.add(result);
        }

        return projectedFrequency;
    }

    public static double actualWordFrequency(String cleanedText){

        double actualFrequency = 0.0;

        return actualFrequency;
    }
}
