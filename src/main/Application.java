package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        String oldPwd = "expediapass";
        String newPwd = "Expediapass1";
        List<String> bannedList = new ArrayList<>(Arrays.asList("expedia", "password"));
        int minimum = 8;
        int maximum = 14;

        System.out.println(PasswordValidator.validatePasswordRules(oldPwd, newPwd, bannedList, minimum, maximum));
    }

}
