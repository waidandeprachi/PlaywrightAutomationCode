package database;

import pojo.AutomationDao;
import pojo.AutomationRecords;

import java.sql.Connection;
import java.sql.SQLException;


public class TestConnection {

    static Connection con;

    static {
            con = createConnection.connect();
            if(con!= null)
                System.out.println("Connected to database successfully");

    }

    public int getRecords(String username, String password) {
        try {
            return  AutomationDao.getRecords(con, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRecord(AutomationRecords automationRecords){
        try {
            AutomationDao.insertRecord(automationRecords, con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
