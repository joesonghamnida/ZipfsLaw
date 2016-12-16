import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> rawText = ReadFile.readFile("ArtificialLight.rtf");
        ArrayList<String> punctuationRemoved = RemovePunctuation.removePunctuation(rawText);
        ArrayList<String> numbersRemoved = RemoveNumbers.removeNumbers(punctuationRemoved);
        ArrayList<String> blankStringsRemoved = RemoveBlankStrings.removeBlankStrings(numbersRemoved);

        System.out.println(punctuationRemoved.size());
        System.out.println(numbersRemoved.size());
        System.out.println(blankStringsRemoved.size());

        if (!(blankStringsRemoved.size() <= punctuationRemoved.size())) {
            System.out.println("Something went wrong");
        } else {
            System.out.println("Okay so far");
        }

        for(String s : blankStringsRemoved){
            System.out.println(s);
        }

    }
}

