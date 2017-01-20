import entities.Word;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by joe on 1/15/17.
 */
public class FrequencyTests {

    @Test
    public void projectedWordFrequencies(){
        ArrayList<String> test = new ArrayList<>();
        //logs?
        //power law?

        ArrayList<String> testDocument = new ArrayList();
        testDocument.add("a");
        testDocument.add("a");
        testDocument.add("a");
        testDocument.add("a");
        testDocument.add("a");
        testDocument.add("a");
        testDocument.add("a");
        testDocument.add("a");

        Assert.assertTrue(Frequencies.projectedWordFrequency(testDocument).size() == 8);
        ArrayList<Double> results = Frequencies.projectedWordFrequency(testDocument);

        for(double d : results){
            System.out.println(d);
        }

        Assert.assertTrue(results.get(0) == .5);
    }

    @Test
    public void actualWordFrequencies(){

    }

    @Test
    public void compareWordFrequencies(){
        ArrayList<String> testDocumentOne = new ArrayList();
        testDocumentOne.add("a");
        testDocumentOne.add("a");
        testDocumentOne.add("a");
        testDocumentOne.add("a");
        testDocumentOne.add("a");
        testDocumentOne.add("a");
        testDocumentOne.add("a");
        testDocumentOne.add("a");

        ArrayList<Word> testList = new ArrayList<>();
        Word test = new Word("a", 8);
        testList.add(test);


        ArrayList<Double> one = Frequencies.projectedWordFrequency(testDocumentOne);
        ArrayList<Double> two = Frequencies.actualWordFrequency(testList,testDocumentOne);

        System.out.println(Frequencies.compareFrequencies(one, two));

    }
}
