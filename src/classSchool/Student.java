package classSchool;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Student extends Person implements Serializable {
    private double[] grade;
    public Student(String name, LocalDate birthDay, String address, Account account, String sex, String ID, double[] grade) {
        super(name, birthDay, address, account, sex, ID);
        this.grade = grade;
    }

    public double[] getGrade() {
        return grade;
    }

    public void setGrade(double[] grade) {
        this.grade = grade;

    }

    public double averageGrade() {
        double sum = 0;
        for (double x:grade) {
            sum+=x;
        }
        return sum/grade.length;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = getBirthDay().format(dateTimeFormatter);
        return "Student{" +
                "ID = " + getID() + ", " +
                "Name = " + getName() + ", " +
                "Birthday = " + formattedDate + ", " +
                "Address = " + getAddress() + ", " +
                "Gender = " + getSex() + ", " +
                "grade= " + Arrays.toString(grade) +
                '}';
    }
}
