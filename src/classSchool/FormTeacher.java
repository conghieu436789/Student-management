package classSchool;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormTeacher extends Teacher implements Serializable {
    private static FormTeacher instance;

    private FormTeacher(String name, LocalDate birthDay, String address, Account account, String sex, String ID, RoleTeacher role) {
        super(name, birthDay, address, account, sex, ID, role);
    }

    public static FormTeacher getInstance(String name, LocalDate birthDay, String address, Account account, String sex, String ID, RoleTeacher role) {
        if (instance == null) {
            instance = new FormTeacher(name, birthDay, address, account, sex, ID, role);

        }
        return instance;
    }
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = getBirthDay().format(dateTimeFormatter);
        return "Form Teacher{" +
                "ID = " + getID() + ", " +
                "Name = " + getName() + ", " +
                "Birthday = " + formattedDate + ", " +
                "Address = " + getAddress() + ", " +
                "Gender = " + getSex() + ", " +
                "Role = " + getRole() +
                "}";
    }
}
