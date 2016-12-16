import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joe on 12/15/16.
 */
public class FindWordOccurrences {

    public static HashMap findWordOccurrences(ArrayList<String> rawText){

        ArrayList<String> wordList = new ArrayList<>();
        ArrayList<Integer> wordCount = new ArrayList<>();

        HashMap<String, Integer> wordOccurrences = new HashMap<>();

        //TODO: I know this is incorrect, needs to be fixed to accurately reflect word occurrence


        //TODO: this is using simple linear search atm, refactor to do binary on the word lists
        int count = 0;
        for(String word : rawText){
            count = 0;
            if(!wordList.contains(word)){
                wordList.add(word);
                wordCount.add(++count);
                //wordOccurrences.put(word,count);
                
            }
            else{
                //wordOccurrences.put(word, count++);
                //wordCount.add(wordList.indexOf(word),++count);
                count = wordCount.get(wordList.indexOf(word)) + 1;
                wordCount.remove(wordList.indexOf(word));
                wordCount.add(wordList.indexOf(word), count);
            }
        }

        //print out for testing stuff
        System.out.println(wordOccurrences.size());

        for(Integer i : wordCount){
            System.out.println("Count: "+i);
        }

        return wordOccurrences;
    }
}
