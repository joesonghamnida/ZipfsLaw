import java.sql.*;
import java.util.HashMap;

/**
 * Created by joe on 12/23/16.
 */
public class SQLQueries{

    public static Connection connection()throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        return conn;
    }

    public static void createDatabase(Connection conn)throws SQLException{
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS words(id IDENTITY , word VARCHAR, frequency INTEGER)");
    }

    public static void loadWordsIntoDB(Connection conn, HashMap<String, Integer> wordOccurrences)throws SQLException{

        for(String word : wordOccurrences.keySet()){
            int frequency = wordOccurrences.get(word);
           PreparedStatement statement = conn.prepareStatement("INSERT INTO words VALUES(NULL, ?, ?)");
            statement.setString(1,word);
            statement.setInt(2,frequency);
            statement.execute();
        }
    }

    public static void sortWordsByFrequency(Connection conn)throws SQLException{
        Statement statement = conn.createStatement();

    }

    public static HashMap<String, Integer> selectAllWords(Connection conn)throws SQLException{

        HashMap<String, Integer> selectedWords = new HashMap<>();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM words ORDER BY frequency DESC");

        ResultSet results = statement.executeQuery();
        while(results.next()){
            String word = results.getString("word");
            int count = results.getInt("frequency");
            selectedWords.put(word,count);
        }

        return selectedWords;
    }

    public static HashMap<String, Integer> selectCertainNumberOfWords(Connection conn, int number, String direction)throws SQLException{
        Statement statement = conn.createStatement();
        HashMap<String, Integer> selectedWords = new HashMap<>();

        return selectedWords;
    }
}
