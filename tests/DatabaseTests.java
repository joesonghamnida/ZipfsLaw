import entities.Word;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joe on 12/23/16.
 */


public class DatabaseTests {

    //helper method
    public Connection startConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        SQLQueries.createDatabase(conn);
        return conn;
    }

    @Test
    public void loadDataIntoDatabase() throws SQLException {
        Connection connection = startConnection();
        HashMap<String, Integer> testData = new HashMap<>();
        testData.put("alice", 1);
        testData.put("bob", 2);
        testData.put("charlie", 3);

        SQLQueries.loadWordsIntoDB(connection, testData);
        HashMap<String, Integer> results = SQLQueries.selectAllWords(connection);
        Assert.assertEquals(results.size(), 3);
        connection.close();
    }

    @Test
    public void checkWordCount()throws SQLException{
        Connection connection = startConnection();
        HashMap<String, Integer> testData = new HashMap<>();
        testData.put("alice", 1);
        testData.put("bob", 2);
        testData.put("charlie", 3);

        SQLQueries.loadWordsIntoDB(connection, testData);
        Assert.assertTrue(SQLQueries.checkWordCount(connection) == 3);
    }

    @Test
    public void selectACertainNumberOfWords()throws SQLException{
        Connection connection = startConnection();
        HashMap<String, Integer> testData = new HashMap<>();
        testData.put("alice", 1);
        testData.put("bob", 2);
        testData.put("charlie", 3);

        SQLQueries.loadWordsIntoDB(connection, testData);
        HashMap<String, Integer> results = SQLQueries.selectCertainNumberOfWords(connection, 2);
        Assert.assertEquals(results.size(), 2);
        connection.close();
    }


    @Test
    public void sortWordsByFrequency()throws SQLException{
        Connection connection = startConnection();
        HashMap<String, Integer> testData = new HashMap<>();
        testData.put("aa", 3);
        testData.put("bbbbb", 2);
        testData.put("c", 1);

        SQLQueries.loadWordsIntoDB(connection, testData);

        ArrayList<Word> results = SQLQueries.sortWordsByFrequency(connection);
        int i = 3;
        System.out.println("test");

        for (Word word : results){
            Assert.assertTrue(word.getFrequency() == (i));
            i--;
        }
    }

}
