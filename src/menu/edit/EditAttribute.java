package menu.edit;

import classSchool.*;
import input.Input;
import matchElement.Support;

import java.time.LocalDate;
import java.util.ArrayList;

public class EditAttribute {
    public static void editID(ClassManagement classManagement, Person person) {
        System.out.println("New ID");
        String newID = Input.takeID();
        while (Support.isIDExist(newID, classManagement.getStudentList(), classManagement.getTeacherList())) {
            System.out.println("ID was existed! Re-enter");
            newID = Input.takeID();
        }
        classManagement.editID(person, newID);
    }
    public static void editName(ClassManagement classManagement, Person person) {
        System.out.println("New name");
        String newName = Input.takeName();
        classManagement.editName(person, newName);
    }
    public static void editAddress(ClassManagement classManagement, Person person) {
        System.out.println("New address");
        String newAddress = Input.takeAddress();
        classManagement.editAddress(person, newAddress);
    }
    public static void editBirthDay(ClassManagement classManagement, Person person) {
        System.out.println("New birthday");
        LocalDate newBirthDay = Input.takeBDay();
        classManagement.editBirthDay(person, newBirthDay);
    }
    public static void editGender(ClassManagement classManagement, Person person) {
        System.out.println("New gender");
        String newGender = Input.takeSex();
        classManagement.editSex(person, newGender);
    }
    public static void editRole(ClassManagement classManagement, Teacher teacher) {
        System.out.println("New role");
        RoleTeacher newRole = Input.takeRole();
        classManagement.editRoleTeacher(teacher, newRole);
    }
    public static void editUserName(ClassManagement classManagement, Person person) {
        System.out.println("New user name");
        String newUserName;
        if (person instanceof Student) {
            newUserName= Input.takeStudentUser();
            while (Support.isUserExist(newUserName, classManagement.getStudentList(), classManagement.getTeacherList())) {
                System.out.println("This user name was existed");
                newUserName= Input.takeStudentUser();
            }
        } else{
            newUserName= Input.takeTeacherUser();
            while (Support.isUserExist(newUserName, classManagement.getStudentList(), classManagement.getTeacherList())) {
                System.out.println("This user name was existed");
                newUserName= Input.takeTeacherUser();
            }
        }
        classManagement.editUser(person, newUserName);
    }
    public static void editPassword(ClassManagement classManagement, Person person) {
        System.out.println("New password");
        String newPassword;
        newPassword= Input.takePassword();
        classManagement.editPassword(person, newPassword);
    }

    public static void editGrades(ClassManagement classManagement, Student student) {
        System.out.println("New grade");
        double[] newGrade = Input.takeGrades();
        classManagement.editGrade(student, newGrade);
    }
    public static void editMathGrade(ClassManagement classManagement, Student student) {
        System.out.println("New grade");
        double newMathGrade = Input.takeGrade();
        classManagement.editMathGrade(student, newMathGrade);
    }
    public static void editPhysicGrade(ClassManagement classManagement, Student student) {
        System.out.println("New grade");
        double newPhysicGrade = Input.takeGrade();
        classManagement.editPhysicGrade(student, newPhysicGrade);
    }
    public static void editChemistryGrade(ClassManagement classManagement, Student student) {
        System.out.println("New grade");
        double newChemistryGrade = Input.takeGrade();
        classManagement.editChemistryGrade(student, newChemistryGrade);
    }


}
