
//this is just an implementation of a searching algorithm in order to make searching for a word in an
//array list faster

import java.util.ArrayList;
import java.util.Arrays.*;

public class IsWordInList {

    public static boolean isWordInList(ArrayList<String> wordList, String word){
        Boolean check = false;

        String[] holdingArray = new String[wordList.size()];
        for(int i = 0; i < wordList.size();i ++){

            /***
             * notes: char is two bytes
             * need to look at other algorithms to see if something takes less work / is more efficient
             * convert target word to byte something
             * convert byte to number
             *
             * determine largest string using length then use to establish byte array size
             * string to char array
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


            holdingArray[i] = wordList.get(i);
        }

        return check;
    }

}
