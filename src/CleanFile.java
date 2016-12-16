import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class CleanFile {

    public static ArrayList<String> cleanFile(ArrayList<String> rawText) {

        ArrayList<String> cleanedText = new ArrayList<>();

        ArrayList<String> punctuationRemoved = RemovePunctuation.removePunctuation(rawText);
        ArrayList<String> numbersRemoved = RemoveNumbers.removeNumbers(punctuationRemoved);
        ArrayList<String> blankStringsRemoved = RemoveBlankStrings.removeBlankStrings(numbersRemoved);
        ArrayList<String> websitesRemoved = RemoveWebsites.removeWebsites(blankStringsRemoved);

        System.out.println(punctuationRemoved.size());
        System.out.println(numbersRemoved.size());
        System.out.println(blankStringsRemoved.size());
        System.out.println(websitesRemoved.size());

        if (!(websitesRemoved.size() <= punctuationRemoved.size())) {
            System.out.println("Something went wrong");
        } else {
            System.out.println("Okay so far");
        }

        cleanedText = websitesRemoved;
        return cleanedText;
    }
}
