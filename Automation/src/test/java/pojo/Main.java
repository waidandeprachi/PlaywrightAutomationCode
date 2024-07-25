package pojo;


import database.TestConnection;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        TestConnection testConnection = new TestConnection();
        int id = testConnection.getRecords("user1", "abcd1");
        AutomationRecords automationRecords = new AutomationRecords();
        automationRecords.setBrowserName("Chrome");
        automationRecords.setUserId(id);
        automationRecords.setRunSartTime(LocalDateTime.now());
        automationRecords.setSuiteName("Suite1");
        automationRecords.setTestcaseName("TestCase1");
        System.out.println("time");
        Duration d =Duration.between(LocalDateTime.now().minusMinutes(5).minusSeconds(34),LocalDateTime.now());
        String s = d.toMinutes()+"mins "+d.toSeconds()+"secs";
        automationRecords.setRunDuration(s);
        automationRecords.setRunStatus("Pass");
        testConnection.insertRecord(automationRecords);
    }
}
