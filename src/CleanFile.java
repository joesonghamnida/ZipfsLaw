
import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class CleanFile {

    public static ArrayList<String> cleanFile(ArrayList<String> rawText) {

        ArrayList<String> cleanedText = new ArrayList<>();

        ArrayList<String> punctuationRemoved = removePunctuation(rawText);
        ArrayList<String> numbersRemoved = removeNumbers(punctuationRemoved);
        ArrayList<String> blankStringsRemoved = removeBlankStrings(numbersRemoved);
        ArrayList<String> websitesRemoved = removeWebsites(blankStringsRemoved);

        //debugCleaning(rawText, punctuationRemoved, numbersRemoved, blankStringsRemoved, websitesRemoved);

        cleanedText = websitesRemoved;
        return cleanedText;
    }

    public static ArrayList<String> removeMarker(ArrayList<String> markedText){
        ArrayList<String> holdingCell = new ArrayList<>();

        for(int i = 0; i < markedText.size(); i ++){
            if(!markedText.get(i).contains("REMOVE-ME")){
                holdingCell.add(markedText.get(i));
            }
        }

        markedText = holdingCell;

        return markedText;
    }

    public static ArrayList<String> removeBlankStrings(ArrayList<String> rawText) {
        ArrayList<String> blanksRemoved = new ArrayList<>();

        ArrayList<String> holdingCell = new ArrayList<>();

        for (String string : rawText) {
            if (!(string.equals(""))) {
                holdingCell.add(string);
            }
        }

        blanksRemoved = holdingCell;

        return blanksRemoved;
    }

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
        numbersRemoved = removeMarker(numbersRemoved);
        return numbersRemoved;
    }



    public static ArrayList<String> removePunctuation(ArrayList<String> rawText) {
        ArrayList<String> cleanedText = new ArrayList<>();
        String[] punctuationMarks = {".", ",", ":", ";", "?","<", ">", "\\", "'","{", "}", "*","-","_","(",")","[","]","|", "!", "/", "@", "#", "$", "%", "^", "&", "\"", "+", "~", "`", "="};

        for (String word : rawText) {

            String cleanedWord = "";

            for (String punctuation : punctuationMarks) {
                if (word.contains(punctuation)) {
                    cleanedWord = word.replace(punctuation, "");
                    cleanedWord.trim();
                    word = cleanedWord;
                } else {
                    cleanedWord = word;
                }
            }
            cleanedText.add(cleanedWord.toLowerCase());
        }

        return cleanedText;
    }

    public static ArrayList<String> removeWebsites(ArrayList<String> rawText){
        ArrayList<String> websitesRemoved = new ArrayList<>();

        String[] protocols = {"http", "https", "www"};

        for(String word : rawText){
            for(String protocol : protocols){
                if((word.contains(protocol))){
                    word = word + "REMOVE-ME";
                }
            }
            websitesRemoved.add(word);
        }

        websitesRemoved = removeMarker(websitesRemoved);

        return websitesRemoved;
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
