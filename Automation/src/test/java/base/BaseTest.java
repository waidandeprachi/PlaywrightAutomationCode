package base;

import com.microsoft.playwright.Page;
import database.TestConnection;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pojo.AutomationRecords;
import utility.DriverManager;

import java.lang.reflect.Method;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected Page page;
    protected DriverManager driverManager = new DriverManager();
//    TestConnection testConnection = new TestConnection();
//    AutomationRecords automationRecords = new AutomationRecords();

    //@BeforeSuite
    @Parameters({"user","password"})
    public void loadUser(String user , String pass){
        int id = (int) ((Math.floor(Math.random() * ((100 - 1) + 1))) + 1);
//        automationRecords.setUserId(testConnection.getRecords(user,pass));
//        automationRecords.setRunID(id);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void LaunchBrowserWindow(String browser, ITestContext context) {
//        automationRecords.setBrowserName(browser);
//        automationRecords.setRunSartTime(LocalDateTime.now());
//        automationRecords.setSuiteName(context.getCurrentXmlTest().getSuite().getName());
        page = driverManager.initializeBrowser(browser).newPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(Method method) {
//        LocalDateTime ldt = automationRecords.getRunSartTime();
//        LocalTime lt = ldt.toLocalTime();
//        automationRecords.setTestcaseName(method.getName());
        //automationRecords.setRunDuration(Time.valueOf(lt.minusMinutes(LocalTime.now().getMinute())));
//        automationRecords.setRunStatus(getRunStatus());
//        testConnection.insertRecord(automationRecords);
        page.close();
        driverManager.quitSession();
    }

    public String getRunStatus() {
        ITestResult result = Reporter.getCurrentTestResult();
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASS";
            case ITestResult.FAILURE:
                return "FAIL";
            case ITestResult.SKIP:
                return "SKIP BLOCKED";
            default:
                return "RUN TERMINATED";
        }
    }
}
