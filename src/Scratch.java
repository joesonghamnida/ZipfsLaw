
//scratchpad for figuring out how to convert string -> bytes -> int

import java.util.ArrayList;

public class Scratch {

    public static void main(String[] args) {

        String string = "bananas";
        System.out.println(string.hashCode());
        ArrayList <String> words = new ArrayList<>();
        words.add("a");
        words.add("aa");
        words.add("b");
        words.add("bb");
        words.add("c");
        words.add("cc");
        words.add("d");
        words.add("dd");
        words.add("e");
        words.add("eee");

        /*for(String s : words){
            int h = s.hashCode();
            System.out.println("hash: "+s.hashCode());
            System.out.println("int : "+h);
            if(s.hashCode() == h){
                System.out.println("match");
            }
            else{
                System.out.println("don't match");
            }
        }*/

        //System.out.println(IsWordInList.isWordInList(words,"aa"));

        //tree set or hash set?

//trying tree set
        /*TreeMap<Integer, Integer> sortedPairs = new TreeMap<>();
        int index = 0;
        for(String key : wordOccurrences.keySet()){
            sortedPairs.put(wordOccurrences.get(key), index);
            index++;
        }

        System.out.println("Tree map: "+sortedPairs.size());

        int i = 0;
        while(i < 10){
            System.out.println(sortedPairs.descendingMap());
            i++;

        #######only does unique values
        }*/

/*int i = 0;
        for(int rows = 0; rows < holdingCell.size();rows++){
            for (int columns = 0;columns < sortedPairs[rows].length;columns++){
                sortedPairs[rows][holdingCell.get(i)] = sortedPairs[rows][holdingCell.get(i)];
                i++;
            }
        }*/

//double array [index] [value] use to sort by highest to lowest, used index to
//keep track of the index associated with the original word
//triple array?
        /*int[][] sortedPairs = new int[wordOccurrences.size()][3];
        int r = wordOccurrences.size();
        int c = 2;


        int columns = 0;
        for (String key : wordOccurrences.keySet()){
                int count = wordOccurrences.get(key);
                sortedPairs[count][columns] = columns;
                columns++;
            }


        for (int rows = 0; rows < sortedPairs.length; rows++) {
            for(int col = 0; col < c; col++ )
            System.out.println(sortedPairs[rows][col]);
        }*/


    }

}
