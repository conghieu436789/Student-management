package menu.add;

import classSchool.*;
import input.Input;
import matchElement.Support;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static menu.add.DisplayAdd.addDisplay;

public class AddProcess {
    static Scanner scanner = new Scanner(System.in);
    public static boolean addProcess(ClassManagement classManagement) {
        System.out.println("Add people");
        addDisplay();
        Person person;
        int select = Input.takeSelect();
        switch (select) {
            case 0:
                return true;
            case 1:
                person = addTeacher(classManagement);
                System.out.println(person);
                System.out.println("Added");
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case 2:
                person = addStudent(classManagement);
                System.out.println(person);
                System.out.println("Added");
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            default:
                System.out.println("Re-enter");
                addProcess(classManagement);
        }
        return false;
    }
    public static Teacher addTeacher(ClassManagement classManagement) {
        Teacher teacher;
        String name = Input.takeName();
        LocalDate birthDay = Input.takeBDay();
        String sex = Input.takeSex();
        String address = Input.takeAddress();
        String ID = Input.takeID();
        while (Support.isIDExist(ID, classManagement.getStudentList(), classManagement.getTeacherList())) {
            System.out.println("ID was existed! Re-enter");
            ID = Input.takeID();
        }
        RoleTeacher role = Input.takeRole();
        String user = Input.takeTeacherUser();
        while (Support.isUserExist(user, classManagement.getStudentList(), classManagement.getTeacherList())) {
            System.out.println("User name was existed! Re-enter");
            user= Input.takeTeacherUser();
        }
        Account account = new Account(user);
        teacher = new Teacher(name, birthDay, address, account, sex, ID, role);
        classManagement.add(teacher);
        return teacher;
    }
    public static Student addStudent(ClassManagement classManagement) {
        Student student;
        String name = Input.takeName();
        LocalDate birthDay = Input.takeBDay();
        String sex = Input.takeSex();
        String address = Input.takeAddress();
        String ID = Input.takeID();
        while (Support.isIDExist(ID, classManagement.getStudentList(), classManagement.getTeacherList())) {
            System.out.println("ID was existed! Re-enter");
            ID = Input.takeID();
        }
        String user = Input.takeStudentUser();
        while (Support.isUserExist(user, classManagement.getStudentList(), classManagement.getTeacherList())) {
            System.out.println("User name was existed! Re-enter");
            user= Input.takeStudentUser();
        }
        Account account = new Account(user);
        double[] grade = Input.takeGrades();
        student = new Student(name, birthDay, address, account, sex, ID, grade);
        classManagement.add(student);
        return student;
    }
}
