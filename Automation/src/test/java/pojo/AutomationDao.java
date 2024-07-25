package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

public class AutomationDao {
    public static void insertRecord(AutomationRecords automationRecords, Connection con) throws SQLException {
        if(con != null){
            String query = "Insert into automation_records (runid, userid, testcasename, suitename, browser, runstarttime, runduration, runstatus)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,automationRecords.getRunID());
            preparedStatement.setInt(2,automationRecords.getUserId());
            preparedStatement.setString(3,automationRecords.getTestcaseName());
            preparedStatement.setString(4,automationRecords.getSuiteName());
            preparedStatement.setString(5,automationRecords.getBrowserName());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(automationRecords.getRunSartTime()));
            preparedStatement.setString(7, automationRecords.getRunDuration());
            preparedStatement.setString(8,automationRecords.getRunStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: "+rowsAffected);
        }
    }

    public static int getRecords( Connection con, String username, String password) throws SQLException {
        int id = 0;
        if(con != null){
            String query = "Select userid from user_details where firstname = '"+ username + "' and pass = '"+password+"'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
               id = resultSet.getInt("userid");
            }
            return id;
        }
        return id;
    }
}
