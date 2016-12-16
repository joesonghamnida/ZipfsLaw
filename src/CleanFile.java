import cleaners.RemoveBlankStrings;
import cleaners.RemoveNumbers;
import cleaners.RemovePunctuation;
import cleaners.RemoveWebsites;

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

        //debugCleaning(rawText, punctuationRemoved, numbersRemoved, blankStringsRemoved, websitesRemoved);

        cleanedText = websitesRemoved;
        return cleanedText;
    }

    public static void debugCleaning(ArrayList<String> rawText, ArrayList<String> punctuationRemoved, ArrayList<String> numbersRemoved, ArrayList<String> blankStringsRemoved, ArrayList<String> websitesRemoved) {

        System.out.println("Raw text size: " + rawText.size());
        System.out.println("Punctuation: " + punctuationRemoved.size());
        System.out.println("Numbers : " + numbersRemoved.size());
        System.out.println("Blank strings: " + blankStringsRemoved.size());
        System.out.println("Websites: " + websitesRemoved.size());

        if (!(punctuationRemoved.size() <= rawText.size())) {
            System.out.println("Something went wrong cleaning punctuation");
        } else if (!(numbersRemoved.size() <= punctuationRemoved.size())) {
            System.out.println("Something went wrong cleaning numbers");
        } else if (!(websitesRemoved.size() <= numbersRemoved.size())) {
            System.out.println("Something went wrong cleaning websites");
        } else {
            System.out.println("Okay so far");
        }
    }
}
