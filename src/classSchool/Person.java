package classSchool;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {
    private String name;
    private LocalDate birthDay;
    private String address;
    private Account account;
    private String sex;
    private String ID;

    public Person(String name, LocalDate birthDay, String address, Account account, String sex, String ID) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.account = account;
        this.sex = sex;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
