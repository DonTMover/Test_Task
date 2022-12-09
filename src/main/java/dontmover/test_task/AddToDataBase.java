package dontmover.test_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToDataBase {
    public static final String jdbcURL = "jdbc:postgresql://localhost:5432/testtask";
    public static final String username = "postgres";
    public static final String password = "toor";

    public static String sqlcards = "INSERT INTO cards (CardID,discound,first_name,last_name) VALUES (?,?,?,?)";

    public static String sqlitems = "INSERT INTO items (id,first_name,last_name) VALUES (?,?,?)";
    public static boolean AddToCards(Integer CardID,Integer discound,String first_name,String last_name) throws SQLException {
        if(CardID < 0 ){
            return false;
        }
        if (discound > 100){
            return false;
        }
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            PreparedStatement statement = connection.prepareStatement(jdbcURL);
            statement.setInt(1,CardID);
            statement.setInt(2,discound);
            statement.setString(3,first_name);
            statement.setString(4,last_name);
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
                return false;
            }
        }
    }
    public static boolean AddtoItems(Integer id,String first_name,String last_name){
        if (id<0){
            return false;
        }
        try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            PreparedStatement statement = connection.prepareStatement(jdbcURL);
            statement.setInt(1,id);
            statement.setString(2,first_name);
            statement.setString(3,last_name);
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
