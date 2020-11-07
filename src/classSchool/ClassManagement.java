package classSchool;

import comparator.ComparatorGrade;
import comparator.ComparatorName;
import matchElement.Support;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ClassManagement {
    private ArrayList<Student> studentList;
    private ArrayList<Teacher> teacherList;
    private FormTeacher formTeacher;

    public ClassManagement(ArrayList<Student> studentList, ArrayList<Teacher> teacherList, FormTeacher formTeacher) {
        this.studentList = studentList;
        this.teacherList = teacherList;
        this.formTeacher = formTeacher;
    }

    public FormTeacher getFormTeacher() {
        return formTeacher;
    }

    public void setFormTeacher(FormTeacher formTeacher) {
        this.formTeacher = formTeacher;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public Person add(Person person) {
        if (Support.isStudent(person)) {
            studentList.add((Student) person);
        } else if (Support.isTeacher(person)) {
            teacherList.add((Teacher) person);
        }
        return person;
    }

    public Person remove(Person person) {
        if (Support.isStudent(person)) {
            studentList.remove(person);
        } else if (Support.isTeacher(person)) {
            teacherList.remove(person);
        }
        return person;
    }

    public ArrayList<Person> searchByName(String name) {
        if (Support.isNameExist(name, studentList, teacherList)) {
            return Support.getPersonByName(name, studentList, teacherList);
        } else {
            return null;
        }
    }
    public Person searchByID(String ID) {
        if (Support.isIDExist(ID,studentList, teacherList)) {
            return Support.getPersonByID(ID, studentList, teacherList);
        } else {
            return null;
        }
    }
    public Person searchByUser(String user) {
        if (Support.isUserExist(user,studentList, teacherList)) {
            return Support.getPersonByUser(user, studentList, teacherList);
        } else {
            return null;
        }
    }

    public void editID(Person person, String newID) {
            person.setID(newID);
    }
    public void editName(Person person, String name) {
        person.setName(name);
    }
    public void editAddress(Person person, String address) {
        person.setAddress(address);
    }
    public void editBirthDay(Person person, LocalDate birthDay) {
        person.setBirthDay(birthDay);
    }
    public void editUser(Person person, String user) {
        person.getAccount().setUserName(user);
    }
    public void editPassword(Person person, String password) {
        person.getAccount().setPassword(password);
    }
    public void editSex(Person person, String sex) {
        person.setSex(sex);
    }
    public void editRoleTeacher(Teacher teacher, RoleTeacher role) {
        teacher.setRole(role);
    }
    public void editGrade(Student student, double[] grade) {
        student.setGrade(grade);
    }
    public void editMathGrade(Student student, double mathGrade) {
        student.getGrade()[0] = mathGrade;
    }
    public void editPhysicGrade(Student student, double physicGrade) {
        student.getGrade()[1] = physicGrade;
    }
    public void editChemistryGrade(Student student, double chemistryGrade) {
        student.getGrade()[2] = chemistryGrade;
    }

    public void sortByName() {
        ComparatorName comparatorName = new ComparatorName();
        Collections.sort(studentList, comparatorName);
        Collections.sort(teacherList, comparatorName);
    }
    public void sortByGrade() {
        ComparatorGrade comparatorGrade = new ComparatorGrade();
        Collections.sort(studentList, comparatorGrade);
    }

    public void printListTeacher() {
        if (teacherList.isEmpty()) {
            System.out.println("Teacher list is empty!");
        } else {
            System.out.println("Teacher List");
            for (Teacher teacher:teacherList) {
                System.out.println(teacher);
            }
        }
    }
    public void printListStudent() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
        } else {
            System.out.println("Student List");
            for (Student student:studentList) {
                System.out.println(student);
            }
        }
    }
    public void printListAll() {
        printListTeacher();
        printListStudent();
    }
}
