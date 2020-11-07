package input;

import classSchool.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static String nameRegex() {
        return "([A-Z][a-z]+\\s?)+";
    }
    public static String addressRegex() {
        return "[A-Za-z_0-9]+";
    }
    public static String sexRegex() {
        return "Male|Female";
    }
    public static String IDRegex() {
        return "^A[0-9]{1,3}$";
    }
    public static String studentUserRegex() {
        return "(ST)-[A-Za-z0-9]{6,20}$";
    }
    public static String teacherUserRegex() {
        return "(TC)-[A-Za-z0-9]{6,20}$";
    }
    public static String roleRegex() {
        return "([mM][aA][tT][hH])|([pP][hH][yY][sS][iI][cC])|([cC][hH][eE][mM][iI][sS][tT][rR][yY])";
    }
    public static String passwordRegex() {
        return "[A-Za-z0-9]{8,15}$";
    }
    public static boolean isMatch(String regex, String catcher) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(catcher);
        return matcher.matches();
    }

    public static String enterName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name (at least 2 characters and capitalize first character)");
        String name = scanner.nextLine();
        return name;
    }
    public static String takeName() {
        boolean checkType;
        String name = null;
        do {
            try {
                name = enterName();
                checkType = isMatch(nameRegex(), name);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                System.err.println("Type is wrong");
                checkType=false;
            }
        } while (!checkType);
        return name;
    }

    public static LocalDate enterBirthDay()throws Exception{
        Scanner scanner = new Scanner(System.in);
        LocalDate birthDay;
        System.out.println("Enter birthday");
        System.out.println("Enter date");
        int date = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter month");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter year");
        int year = Integer.parseInt(scanner.nextLine());
        birthDay =LocalDate.of(year, month, date);
        return birthDay;
    }
    public static LocalDate takeBDay() {
        boolean checkType = true;
        LocalDate day = null;
        do {
            try {
                day = enterBirthDay();
            } catch (Exception e) {
                System.err.println("Wrong type");
                checkType=false;
            }
        } while (!checkType);
        return day;
    }

    public static String enterAddress() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return address;
    }
    public static String takeAddress() {
        String address = null;
        boolean checkType;
        do {
            try {
                address = enterAddress();
                checkType = isMatch(addressRegex(), address);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return address;
    }

    public static String enterSex() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sex (Male/Female)");
        String sex = scanner.nextLine();
        return sex;
    }
    public static String takeSex() {
        String sex = null;
        boolean checkType;
        do {
            try {
                sex = enterSex();
                checkType = isMatch(sexRegex(), sex);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return sex;
    }

    public static String enterSelect() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your selection");
        String selection = scanner.nextLine();
        return selection;
    }
    public static int takeSelect() {
        int select = 0;
        boolean checkType;
        do {
            checkType = true;
            try {
                select = Integer.parseInt(enterSelect());
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return select;
    }

    public static String enterUser() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name");
        String user = scanner.nextLine();
        return user;
    }
    public static String takeStudentUser() {
        String userName = null;
        boolean checkType;
        do {
            try {
                System.out.println("User name (start by 'ST-' and at least 8 characters)");
                userName = enterUser();
                checkType = isMatch(studentUserRegex(), userName);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return userName;
    }
    public static String takeTeacherUser() {
        String userName = null;
        boolean checkType;
        do {
            try {
                System.out.println("User name (start by 'TC-' and at least 8 characters)");
                userName = enterUser();
                checkType = isMatch(teacherUserRegex(), userName);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return userName;
    }

    public static String enterPassword() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password (at least 8 characters)");
        String password = scanner.nextLine();
        return password;
    }
    public static String takePassword() {
        String password = null;
        boolean checkType;
        do {
            try {
                password = enterPassword();
                checkType = isMatch(passwordRegex(), password);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return password;
    }
//    public static Account takeTeacherAccount() {
//        String user = takeTeacherUser();
//        String password = takePassword();
//        return new Account(user,password);
//    }
//    public static Account takeStudentAccount() {
//        String user = takeStudentUser();
//        String password = takePassword();
//        return new Account(user,password);
//    }

    public static String enterRole() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter role (math|physic|chemistry)");
        String role = scanner.nextLine();
        return role;
    }
    public static RoleTeacher takeRole() {
        String role = null;
        RoleTeacher role1 = null;
        boolean checkType;
        do {
            try {
                role = enterRole();
                checkType = isMatch(roleRegex(), role);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        if (role.equals("math") |role.equals("Math") |role.equals("MATH")) {
            role1 = RoleTeacher.MATH;
        } else if (role.equals("physic")|role.equals("PHYSIC")|role.equals("Physic")) {
            role1 = RoleTeacher.PHYSIC;
        } else if (role.equals("chemistry")|role.equals("CHEMISTRY")|role.equals("Chemistry")){
            role1 = RoleTeacher.CHEMISTRY;
        }
        return role1;
    }

    public static String enterID() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID (start with character 'A' and follow by number)");
        String ID = scanner.nextLine();
        return ID;
    }
    public static String takeID() {
        String ID = null;
        boolean checkType;
        do {
            try {
                ID = enterID();
                checkType = isMatch(IDRegex(), ID);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return ID;
    }

    public static double enterGrade()throws Exception {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        return grade;
    }
    public static double takeGrade(){
        double grade = 0d;
        boolean checkType;
        do {
            System.out.println("Enter grade");
            checkType=true;
            try {
                grade = enterGrade();
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return grade;
    }
    public static double[] takeGrades() {
        System.out.println("Enter math grade");
        double math = takeGrade();
        System.out.println("Enter physic grade");
        double physic = takeGrade();
        System.out.println("Enter chemistry grade");
        double chemistry = takeGrade();
        double[] grade = {math,physic,chemistry};
        return grade;
    }

}
