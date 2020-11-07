package menu.main;

import classSchool.*;
import input.Input;
import matchElement.Support;

import java.util.ArrayList;

public class LoginProcess {
    public static FormTeacher loginAsFT(FormTeacher formTeacher) {
        return loginFT(formTeacher);
    }
    public static Teacher loginAsTeacher(ClassManagement classManagement) {
        return loginTeacher(classManagement);
    }
    public static Student loginAsStudent(ClassManagement classManagement) {
        return loginStudent(classManagement);
    }
    public static FormTeacher loginFT(FormTeacher formTeacher) {
        int count = 3;
        while (count>0) {
            String userName = Input.takeTeacherUser();
            String password = Input.takePassword();
            if (formTeacher.getAccount().getUserName().equals(userName)
                    && formTeacher.getAccount().getPassword().equals(password)) {
                System.out.println("Login successfully as " + formTeacher.getName());
                return formTeacher;
            } else {
                System.out.println("Wrong user name or password");
                count--;
                System.out.println("Your account will be locked after " + count + " time");
            }
        }
        return null;
    }
    public static Teacher loginTeacher(ClassManagement classManagement) {
        int count = 3;
        Teacher teacher = null;
        boolean isSuccess = false;
        while (count>0 && !isSuccess) {
            String userName = Input.takeTeacherUser();
            String password = Input.takePassword();
            for (Teacher teacherTemp:classManagement.getTeacherList()) {
                if (teacherTemp.getAccount().getUserName().equals(userName)
                        && teacherTemp.getAccount().getPassword().equals(password)) {
                    teacher = teacherTemp;
                    System.out.println("Login successfully as " + teacher.getName());
                    isSuccess = true;
                    break;
                }
            }
            if (!isSuccess) {
                System.out.println("Wrong user name or password");
                count--;
                System.out.println("Your account will be locked after " + count + " time");
            }
        }
        return teacher;
    }
    public static Student loginStudent(ClassManagement classManagement) {
        int count = 3;
        Student student = null;
        boolean isSucces = false;
        while (count>0 && !isSucces) {
            String userName = Input.takeStudentUser();
            String password = Input.takePassword();
            for (Student studentTemp:classManagement.getStudentList()) {
                if (studentTemp.getAccount().getUserName().equals(userName)
                        && studentTemp.getAccount().getPassword().equals(password)) {
                    student= studentTemp;
                    System.out.println("Login successfully as " + student.getName());
                    isSucces = true;
                    break;
                }
            }
            if (!isSucces) {
                System.out.println("Wrong user name or password");
                count--;
                System.out.println("Your account will be locked after " + count + " time");
            }
        }
        return student;
    }

    public static void lockUser() {
        long startTime = System.currentTimeMillis();
        long endTime;
        long difference = 0;
        while(difference>=10000000) {
            endTime = System.currentTimeMillis();
            difference = endTime-startTime;
        }
    }
}
