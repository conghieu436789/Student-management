package menu.saveFile;

import classSchool.Person;
import classSchool.Student;
import classSchool.Teacher;
import file.FileProcess;


import java.util.ArrayList;
import java.util.Scanner;

public class SaveFileProcess {
    static Scanner scanner = new Scanner(System.in);
    public static void save(ArrayList<Teacher> teacherList, ArrayList<Student> studentList,String filepathTeacher,String filepathStudent) {
        FileProcess.writeFile(teacherList,filepathTeacher);
        FileProcess.writeFile(studentList,filepathStudent);
        System.out.println("Saved");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
}
