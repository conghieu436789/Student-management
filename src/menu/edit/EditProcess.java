package menu.edit;

import classSchool.*;
import input.Input;
import matchElement.Support;

import java.util.ArrayList;

import static menu.edit.EditAttribute.*;
import static menu.edit.EditDisplay.*;

public class EditProcess {
    public static boolean editFormTeacherProcess(ClassManagement classManagement) {
        editFormTeacherDisplay();
        String ID;
        int select = Input.takeSelect();
        boolean isExit;
        switch (select) {
            case 0: return true;
            case 1:
                do {
                    isExit = editProfileTeacherProcess(classManagement, classManagement.getFormTeacher());
                } while (!isExit);
                break;
            case 2:
                System.out.println("Edit other teacher profile");
                System.out.println("Enter ID to find");
                ID = Input.takeID();
                Teacher teacher;
                if (Support.isIDExist(ID,classManagement.getStudentList(), classManagement.getTeacherList())) {
                    if (classManagement.searchByID(ID) instanceof Teacher) {
                        teacher= (Teacher) classManagement.searchByID(ID);
                        do {
                            isExit = editProfileTeacherProcess(classManagement, teacher);
                        } while (!isExit);
                    } else {
                        System.out.println("Teacher not exist");
                    }
                } else {
                    System.out.println("Teacher not exist");
                }
                break;
            case 3:
                System.out.println("Edit Student profile");
                System.out.println("Enter ID to find");
                ID = Input.takeID();
                if (Support.isIDExist(ID,classManagement.getStudentList(), classManagement.getTeacherList())) {
                    if (classManagement.searchByID(ID) instanceof Student) {
                        Student student = (Student) classManagement.searchByID(ID);
                        do {
                            isExit = editProfileStudentProcess(classManagement, student);
                        } while (!isExit);
                    } else {
                        System.out.println("Student not exist");
                    }
                } else {
                    System.out.println("Student not exist");
                }
                break;
            case 4:
                do {
                    isExit = editAccountFTProcess(classManagement);
                } while (!isExit);
                break;
            case 5:
                System.out.println("Edit student grade");
                System.out.println("Enter ID to find");
                ID = Input.takeID();
                if (Support.isIDExist(ID,classManagement.getStudentList(), classManagement.getTeacherList())) {
                    if (classManagement.searchByID(ID) instanceof Student) {
                        Student student = (Student) classManagement.searchByID(ID);
                        do {
                            isExit = editStudentGradeProcess(classManagement, student);
                        } while (!isExit);
                    }else {
                        System.out.println("Student not exist");
                    }
                } else {
                    System.out.println("Student not exist");
                }
                break;
            default:
                System.out.println("Re-enter");
                editFormTeacherProcess(classManagement);
        }
        return false;
    }
    public static boolean editTeacherProcess(ClassManagement classManagement, Teacher teacher) {
        editTeacherDisplay();
        int select = Input.takeSelect();
        boolean isExit;
        switch (select) {
            case 0: return true;
            case 1:
                do {
                    isExit = editProfileTeacherProcess(classManagement, teacher);
                } while (!isExit);
                break;
            case 2:
                editAccountCommonProcess(classManagement, teacher);
                break;
            case 3:
                System.out.println("Edit grade");
                System.out.println("Edit student grade");
                System.out.println("Enter ID to find");
                String ID = Input.takeID();
                if (Support.isIDExist(ID,classManagement.getStudentList(), classManagement.getTeacherList())) {
                    if (classManagement.searchByID(ID) instanceof Student) {
                        Student student = (Student) classManagement.searchByID(ID);
                        if (teacher.getRole()==RoleTeacher.MATH) {
                            editMathGrade(classManagement, student);
                        } else if (teacher.getRole()==RoleTeacher.PHYSIC) {
                            editPhysicGrade(classManagement, student);
                        } else {
                            editChemistryGrade(classManagement, student);
                        }
                    } else {
                        System.out.println("Student not exist");
                    }
                }else {
                    System.out.println("Student not exist");
                }
                break;
            default:
                System.out.println("Re-enter");
                editTeacherProcess(classManagement, teacher);
        }
        return false;
    }
    public static boolean editStudentProcess(ClassManagement classManagement, Student student) {
        editStudentDisplay();
        int select = Input.takeSelect();
        boolean isExit;
        switch (select) {
            case 1:
                do {
                    isExit = editProfileStudentProcess(classManagement, student);
                } while (!isExit);
                break;
            case 2:
                editAccountCommonProcess(classManagement, student);
                break;
            case 0: return true;
            default:
                System.out.println("Re-enter");
                editStudentProcess(classManagement, student);
        }
        return false;
    }

