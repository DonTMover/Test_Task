package dontmover.test_task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class sql {
    public static final String jdbcURL = "jdbc:postgresql://localhost:5432/testtask";
    public static final String username = "postgres";
    public static final String password = "toor";
    public static Connection GetConnection() throws SQLException{

        return DriverManager.getConnection(jdbcURL,username,password);
    }
}
