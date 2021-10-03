package AdditionalTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validators.PasswordChecker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArijusPasswordValidationTest {
    PasswordChecker passwordValidator;

    @BeforeEach
    void setup() {
        passwordValidator = new PasswordChecker();
    }

    @Test
    void passwordCustomSpecialSymbolsTest_NotEnoughSpecialSymbols_ShouldReturnFalse() {
        String password = "Abc123a¬¬¬s£Daa";
        String specialSymbols = "¬£";
        assertTrue(passwordValidator.validatePassword(password, specialSymbols));
    }

    @Test
    void passwordCustomSpecialSymbolsTest_enoughSpecialSymbols_ShouldReturnTrue() {
        String password = "Abc123a¬¬¬s£Daa";
        String specialSymbols = "¬£";
        assertTrue(passwordValidator.validatePassword(password, specialSymbols));
    }

    @Test
    void passwordCustomSpecialSymbolsAndMinLengthTest_NotEnoughSpecialSymbolsGoodLength_ShouldReturnFalse() {
        String password = "Abc123a!=Daa";
        String specialSymbols = "¬£";
        int minLength = 3;
        assertFalse(passwordValidator.validatePassword(password, minLength, specialSymbols));
    }

    @Test
    void passwordCustomSpecialSymbolsAndMinLengthTest_NotEnoughSpecialSymbolsBadLength_ShouldReturnFalse() {
        String password = "Abc123a!Daa";
        String specialSymbols = "¬£";
        int minLength = 20;
        assertFalse(passwordValidator.validatePassword(password, minLength, specialSymbols));
    }

    @Test
    void passwordCustomSpecialSymbolsAndMinLengthTest_EnoughSpecialSymbolsBadLength_ShouldReturFalse() {
        String password = "Abc123¬£Daa";
        String specialSymbols = "¬£";
        int minLength = 20;
        assertFalse(passwordValidator.validatePassword(password, minLength, specialSymbols));
    }

    @Test
    void passwordCustomSpecialSymbolsAndMinLengthTest_EnoughSpecialSymbolsGoodLength_ShouldReturnTrue() {
        String password = "Abc123¬£Daa";
        String specialSymbols = "¬£";
        int minLength = 3;
        assertTrue(passwordValidator.validatePassword(password, minLength, specialSymbols));
    }

}
