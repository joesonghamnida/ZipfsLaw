import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> rawText = ReadFile.readFile("ArtificialLight.rtf");
        ArrayList<String> punctuationRemoved = RemovePunctuation.removePunctuation(rawText);

        for (String s : punctuationRemoved) {
            System.out.println(s);
        }

    }
}

