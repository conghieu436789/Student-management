package menu.sortList;

import classSchool.ClassManagement;
import input.Input;
import menu.print.PrintProcess;

import java.util.Scanner;

import static menu.sortList.SortDisplay.sortDisplay;

public class SortProcess {
    static Scanner scanner = new Scanner(System.in);
    public static boolean sortProcess(ClassManagement classManagement) {
        sortDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0: return true;
            case 1:
                System.out.println("Sort student list by name");
                sortByNameProcess(classManagement);
                System.out.println("Sorted");
                PrintProcess.printStudentList(classManagement);
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Sort student list by grade");
                sortStudentByGradeProcess(classManagement);
                System.out.println("Sorted");
                PrintProcess.printStudentList(classManagement);
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            default:
                System.out.println("Re-enter");
                sortProcess(classManagement);
        }
        return false;
    }
    public static void sortByNameProcess(ClassManagement classManagement) {
        classManagement.sortByName();
    }
    public static void sortStudentByGradeProcess(ClassManagement classManagement) {
        classManagement.sortByGrade();
    }
}
