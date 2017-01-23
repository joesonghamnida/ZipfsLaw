import entities.Word;
import org.h2.tools.Server;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.exit;

/**
 * Created by joe on 12/15/16.
 */
public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        //deals with h2 db server
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        program(conn, "ArtificialLight.rtf");
        program(conn, "IBM.rtf");
        program(conn, "NitroExplosives.rtf");
        program(conn, "AtlanticTelegraph.rtf");
        exit(0);
    }

    public static void program(Connection conn, String document)throws SQLException, FileNotFoundException{
        SQLQueries.dropDatabase(conn);
        SQLQueries.createDatabase(conn);

        System.out.println("File: "+document);

        ArrayList<String> rawText = ReadFile.readFile(document);
        ArrayList<String> cleanedText = CleanFile.cleanFile(rawText);
        HashMap<String, Integer> wordOccurrences = FindWordOccurrences.findWordOccurrences(cleanedText);
        System.out.println(CheckWordCount.checkWordCount(wordOccurrences, cleanedText));

        SQLQueries.loadWordsIntoDB(conn, wordOccurrences);

        ArrayList<Word> sortedWords = SQLQueries.sortWordsByFrequency(conn);

        ArrayList<Double> projectedFrequencies = Frequencies.projectedWordFrequency(cleanedText);
        ArrayList<Double> actualFrequencies = Frequencies.actualWordFrequency(sortedWords, cleanedText);
        ArrayList<Double> differences = Frequencies.compareFrequencies(actualFrequencies, projectedFrequencies);

        double average = 0.0;

        for(Double d : differences){
            average += d;
        }

        System.out.println("The average difference between the projected word frequency and the actual frequency is "+average/wordOccurrences.size()+"\n");
    }
}

