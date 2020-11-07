import classSchool.*;
import input.Input;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static String enterSelect() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your selection");
        String selection = scanner.nextLine();
        return selection;
    }
    public static int takeSelect() {
        int select = 0;
        boolean checkType;
        do {
            checkType = true;
            try {
                select = Integer.parseInt(enterSelect());
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return select;
    }
    public static void main(String[] args) {
        int b = takeSelect();

        int select = b;



//        System.out.println(select);

    }
}
