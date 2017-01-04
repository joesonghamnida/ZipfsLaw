package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by joe on 12/19/16.
 */
public class SortByFrequency {

    //TODO:

    /***
     * refactor to improve readability, cut out deadwood
     * CURRENT RESULTS NOT ACCURATE
     * do something about returning the sorted words and associated counts
     * maybe object or hashmap again?
     * clustering? would have to control for all the single-occurrence words
     */

/***
    public static void sortByFrequency(HashMap<String, Integer> wordOccurrences) {

        //do something with clustering? If words occur the same # of times, maybe related

        ArrayList<Integer> originalCountOrder = new ArrayList<>();
        ArrayList<String> originalWordOrder = new ArrayList<>();

        for (String key : wordOccurrences.keySet()) {
            originalCountOrder.add(wordOccurrences.get(key));
            originalWordOrder.add(key);
        }

        int[] sortedCountOrder = new int[wordOccurrences.size()];

        for (int j = 0; j < wordOccurrences.size(); j++) {
            sortedCountOrder[j] = originalCountOrder.get(j);
        }

        Arrays.sort(sortedCountOrder);

        ArrayList<String> usedWords = new ArrayList<>();
        ArrayList<Integer> usedIndices = new ArrayList<>();

        HashMap<String, Integer> sortedHashMap = new HashMap<>();

        for (int i = 0; i < originalCountOrder.size(); ++i) {
            int positionalIndex = originalCountOrder.indexOf(sortedCountOrder[i]);
            if (usedIndices.contains(positionalIndex)) {
                positionalIndex = i++;
            }
            usedIndices.add(positionalIndex);

            int adjustedPositionalIndex = positionalIndex;

            String word = originalWordOrder.get(positionalIndex);
            if (usedWords.contains(word)) {
                word = originalWordOrder.get(adjustedPositionalIndex);
            }

            usedWords.add(word);

            int count = sortedCountOrder[i];

            sortedHashMap.put(word,count);

            System.out.printf("Word: %s Count: %d Position: %d\n", originalWordOrder.get(adjustedPositionalIndex), sortedCountOrder[i], positionalIndex);
            if(sortedCountOrder[i] == wordOccurrences.get(word)){
                System.out.println("okay");
            }
            else{
                System.out.println("Error");
            }
        }

        /*for(String key : originalWordOrder){
            if(wordOccurrences.get(key).equals(sortedHashMap.get(key))){
                System.out.println("");
            }
            else{
                System.out.printf("Error - Word: %s     Orig: %d    Adj: %d\n",key, wordOccurrences.get(key),sortedHashMap.get(key));
            }
        }*/

        //return sortedPairs;
    }





