package dontmover.test_task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToDataBase {

    public static String sqlcards = "INSERT INTO cards (id,discound,first_name,last_name) VALUES (?,?,?,?)";

    public static String sqlitems = "INSERT INTO items (id,first_name,last_name) VALUES (?,?,?)";
    public static boolean AddToCards(Integer CardID,Integer discound,String first_name,String last_name) {
        if(CardID < 0 ){
            return false;
        }
        if (discound > 100){
            return false;
        }
        try {
            Connection connection = sql.GetConnection();
            PreparedStatement statement = connection.prepareStatement(sqlcards);
            statement.setInt(1,CardID);
            statement.setInt(2,discound);
            statement.setString(3,first_name);
            statement.setString(4,last_name);
            int rows = statement.executeUpdate();
            if(rows>0){
                System.out.println("A new Card user has been inserted");
            }
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static boolean AddtoItems(Integer id,String first_name,String last_name){
        if (id<0){
            return false;
        }
        try{
            Connection connection = sql.GetConnection();
            PreparedStatement statement = connection.prepareStatement(sqlitems);
            statement.setInt(1,id);
            statement.setString(2,first_name);
            statement.setString(3,last_name);
            int rows = statement.executeUpdate();
            if(rows>0){
                System.out.println("A new item has been inserted");
            }
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
