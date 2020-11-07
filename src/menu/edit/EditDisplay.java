package menu.edit;

public class EditDisplay {
    public static void editFormTeacherDisplay() {
        System.out.println("Edit");
        System.out.println("1. Edit my profile");
        System.out.println("2. Edit teacher's profile");
        System.out.println("3. Edit student's profile");
        System.out.println("4. Edit account");
        System.out.println("5. Edit student's grade");
        System.out.println("0. Back to main menu");
    }
    public static void editTeacherDisplay() {
        System.out.println("Edit");
        System.out.println("1. Edit my profile");
        System.out.println("2. Edit my account");
        System.out.println("3. Edit student's grade");
        System.out.println("0. Back");
    }
    public static void editStudentDisplay() {
        System.out.println("Edit");
        System.out.println("1. Edit my profile");
        System.out.println("2. Edit my account");
        System.out.println("0. Back");
    }
    public static void editAccountFTDisplay() {
        System.out.println("Edit account");
        System.out.println("1. Change my account");
        System.out.println("2. Change teacher account");
        System.out.println("3. Change student account");
        System.out.println("0. Back");
    }
    public static void editAccountCommonDisplay() {
        System.out.println("Edit account");
        System.out.println("1. Change user name");
        System.out.println("2. Change password");
    }

    public static void editProfileStudentDisplay() {
        System.out.println("Edit profile");
        System.out.println("0. Back");
        System.out.println("1. Edit ID");
        System.out.println("2. Edit name");
        System.out.println("3. Edit address");
        System.out.println("4. Edit birth day");
        System.out.println("5. Edit gender");
        System.out.println("6. Edit all attribute");
        System.out.println("0. Back");
    }
    public static void editProfileTeacherDisplay() {
        System.out.println("Edit profile");
        System.out.println("1. Edit ID");
        System.out.println("2. Edit name");
        System.out.println("3. Edit address");
        System.out.println("4. Edit birth day");
        System.out.println("5. Edit gender");
        System.out.println("6. Edit role");
        System.out.println("7. Edit all attribute");
        System.out.println("0. Back");
    }
    public static void editGradeStudentDisplay() {
        System.out.println("Edit grade");
        System.out.println("1. Edit math");
        System.out.println("2. Edit physic");
        System.out.println("3. Edit chemistry");
        System.out.println("4. Edit all");
        System.out.println("0. Back");
    }

}
