package classSchool;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teacher extends Person implements Serializable {
    private RoleTeacher role;
    public Teacher(String name, LocalDate birthDay, String address, Account account, String sex, String ID, RoleTeacher role) {
        super(name, birthDay, address, account, sex, ID);
        this.role = role;
    }

    public RoleTeacher getRole() {
        return role;
    }

    public void setRole(RoleTeacher role) {
        this.role = role;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = getBirthDay().format(dateTimeFormatter);
        return "Teacher{" +
                "ID = " + getID() + ", " +
                "Name = " + getName() + ", " +
                "Birthday = " + formattedDate + ", " +
                "Address = " + getAddress() + ", " +
                "Gender = " + getSex() + ", " +
                "Role = " + getRole() +
                "}";
    }
}
