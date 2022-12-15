package dontmover.test_task;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class sqlTest {
//    private static Connection connection;
//    private static ResultSet resultSet;

//    static {
//        try {
//            connection = sql.GetConnection();
//            resultSet = sql.AllQuery("cards");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    void getConnection() {

//        try {
//            assertEquals(DriverManager.getConnection("jdbc:postgresql://localhost:5432/testtask","postgres","toor"),sql.GetConnection());
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        //I can't(
    }

    @Test
    void allQuery() {
        //ResultSet i didn't know how to check
    }

    @Test
    void addToCards() {
        assertEquals(true,sql.AddToCards(9999,1,"Test","Test"));
    }

    @Test
    void addToItems() {
        assertEquals(true,sql.AddToItems(9999,"Test",9999));
    }

    @Test
    void whereQuery() {
        //ResultSet i didn't know how to check
    }
}