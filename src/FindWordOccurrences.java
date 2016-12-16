import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joe on 12/15/16.
 */
public class FindWordOccurrences {

    public static HashMap findWordOccurrences(ArrayList<String> rawText){

        ArrayList<String> wordList = new ArrayList<>();

        HashMap<String, Integer> wordOccurrences = new HashMap<>();

        //TODO: I know this is incorrect, needs to be fixed to accurately reflect word occurrence
        int count = 0;

        //TODO: this is using simple linear search atm, refactor to do binary on the word lists
        for(String word : rawText){
            if(!wordList.contains(word)){
                wordList.add(word);
                wordOccurrences.put(word,count++);
            }
            else{
                wordOccurrences.put(word, count++);
            }
        }

        //print out for testing stuff
        System.out.println(wordOccurrences.size());

        return wordOccurrences;
    }
}
