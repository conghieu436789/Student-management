package menu.print;

import classSchool.ClassManagement;
import input.Input;

import java.util.Scanner;

import static menu.print.PrintDisplay.printDisplay;

public class PrintProcess {
    static Scanner scanner = new Scanner(System.in);
    public static boolean printProcess(ClassManagement classManagement) {
        printDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 1:
                printClassList(classManagement);
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case 2:
                printTeacherList(classManagement);
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case 3:
                printStudentList(classManagement);
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case 0:
                return true;
            default:
                System.out.println("Re-select");
                printProcess(classManagement);
        }
        return false;
    }

    public static void printClassList(ClassManagement classManagement) {
        classManagement.printListAll();
    }
    public static void printStudentList(ClassManagement classManagement) {
        classManagement.printListStudent();
    }
    public static void printTeacherList(ClassManagement classManagement) {
        classManagement.printListTeacher();
    }
}
