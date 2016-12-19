import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by joe on 12/15/16.
 */
public class FindWordOccurrences {

    public static HashMap findWordOccurrences(ArrayList<String> rawText) {

        ArrayList<String> wordList = new ArrayList<>();
        ArrayList<Integer> wordCount = new ArrayList<>();

        HashMap<String, Integer> wordOccurrences = new HashMap<>();

        //TODO: this is using simple linear search atm, refactor to do some search on the word lists

        int count = 0;
        for (String word : rawText) {

            count = 0;
            /***if (!IsWordInList.isWordInList(hashArray,targetHash)){
             * this creates an out of bounds exception
             */
            if (!wordList.contains(word)) {
                wordList.add(word);
                wordCount.add(++count);
            } else {
                count = wordCount.get(wordList.indexOf(word)) + 1;
                wordCount.remove(wordList.indexOf(word));
                wordCount.add(wordList.indexOf(word), count);
            }
        }

        for (String word : wordList) {
            wordOccurrences.put(word, wordCount.get(wordList.indexOf(word)));
        }

        return wordOccurrences;
    }
}
