package pojo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "automation_records")
public class AutomationRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "runid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int runID;

    @OneToMany(mappedBy = "userid", cascade = CascadeType.ALL)
    int userId;

    @Column(name = "testcasename")
    String testcaseName;

    @Column(name = "suitename")
    String suiteName;

    @Column(name = "browser")
    String browserName;

    @Column(name = "runstarttime")
    LocalDateTime runSartTime;

    @Column(name = "runduration")
    String runDuration;

    @Column(name = "runstatus")
    String runStatus;

    public int getId() {
        return id;
    }

    public AutomationRecords setId(int id) {
        this.id = id;
        return this;
    }

    public int getRunID() {
        return runID;
    }

    public AutomationRecords setRunID(int runID) {
        this.runID = runID;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public AutomationRecords setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getTestcaseName() {
        return testcaseName;
    }

    public AutomationRecords setTestcaseName(String testcaseName) {
        this.testcaseName = testcaseName;
        return this;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public AutomationRecords setSuiteName(String suiteName) {
        this.suiteName = suiteName;
        return this;
    }

    public String getBrowserName() {
        return browserName;
    }

    public AutomationRecords setBrowserName(String browserName) {
        this.browserName = browserName;
        return this;
    }

    public LocalDateTime getRunSartTime() {
        return runSartTime;
    }

    public AutomationRecords setRunSartTime(LocalDateTime runSartTime) {
        this.runSartTime = runSartTime;
        return this;
    }

    public String getRunDuration() {
        return runDuration;
    }

    public AutomationRecords setRunDuration(String runDuration) {
        this.runDuration = runDuration;
        return this;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public AutomationRecords setRunStatus(String runStatus) {
        this.runStatus = runStatus;
        return this;
    }

    @Override
    public String toString() {
        return "AutomationRecords{" +
                "id=" + id +
                ", runID=" + runID +
                ", userId=" + userId +
                ", testcaseName='" + testcaseName + '\'' +
                ", suiteName='" + suiteName + '\'' +
                ", browserName='" + browserName + '\'' +
                ", runSartTime=" + runSartTime +
                ", runDuration=" + runDuration +
                ", runStatus='" + runStatus + '\'' +
                '}';
    }
}
