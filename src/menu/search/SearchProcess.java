package menu.search;

import classSchool.ClassManagement;
import classSchool.Person;
import input.Input;
import matchElement.Support;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchProcess {
    static Scanner scanner = new Scanner(System.in);
    public static void searchByName(ClassManagement classManagement) {
        System.out.println("Search by name");
        String name = Input.takeName();
        ArrayList<Person> peopleList = classManagement.searchByName(name);
        if (peopleList!=null) {
            for (Person person:peopleList) {
                System.out.println(person);
            }
        } else {
            System.out.println("This name not exist");
        }
    }
    public static void searchByID(ClassManagement classManagement) {
        System.out.println("Search by ID");
        String ID;
        ID = Input.takeID();
        Person person = classManagement.searchByID(ID);
        if (person!=null) {
            System.out.println(person);
        } else {
            System.out.println("This ID not exist");
        }
    }
    public static boolean searchProcess(ClassManagement classManagement) {
        SearchDisplay.searchDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0:
                return true;
            case 1:
                searchByID(classManagement);
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            case 2:
                searchByName(classManagement);
                System.out.println("Press enter to continue");
                scanner.nextLine();
                break;
            default:
                System.out.println("Re-enter selection");
                searchProcess(classManagement);
                break;
        }
        return false;
    }
}
