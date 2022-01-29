package main;

import java.util.List;

public final class PasswordValidator {

    public static String validatePasswordRules(String oldPwd, String newPwd, List<String> bannedList,
                                               int minimum, int maximum) {
        StringBuilder response = new StringBuilder();
        try {
            if ((newPwd.length() < minimum || newPwd.length() > maximum)) {
                response.append(Constants.ONE_RULE);
            }

            response.append(!newPwd.matches(Constants.UPPERCASE_REGEX) ? Constants.TWO_RULE : "");
            response.append(!newPwd.matches(Constants.NUMBERS_REGEX) ? Constants.THREE_RULE : "");

            for (String value : bannedList) {
                if (newPwd.contains(value)) {
                    response.append(Constants.FOUR_RULE);
                    break;
                }
            }

            response.append(oldPwd.equalsIgnoreCase(newPwd) ? Constants.FIVE_RULE : "");

            if (response.length() > 0) {
                return (Constants.INVALID + response);
            }
            return (Constants.VALID);
        } catch (Exception e) {
            return (Constants.EXCEPTION);
        }
    }
}
