import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by joe on 12/23/16.
 */


public class DatabaseTests {

    //helper method
    public Connection startConnection()throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        SQLQueries.createDatabase(conn);
        return conn;
    }

    @Test
    public void loadDataIntoDatabase()throws SQLException{
        Connection connection = startConnection();
        HashMap<String, Integer> testData = new HashMap<>();
        testData.put("alice", 1);
        testData.put("bob",2);
        testData.put("charlie",3);

        SQLQueries.loadWordsIntoDB(connection, testData);
        HashMap<String, Integer> results = SQLQueries.selectAllWords(connection);
        Assert.assertEquals(results.size(), 3);
        connection.close();
    }
    
}
