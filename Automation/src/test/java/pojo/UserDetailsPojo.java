package pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_detials")
public class UserDetailsPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @Column(name = "firstname")
    String firstName;

    @Column(name = "lastname")
    String lastName;

    @Column(name = "emailid")
    String emailId;

    @Column(name = "pass")
    String password;

    @Column(name = "jobtitle")
    String jobTitle;

    public int getUserId() {
        return userId;
    }

    public UserDetailsPojo setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDetailsPojo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDetailsPojo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public UserDetailsPojo setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDetailsPojo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public UserDetailsPojo setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    @Override
    public String toString() {
        return "UserDetailsPojo{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
