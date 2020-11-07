package classSchool;

import java.io.Serializable;

public class Account implements Serializable {
    private String userName;
    private String password;

    public Account(String userName) {
        this.userName = userName;
        this.password = "12345678";
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
