package menu.remove;

import classSchool.ClassManagement;
import classSchool.Person;
import input.Input;

public class RemoveProcess {
    public static void remove(ClassManagement classManagement) {
        System.out.println("Remove information");
        System.out.println("Enter ID to find");
        String ID = Input.takeID();
        Person person = classManagement.searchByID(ID);;
        if (person == null) {
            System.out.println("This person not exist");
        } else {
            System.out.println("Deleted");
            System.out.println(person);
            classManagement.remove(person);
        }
    }
}
