import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joe on 12/16/16.
 */
public class CheckWordCount {

    public static String checkWordCount(HashMap<String, Integer> wordOccurrences, ArrayList cleanedText){
        String message = "";

        int j = 0;
        int test = 0;
        for(String keyStep : wordOccurrences.keySet()){
            test = test + wordOccurrences.get(keyStep);
            j++;
        }

        System.out.printf("Unique words: %d\n",j);
        System.out.printf("Total words: %d\n",test);

        if(test == cleanedText.size()){
            message = "Word count is correct.\n";
        }
        else {
            message = "Word count incorrect.\nError in FindWordOccurrences.";
        }

        return message;
    }

}
