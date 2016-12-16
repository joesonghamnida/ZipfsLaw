import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class RemoveNumbers {

    public static ArrayList<String> removeNumbers(ArrayList<String> rawText){
        ArrayList<String> numbersRemoved = new ArrayList<>();

        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        for(String string : rawText){
            for(String number : numbers){
                if(string.contains(number)){
                    string = string + "REMOVE-ME";
                }
            }
            numbersRemoved.add(string);
        }

        for(int i = 0; i < numbersRemoved.size(); i ++){
            if(numbersRemoved.get(i).contains("REMOVE-ME")){
                numbersRemoved.remove(i);
            }
        }

        return numbersRemoved;
    }
}
