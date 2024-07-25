package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class createConnection {
    public static Connection connect(){
        try {
            Class.forName("org.postgresql.Driver");
            String jdbcURL = DatabaseConfig.getDbUrl();
            String user = DatabaseConfig.getDbUsername();
            String password = DatabaseConfig.getDbPassword();
            return DriverManager.getConnection(jdbcURL,user,password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
