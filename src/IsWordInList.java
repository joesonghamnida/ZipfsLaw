
//this is just an implementation of a searching algorithm in order to make searching for a word in an
//array list faster

/***
 *
 * possible algorithms:
 * Rabin - Karp
 * Knuth - Morris - Pratt
 * https://www.topcoder.com/community/data-science/data-science-tutorials/introduction-to-string-searching-algorithms/
 *
 * Progress: 12/18/16
 * -implemented hashing functions and binary search
 * -it "works"
 * problems:
 * -3 seconds linear search vs 58 using hashing & binary
 * -out of bounds exception with loading word in arraylist
 * -problems with mapping word -> it's word count (# of times it occurs in the document)
 *
 */

/***
 * notes: char is two bytes
 * need to look at other algorithms to see if something takes less work / is more efficient
 * convert target word to byte something
 * convert byte to number
 *
 * determine largest string using length then use to establish byte array size
 * string to char array
 * ..or just string to bytes or bits, and convert from that?
 * char to bytes
 * bytes to number
 * number to array
 * sort array
 * binary search / is target in array
 *
 * will need to break this into several functions
 * should probably only run word -> number once, store in array
 * binary can be ran multiple times
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays.*;



public class IsWordInList {
    //hashing, too slow
    public static int createTargetHash(String word) {
        int targetHash = word.hashCode();
        return targetHash;
    }

    //hashing, too slow
    public static Integer[] createHashArray(ArrayList<String> wordList) {

        Integer[] hashArray = new Integer[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            hashArray[i] = wordList.get(i).hashCode();

        }

        return hashArray;
    }

    //hashing, too slow
    public static boolean isWordInList(Integer[] hashArray, int hashedWord) {
        Boolean check = true;

        Arrays.sort(hashArray);
        int inList = Arrays.binarySearch(hashArray, hashedWord);

        if (inList < 0) {
            check = false;
        }
        return check;
    }

}
