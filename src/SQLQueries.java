import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by joe on 12/23/16.
 */
public class SQLQueries {

    public static void createDatabase(Statement statement)throws SQLException{
        statement.execute("CREATE TABLE IF NOT EXISTS words(id IDENTITY , word VARCHAR, frequency INTEGER)");
    }

    public static void loadWordsIntoDB(Statement statement, HashMap<String, Integer> wordOccurrences)throws SQLException{
        for(String word : wordOccurrences.keySet()){
            int frequency = wordOccurrences.get(word);
            statement.execute("INSERT INTO words(word VARCHAR , frequency INTEGER ) VALUES (word, frequency)");
        }
    }

    public static void sortWordsByFrequency(Statement statement){

    }

    public static void getSortedWords(){

    }
}
