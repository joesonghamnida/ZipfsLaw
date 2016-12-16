package cleaners;

import java.util.ArrayList;

/**
 * Created by joe on 12/15/16.
 */
public class RemoveBlankStrings {

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
}
