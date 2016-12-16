import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joe on 12/15/16.
 */
public class FindWordOccurencies {

    public static HashMap findWordOccurencies(ArrayList<String> rawText){

        ArrayList<String> wordList = new ArrayList<>();

        HashMap<String, Integer> wordOccurencies = new HashMap<>();

        //TODO: I know this is incorrect, needs to be fixed to accurately reflect word occurence
        int count = 0;

        //TODO: this is using simple linear search atm, refactor to do binary on the word lists
        for(String word : rawText){
            if(!wordList.contains(word)){
                wordList.add(word);
                wordOccurencies.put(word,count++);
            }
            else{
                wordOccurencies.put(word, count++);
            }
        }
        return wordOccurencies;
    }
}
