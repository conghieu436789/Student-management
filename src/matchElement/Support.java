package matchElement;

import classSchool.FormTeacher;
import classSchool.Person;
import classSchool.Student;
import classSchool.Teacher;

import java.util.ArrayList;

public class Support {
    public static boolean isMatchUser(Person person, String user) {
        return person.getAccount().getUserName().equals(user);
    }
    public static Person getPersonByUser(String user, ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        for (Teacher teacher:teacherList) {
            if (isMatchUser(teacher, user)){
                return teacher;
            }
        }
        for (Student student:studentList) {
            if (isMatchUser(student, user)){
                return student;
            }
        }
        return null;
    }
    public static boolean isUserExist(String user, ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        return getPersonByUser(user, studentList, teacherList)!=null;
    }


    public static boolean isMatchName(Person person, String name) {
        return person.getName().equals(name);
    }
    public static ArrayList<Person> getPersonByName(String name, ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        ArrayList<Person> list = null;
        for (Teacher teacher:teacherList) {
            if (isMatchName(teacher, name)){
                if (list==null) {
                    list = new ArrayList<>();
                }
                list.add(teacher);
            }
        }
        for (Student student:studentList) {
            if (isMatchName(student, name)){
                if (list==null) {
                    list = new ArrayList<>();
                }
                list.add(student);
            }
        }
        return list;
    }
    public static boolean isNameExist(String name, ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        return getPersonByName(name, studentList, teacherList) != null;
    }

    public static boolean isMatchID(Person person, String ID) {
        return person.getID().equals(ID);
    }
    public static Person getPersonByID(String ID, ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        for (Teacher teacher:teacherList) {
            if (isMatchID(teacher, ID)){
                return teacher;
            }
        }
        for (Student student:studentList) {
            if (isMatchID(student, ID)){
                return student;
            }
        }
        return null;
    }
    public static boolean isIDExist(String ID, ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        return getPersonByID(ID, studentList, teacherList)!=null;
    }

    public static boolean isStudent(Person person) {
        return person instanceof Student;
    }
    public static boolean isTeacher(Person person) {
        return (person instanceof Teacher);
    }
    public static boolean isFormTeacher(Person person) {
        return (person instanceof FormTeacher);
    }
}
