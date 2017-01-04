import org.h2.tools.Server;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joe on 12/15/16.
 */
public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        //deals with h2 db server
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        SQLQueries.createDatabase(conn);

        System.out.println("----- Program -----");

        ArrayList<String> rawText = ReadFile.readFile("ArtificialLight.rtf");
        ArrayList<String> cleanedText = CleanFile.cleanFile(rawText);
        HashMap<String, Integer> wordOccurrences = FindWordOccurrences.findWordOccurrences(cleanedText);
        System.out.println(CheckWordCount.checkWordCount(wordOccurrences, cleanedText));

        SQLQueries.loadWordsIntoDB(conn, wordOccurrences);

        HashMap<String, Integer> sortedWords = SQLQueries.sortWordsByFrequency(conn);

        int i = 0;
        while( i < 10) {
            for (String key : sortedWords.keySet()) {
                System.out.printf("Word: %s Frequency: %d\n", key, sortedWords.get(key));
                i++;
                if(i == 10){
                    break;
                }
            }
        }

    }
}

