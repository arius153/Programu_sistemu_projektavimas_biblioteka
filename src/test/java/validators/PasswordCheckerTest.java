package validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordCheckerTest {

    PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    void validatePassword_passwordIsShorterThanDefaultValue_ShouldReturnFalse() {
        // *Password Length = 7
        String password = "Asd123!";
        assertFalse(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_passwordIsExactAsDefaultValue_ShouldReturnTrue() {
        // *Password Length = 8
        String password = "Asd123!e";
        assertTrue(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_passwordIsLongerThanDefaultValue_ShouldReturnTrue() {
        // *Password Length = 13
        String password = "Asd123!eAsdqw";
        assertTrue(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_passwordIsShorterThanCustomLength_ShouldReturnFalse() {
        // *Password Length = 7 | Custom minLength = 10
        String password = "Asd123!";
        int minLength = 10;
        assertFalse(passwordChecker.validatePassword(password, minLength));
    }

    @Test
    void validatePassword_passwordIsExactAsCustomLength_ShouldReturnTrue() {
        // *Password Length = 10 | Custom minLength = 10
        int minLength = 10;
        String password = "Asd123!e12";
        assertTrue(passwordChecker.validatePassword(password, minLength));
    }

    @Test
    void validatePassword_passwordIsLongerThanCustomLength_ShouldReturnTrue() {
        // *Password Length = 13 | Custom minLength = 10
        int minLength = 10;
        String password = "Asd123!eAsdqw";
        assertTrue(passwordChecker.validatePassword(password, minLength));
    }

    @Test
    void validatePassword_passwordContainsUppercaseLetter_ShouldReturnTrue() {
        String password = "Asd123!@";
        assertTrue(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_passwordDoesNotContainsUppercaseLetter_ShouldReturnFalse() {
        String password = "asd123!@";
        assertFalse(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_passwordContainsAtLeastOneOfDefaultSpecialSymbols_ShouldReturnTrue() {
        // Default special symbols = "!@#$%^&*()+-"
        String password = "Asd123!e";
        assertTrue(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_passwordDoesNotContainsAtLeastOneOfDefaultSpecialSymbols_ShouldReturnFalse() {
        // Default special symbols = "!@#$%^&*()+-"
        String password = "Asd123{}";
        assertFalse(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_passwordContainsAtLeastOneOfNonDefaultSpecialSymbols_ShouldReturnTrue() {
        String specialSymbols = "<>,./";
        String password = "Asd123<>./>";
        assertTrue(passwordChecker.validatePassword(password, specialSymbols));
    }

    @Test
    void validatePassword_passwordDoesNotContainsAtLeastOneOfNonDefaultSpecialSymbols_ShouldReturnFalse() {
        String specialSymbols = "<>,./";
        String password = "Asd123{}";
        assertFalse(passwordChecker.validatePassword(password, specialSymbols));
    }

    @Test
    void validatePassword_phoneNumberIsEmpty_shouldReturnFalse() {
        String password = "";
        assertFalse(passwordChecker.validatePassword(password));
    }

    @Test
    void validatePassword_phoneNumberIsnull_shouldReturnFalse() {
        String password = null;
        assertFalse(passwordChecker.validatePassword(password));
    }

}