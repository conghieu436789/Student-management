package menu.main;

import classSchool.*;
import input.Input;
import menu.add.AddProcess;
import menu.edit.EditProcess;
import menu.remove.RemoveProcess;
import menu.saveFile.SaveFileProcess;
import menu.search.SearchProcess;
import menu.sortList.SortProcess;

import java.util.ArrayList;

import static menu.main.DisplayMain.*;
import static menu.print.PrintProcess.printProcess;

public class AfterLoginProcess {
    public static boolean formTeacherProcess(ClassManagement classManagement, ArrayList<Teacher> teacherList, ArrayList<Student> studentList,String filepathTeacher,String filepathStudent) {
        boolean isExit;
        formTeacherDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0:
                return true;
            case 1:
                do {
                    isExit = printProcess(classManagement);
                } while (!isExit);
                break;
            case 2:
                do {
                    isExit = AddProcess.addProcess(classManagement);
                } while (!isExit);
                break;
            case 3:
                do {
                    isExit =SearchProcess.searchProcess(classManagement);
                }while (!isExit);
                break;
            case 4:
                RemoveProcess.remove(classManagement);
                break;
            case 5:
                do {
                    isExit = EditProcess.editFormTeacherProcess(classManagement);
                } while (!isExit);
                break;
            case 6:
                SortProcess.sortProcess(classManagement);
                break;
            case 7:
                SaveFileProcess.save(teacherList, studentList, filepathTeacher, filepathStudent);
                break;
            default:
                System.out.println("Re-enter");
                formTeacherProcess(classManagement, teacherList, studentList,filepathTeacher,filepathStudent);
        }
        return false;
    }
    public static boolean teacherProcess(ClassManagement classManagement, Teacher teacher, ArrayList<Teacher> teacherList, ArrayList<Student> studentList, String filepathTeacher,String filepathStudent) {
        boolean isExit;
        teacherDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0:
                return true;
            case 1:
                do {
                    isExit = printProcess(classManagement);
                } while (!isExit);
                break;
            case 2:
                do {
                    isExit =SearchProcess.searchProcess(classManagement);
                }while (!isExit);
                break;
            case 3:
                do {
                    isExit = EditProcess.editTeacherProcess(classManagement, teacher);
                } while (!isExit);
                break;
            case 4:
                SortProcess.sortProcess(classManagement);
                break;
            case 5:
                SaveFileProcess.save( teacherList, studentList,filepathTeacher, filepathStudent);
                break;
            default:
                System.out.println("Re-enter");
                teacherProcess(classManagement, teacher, teacherList, studentList,filepathTeacher,filepathStudent);
        }
        return false;
    }
    public static boolean studentProcess(ClassManagement classManagement, Student student, ArrayList<Teacher> teacherList, ArrayList<Student> studentList,String filepathTeacher,String filepathStudent) {
        boolean isExit;
        studentDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0:
                return true;
            case 1:
                do {
                    isExit = printProcess(classManagement);
                } while (!isExit);
                break;
            case 2:
                do {
                    isExit =SearchProcess.searchProcess(classManagement);
                }while (!isExit);
                break;
            case 3:
                do {
                    isExit = EditProcess.editStudentProcess(classManagement, student);
                } while (!isExit);
                break;
            case 4:
                SortProcess.sortProcess(classManagement);
                break;
            case 5:
                SaveFileProcess.save(teacherList, studentList, filepathTeacher, filepathStudent);
                break;
            default:
                System.out.println("Re-enter");
                studentProcess(classManagement, student, teacherList, studentList,filepathTeacher,filepathStudent);
        }
        return false;
    }
    public static boolean guestProcess(ClassManagement classManagement) {
        boolean isExit;
        guestDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0:
                return true;
            case 1:
                do {
                    isExit = printProcess(classManagement);
                } while (!isExit);
                break;
            case 2:
                do {
                    isExit =SearchProcess.searchProcess(classManagement);
                }while (!isExit);
                break;
            case 3:
                SortProcess.sortProcess(classManagement);
                break;
            default:
                System.out.println("Re-enter");
                guestProcess(classManagement);
        }
        return false;
    }
}
