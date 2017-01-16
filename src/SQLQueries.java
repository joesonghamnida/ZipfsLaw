import entities.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joe on 12/23/16.
 */
public class SQLQueries {

    public static Connection connection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        return conn;
    }

    public static void dropDatabase(Connection conn)throws SQLException{
        Statement statement = conn.createStatement();
        statement.execute("DROP TABLE IF EXISTS words");
    }

    public static void createDatabase(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS words(id IDENTITY , word VARCHAR, frequency INTEGER)");
    }

    public static void loadWordsIntoDB(Connection conn, HashMap<String, Integer> wordOccurrences) throws SQLException {

        for (String word : wordOccurrences.keySet()) {
            int frequency = wordOccurrences.get(word);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO words VALUES(NULL, ?, ?)");
            statement.setString(1, word);
            statement.setInt(2, frequency);
            statement.execute();
        }
    }

    public static Integer checkWordCount(Connection conn) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT (word) FROM words");
        ResultSet result = statement.executeQuery();
        System.out.println(result);
        int count = 0;
        while (result.next()) {
            count = result.getInt(1);
        }
        return count;
    }

    public static ArrayList<Word> sortWordsByFrequency(Connection conn) throws SQLException {

        //HashMap<String, Integer> selectedWords = new HashMap<>();
        ArrayList<Word> selectedWords = new ArrayList<>();

        PreparedStatement statement = conn.prepareStatement("SELECT word, frequency FROM words ORDER BY frequency DESC ");

        ResultSet results = statement.executeQuery();
        while (results.next()) {
            String word = results.getString("word");
            int count = results.getInt("frequency");
            Word w = new Word(word,count);
            selectedWords.add(w);
        }

        return selectedWords;
    }

    public static HashMap<String, Integer> selectAllWords(Connection conn) throws SQLException {

        HashMap<String, Integer> selectedWords = new HashMap<>();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM words ORDER BY frequency DESC");

        ResultSet results = statement.executeQuery();
        while (results.next()) {
            String word = results.getString("word");
            int count = results.getInt("frequency");
            selectedWords.put(word, count);
        }

        return selectedWords;
    }

    public static HashMap<String, Integer> selectCertainNumberOfWords(Connection conn, int number) throws SQLException {
        HashMap<String, Integer> selectedWords = new HashMap<>();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM words WHERE ROWNUM <= ?");
        statement.setInt(1, number);
        ResultSet results = statement.executeQuery();

        while (results.next()) {
            String word = results.getString("word");
            int count = results.getInt("frequency");
            selectedWords.put(word, count);
        }

        return selectedWords;
    }
}
