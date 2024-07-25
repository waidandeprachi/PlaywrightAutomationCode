package data;

public class UserDetails {
    String first_name;
    String last_name;
    String email;
    String groups;
    String picture_url;
    String password;
    String language;
    String job_title;

    public UserDetails(String fname, String lname, String email, String groups, String pic_url , String password, String language, String job_title){
        this.first_name = fname;
        this.last_name = lname;
        this.email = email;
        this.groups = groups;
        this.picture_url = pic_url;
        this.password = password;
        this.language = language;
        this.job_title = job_title;
    } {
    }

    public UserDetails setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public UserDetails setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFull_name(){
        return this.first_name.concat(" ").concat(this.last_name);
    }

    public String getEmail() {
        return email;
    }

    public UserDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGroups() {
        return groups;
    }

    public UserDetails setGroups(String groups) {
        this.groups = groups;
        return this;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public UserDetails setPicture_url(String picture_url) {
        this.picture_url = picture_url;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDetails setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public UserDetails setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getJob_title() {
        return job_title;
    }

    public UserDetails setJob_title(String job_title) {
        this.job_title = job_title;
        return this;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", groups='" + groups + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", password='" + password + '\'' +
                ", language='" + language + '\'' +
                ", job_title='" + job_title + '\'' +
                '}';
    }
}