    public static boolean editAccountFTProcess(ClassManagement classManagement) {
        editAccountFTDisplay();
        String ID;
        int select = Input.takeSelect();
        switch (select) {
            case 0: return true;
            case 1:
                editAccountCommonProcess(classManagement, classManagement.getFormTeacher());
                break;
            case 2:
                System.out.println("Edit other teacher account");
                System.out.println("Enter ID to find");
                ID = Input.takeID();
                Teacher teacher;
                if (Support.isIDExist(ID,classManagement.getStudentList(), classManagement.getTeacherList())) {
                    teacher = (Teacher) classManagement.searchByID(ID);
                    editAccountCommonProcess(classManagement, teacher);;
                } else {
                    System.out.println("This ID not exist");
                }
                break;
            case 3:
                System.out.println("Edit Student account");
                System.out.println("Enter ID to find");
                ID = Input.takeID();
                if (Support.isIDExist(ID,classManagement.getStudentList(), classManagement.getTeacherList())) {
                    Student student = (Student) classManagement.searchByID(ID);
                    editAccountCommonProcess(classManagement, student);
                } else {
                    System.out.println("This ID not exist");
                }
                break;
            default:
                System.out.println("Re-enter");
                editAccountFTProcess(classManagement);
        }
        return false;
    }
    public static void editAccountCommonProcess(ClassManagement classManagement, Person person) {
        editAccountCommonDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 1:
                System.out.println("Edit User Name");
                editUserName(classManagement, person);
                break;
            case 2:
                System.out.println("Edit password");
                editPassword(classManagement, person);
                break;
        }
    }

//    public static boolean editProfileFormTeacherProcess(ClassManagement classManagement, ArrayList<Person> list, FormTeacher teacher) {
//        editProfileTeacherDisplay();
//        int select = Integer.parseInt(Input.takeSelect());
//        switch (select) {
//            case 0:return true;
//            case 1:
//                editID(classManagement, teacher, list);
//                break;
//            case 2:
//                editName(classManagement, teacher);
//                break;
//            case 3:
//                editAddress(classManagement, teacher);
//                break;
//            case 4:
//                editBirthDay(classManagement, teacher);
//                break;
//            case 5:
//                editGender(classManagement, teacher);
//                break;
//            case 6:
//                editRole(classManagement, teacher);
//                break;
//            case 7:
//                editName(classManagement, teacher);
//                editAddress(classManagement, teacher);
//                editBirthDay(classManagement, teacher);
//                editGender(classManagement, teacher);
//                editRole(classManagement, teacher);
//                editID(classManagement, teacher, list);
//                break;
//            default:
//                System.out.println("Re-enter");
//                editProfileTeacherProcess(classManagement, list, teacher);
//        }
//        return false;
//    }
    public static boolean editProfileTeacherProcess(ClassManagement classManagement, Teacher teacher) {
        editProfileTeacherDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0:return true;
            case 1:
                editID(classManagement, teacher);
                break;
            case 2:
                editName(classManagement, teacher);
                break;
            case 3:
                editAddress(classManagement, teacher);
                break;
            case 4:
                editBirthDay(classManagement, teacher);
                break;
            case 5:
                editGender(classManagement, teacher);
                break;
            case 6:
                editRole(classManagement, teacher);
                break;
            case 7:
                editName(classManagement, teacher);
                editAddress(classManagement, teacher);
                editBirthDay(classManagement, teacher);
                editGender(classManagement, teacher);
                editRole(classManagement, teacher);
                editID(classManagement, teacher);
                break;
            default:
                System.out.println("Re-enter");
                editProfileTeacherProcess(classManagement, teacher);
        }
        return false;
    }
    public static boolean editProfileStudentProcess(ClassManagement classManagement, Student student) {
        editProfileStudentDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0: return true;
            case 1:
                editID(classManagement, student);
                break;
            case 2:
                editName(classManagement, student);
                break;
            case 3:
                editAddress(classManagement, student);
                break;
            case 4:
                editBirthDay(classManagement, student);
                break;
            case 5:
                editGender(classManagement, student);
                break;
            case 6:
                editName(classManagement, student);
                editAddress(classManagement, student);
                editBirthDay(classManagement, student);
                editGender(classManagement, student);
                editID(classManagement, student);
                break;
            default:
                System.out.println("Re-enter");
                editProfileStudentProcess(classManagement, student);
        }
        return false;
    }
    public static boolean editStudentGradeProcess(ClassManagement classManagement, Student student) {
        editGradeStudentDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 1:
                editMathGrade(classManagement, student);
                break;
            case 2:
                editPhysicGrade(classManagement, student);
                break;
            case 3:
                editChemistryGrade(classManagement, student);
                break;
            case 4:
                editGrades(classManagement, student);
                break;
            case 0: return true;
            default:
                System.out.println("Re-enter");
                editStudentGradeProcess(classManagement, student);
        }
        return false;
    }
}
