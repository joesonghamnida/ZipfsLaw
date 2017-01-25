import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe on 12/23/16.
 */
public class CleanerTests {

    @Test
    public void RemovePunctuationFromAString() {
        ArrayList<String> testData = new ArrayList<>();
        testData.add("a");
        testData.add("b!");
        testData.add("c@");
        testData.add("d#");
        testData.add("e$");
        testData.add("f%");
        testData.add("g%");
        testData.add("h^");
        testData.add("i.");
        testData.add("j|");
        testData.add("k!.");
        testData.add("$l");
        testData.add("%$m");
        testData.add("^^n%$");

        Assert.assertEquals(14, testData.size());
        ArrayList<String> holdingCell = new ArrayList<>();
        holdingCell = CleanFile.removePunctuation(testData);
        List<String> expectedResults = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");
        Assert.assertEquals(holdingCell, expectedResults);
    }

    @Test
    public void RemoveNumbersFromAString(){
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("a");
        testData.add("b1");
        testData.add("c2");
        testData.add("3d");
        testData.add("4e5");
        testData.add("ff6");
        testData.add("g7g");
        testData.add("8h9h0");

        ArrayList<String> holdingCell = new ArrayList<>();
        holdingCell = CleanFile.removeNumbers(testData);
        List<String> expectedResults = Arrays.asList("a", "b", "c", "d", "e", "ff", "gg", "hh");
        Assert.assertEquals(8, expectedResults.size());
        Assert.assertEquals(holdingCell, expectedResults);
    }

    @Test
    public void RemoveBlanksFromAString(){
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("a");
        testData.add("b ");
        testData.add(" c ");
        testData.add(" d");
        testData.add("e e");
        testData.add(" f f ");
        testData.add("g  g ");
        testData.add(" h   h  ");

        ArrayList<String> holdingCell = new ArrayList<>();
        holdingCell = CleanFile.removeBlankStrings(testData);
        List<String> expectedResults = Arrays.asList("a", "b", "c", "d", "ee", "ff", "gg", "hh");
        Assert.assertEquals(expectedResults, holdingCell);
    }

    @Test
    public void RemoveURLsFromString(){
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("a");
        testData.add("bwww");
        testData.add("httpc");
        testData.add("httpsd");

        ArrayList<String> holdingCell = new ArrayList<>();
        holdingCell = CleanFile.removeWebsites(testData);
        List<String> expectedResults = Arrays.asList("a");
        Assert.assertEquals(holdingCell, expectedResults);
    }
}
