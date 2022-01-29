package test;

import main.PasswordValidator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PasswordValidationTest {
    public static final List<String> BANNED_LIST = new ArrayList<>(Arrays.asList("expedia", "password"));

    @Test
    public void validateEmptyPassword() {

        String result = PasswordValidator.validatePasswordRules
                ("ValidPwd1", "", BANNED_LIST, 7, 9).trim();
        assertEquals("INVALID 1 2 3", result);

        String result1 = PasswordValidator.validatePasswordRules
                ("", "ValidPwd3", BANNED_LIST, 7, 9).trim();
        assertEquals("VALID", result1);
    }

    @Test
    public void validatePassword() {

        String result = PasswordValidator.validatePasswordRules
                ("ValidPwd1", "ValidPwd3", BANNED_LIST, 7, 9).trim();
        assertEquals("VALID", result);
    }

    @Test
    public void validateRuleOne() {
        String result = PasswordValidator.validatePasswordRules
                ("ValidPwd1", "ValidPw3", BANNED_LIST, 9, 10).trim();
        assertEquals("INVALID 1", result);
    }

    @Test
    public void validateRuleTwo() {
        String result = PasswordValidator.validatePasswordRules
                ("ValidPwd1", "validpwd3", BANNED_LIST, 7, 9).trim();
        assertEquals("INVALID 2", result);
    }

    @Test
    public void validateRuleThree() {

        String result = PasswordValidator.validatePasswordRules
                ("ValidPwd1", "ValidPwd", BANNED_LIST, 7, 9).trim();
        assertEquals("INVALID 3", result);
    }

    @Test
    public void validateRuleFour() {

        String result = PasswordValidator.validatePasswordRules
                ("ValidPwd1", "expediaPwd3", BANNED_LIST, 7, 15).trim();
        assertEquals("INVALID 4", result);
    }

    @Test
    public void validateRuleFive() {
        String result = PasswordValidator.validatePasswordRules
                ("ValidPwd1", "ValidPwd1", BANNED_LIST, 7, 9).trim();
        assertEquals("INVALID 5", result);
    }

    @Test
    public void sampleTestCase1() {
        String result = PasswordValidator.validatePasswordRules
                ("Password1", "Password1", BANNED_LIST, 10, 15).trim();
        assertEquals("INVALID 1 5", result);

        String result2 = PasswordValidator.validatePasswordRules
                ("ValidPwd2", "expediapass", BANNED_LIST, 8, 14).trim();
        assertEquals("INVALID 2 3 4", result2);
    }
}

