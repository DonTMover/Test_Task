package dontmover.test_task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlquery {
    public static ResultSet query(String tableName) throws SQLException {
        Connection connection = sql.GetConnection();
        String sqlquery = "SELECT * FROM " + tableName;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlquery);
        return result;
    }
//    public static ResultSet query(String id,String first_name,String last_name) throws SQLException{
//        return null;
//    }
}
