package menu.main;

import classSchool.*;
import file.FileProcess;
import input.Input;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static menu.main.AfterLoginProcess.*;
import static menu.main.DisplayMain.loginDisplay;
import static menu.main.LoginProcess.*;

public class MainProcess {
    private static final String filepathStudentList = "StudentList.txt";
    private static final String filepathTeacherList = "TeacherList.txt";
    private ArrayList<Student> studentList;
    private ArrayList<Teacher> teacherList;
    private ClassManagement classManagement;
    private FormTeacher formTeacher;
    public MainProcess() {
        if (FileProcess.getFile(filepathStudentList)==null) {
            studentList = new ArrayList<>();
        } else {
            studentList = (ArrayList<Student>) FileProcess.getFile(filepathStudentList);
        }
        if (FileProcess.getFile(filepathTeacherList)==null) {
            teacherList = new ArrayList<>();
        } else {
            teacherList = (ArrayList<Teacher>) FileProcess.getFile(filepathTeacherList);
        }

        LocalDate birthDay = LocalDate.of(1,1,1);
        Account admin = new Account("TC-admin123", "admin123");
        RoleTeacher roleTeacher = RoleTeacher.MATH;
        boolean isFormTeaacherExist = false;
        for (Teacher teacher:teacherList) {
            if (teacher instanceof FormTeacher) {
                formTeacher = (FormTeacher) teacher;
                isFormTeaacherExist = true;
                break;
            }
        }
        if (!isFormTeaacherExist) {
            formTeacher = FormTeacher.getInstance("Admin",birthDay,"default",admin, "Male", "A1", roleTeacher);
        }

        if (teacherList.size()==0 && studentList.size()==0) {
            teacherList.add(formTeacher);
            Account admin1 = new Account("ST-student123");
            Account admin2 = new Account("TC-teacher678", "teacher678");
            double[] grade = {9,8,7};
            Student student = new Student("Nguyen Van Nam",birthDay,"default",admin1, "default", "A2", grade);
            studentList.add(student);
            Teacher teacher = new Teacher("Tran Le My",birthDay,"default",admin2, "default", "A3", roleTeacher);
            teacherList.add(teacher);
        }

        classManagement = new ClassManagement(studentList, teacherList, formTeacher);
    }
    public void startProcess() {
        Scanner scanner = new Scanner(System.in);
        loginDisplay();
        int select = Input.takeSelect();
        boolean isExit;
        switch (select) {
            case 1:
                if (loginAsFT(classManagement.getFormTeacher())!=null) {
                    do {
                        isExit = formTeacherProcess(classManagement, teacherList, studentList, filepathTeacherList, filepathStudentList);
                    } while (!isExit);
                } else {
                    System.out.println("Login failed. Lock in 10s");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("...");
                    System.out.println("...");
                    System.out.println("Unlock");
                    System.out.println("Press enter to continue");
                    scanner.nextLine();
                }
                break;
            case 2:
                Teacher teacher = loginAsTeacher(classManagement);
                if (teacher!=null) {
                    do {
                        isExit = teacherProcess(classManagement, teacher , teacherList, studentList, filepathTeacherList, filepathStudentList);
                    } while (!isExit);
                }else {
                    System.out.println("Login failed. Lock in 10s");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("...");
                    System.out.println("...");
                    System.out.println("Unlock");
                    System.out.println("Press enter to continue");
                    scanner.nextLine();
                }
                break;
            case 3:
                Student student = loginAsStudent(classManagement);
                if (student!=null) {
                    do {
                        isExit = studentProcess(classManagement, student , teacherList, studentList, filepathTeacherList, filepathStudentList);
                    } while (!isExit);
                } else {
                    System.out.println("Login failed. Lock in 10s");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("...");
                    System.out.println("...");
                    System.out.println("Unlock");
                    System.out.println("Press enter to continue");
                    scanner.nextLine();
                }
                break;
            case 4:
                System.out.println("You logged in as guest");
                do {
                    isExit = guestProcess(classManagement);
                } while (!isExit);
                break;
            default:
                System.out.println("Re-enter selection");
                startProcess();
        }
    }
}
