//package menu;
//
//import classSchool.*;
//import file.FileProcess;
//import input.Input;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class FormTeacherMenu {
//    private static final String filepathPeopleList = "PeopleList.dat";
//    private static final String filepathStudentList = "StudentList.txt";
//    private static final String filepathTeacherList = "TeacherList.txt";
//    private ArrayList<Person> peopleList;
//    private ArrayList<Student> studentList;
//    private ArrayList<Teacher> teacherList;
//    private ClassManagement classManagement;
//    public FormTeacherMenu() {
//        if (FileProcess.getFile(filepathPeopleList)==null) {
//            peopleList = new ArrayList<>();
//        } else {
//            peopleList = (ArrayList<Person>) FileProcess.getFile(filepathPeopleList);
//        }
//        if (FileProcess.getFile(filepathStudentList)==null) {
//            studentList = new ArrayList<>();
//        } else {
//            studentList = (ArrayList<Student>) FileProcess.getFile(filepathStudentList);
//        }
//        if (FileProcess.getFile(filepathTeacherList)==null) {
//            teacherList = new ArrayList<>();
//        } else {
//            teacherList = (ArrayList<Teacher>) FileProcess.getFile(filepathTeacherList);
//        }
//        classManagement = new ClassManagement(peopleList, studentList, teacherList);
//    }
//
//    public void selection() {
//        display();
//        int select = Integer.parseInt(Input.takeSelect());
//        switch (select){
//            case 1:
//                PrintMenu.displayListProcess(classManagement);
//                while (continueAct()==1) {
//                    PrintMenu.displayListProcess(classManagement);
//                }
//                break;
//            case 2:
//                add();
//                while (continueAct()==1) {
//                    add();
//                }
//                break;
//            case 3:
//                search();
//                while (continueAct()==1) {
//                    search();
//                }
//                break;
//            case 4:
//                remove();
//                while (continueAct()==1) {
//                    remove();
//                }
//            case 5:
//                edit();
//                while (continueAct()==1) {
//                    remove();
//                }
//            case 9:
//                save();
//                break;
//        }
//    }
//
//    public int continueAct() {
//        System.out.println("Press '1' to continue, '2' to back" );
//        Scanner scanner = new Scanner(System.in);
//        int select = 0;
//        boolean checkType;
//        do {
//            checkType =true;
//            try {
//                select = Integer.parseInt(scanner.nextLine());
//                if (select!=1 && select!=2) {
//                    System.out.println("Press '1' to continue, '2' to back");
//                    checkType =false;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                checkType =false;
//                System.out.println("Press number '1' to continue, '2' to back");
//            }
//        } while (!checkType);
//        return select;
//    }
//}
