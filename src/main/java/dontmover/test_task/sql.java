package dontmover.test_task;
import java.sql.*;
import java.util.logging.Logger;

public class sql {

    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/testtask";
    private static final String username = "postgres";
    private static final String password = "toor";

    public static Connection GetConnection() throws SQLException{

            return DriverManager.getConnection(jdbcURL,username,password);

    }
    public static ResultSet AllQuery(String tableName) throws SQLException {
        Connection connection = sql.GetConnection();
        String sqlquery = "SELECT * FROM " + tableName;
        Statement statement = connection.createStatement();
        //PreparedStatement statement = connection.prepareStatement(sqlquery);
        //statement.setString(1,tableName);
        ResultSet result = statement.executeQuery(sqlquery);
        connection.close();
        return result;
    }
    public static String sqlcards = "INSERT INTO cards (id,discound,first_name,last_name) VALUES (?,?,?,?)";

    public static String sqlitems = "INSERT INTO items (id,name,price) VALUES (?,?,?)";



    //the boolean type was used to understand the success of the operation
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
    public static boolean AddToItems(Integer id,String name,Integer price){
        if (id<0){
            return false;
        }
        try{
            Connection connection = sql.GetConnection();
            PreparedStatement statement = connection.prepareStatement(sqlitems);
            statement.setInt(1,id);
            statement.setString(2,name);
            if (!(price<0)){
                statement.setInt(3,price);
            }else {
                statement.setInt(3,0);
            }


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
    public static String sqlwherequery = "SELECT * FROM ? WHERE ? = ?";
    public static ResultSet whereQuery(String WhatWeKnow,String table,String whatWeUseToSearchFor) throws SQLException{
        try(Connection connection = sql.GetConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlwherequery);
            statement.setString(1, table);
            statement.setString(2, WhatWeKnow);
            statement.setString(3, whatWeUseToSearchFor);
            return statement.executeQuery(sqlwherequery);
        }

    }
}
