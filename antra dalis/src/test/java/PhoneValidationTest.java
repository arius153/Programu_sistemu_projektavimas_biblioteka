import org.junit.jupiter.api.*;
import validators.PhoneValidator;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidationTest {

    PhoneValidator phoneValidator;

    @BeforeEach
    void setup() {
        phoneValidator = new PhoneValidator();
    }

    @Test
    void PhoneNumbersTest_InvalidChar() {
        assertFalse(phoneValidator.validatePhoneNumber("+370*56a741"));
    }

    @Test
    void PhoneNumbersTest_ValidChar() {
        assertTrue(phoneValidator.validatePhoneNumber("+370245741"));
    }

    @Test
    void PhoneLocalNumberTest_ChangeDone() {
        assertEquals("+37065245248", phoneValidator.changeLocalNumber("865245248"));
    }

    @Test
    void PhoneNewRuleTest_InvalidPrefix() {
        assertFalse(phoneValidator.checkNewRule("371", 11, "Latvia"));
    }

    @Test
    void PhoneNewRuleTest_InvalidNumberLength() {
        assertFalse(phoneValidator.checkNewRule("+371", 3, "Latvia"));
    }

    @Test
    void PhoneNewRuleTest_ValidRule() {
        assertTrue(phoneValidator.checkNewRule("+371", 11, "Latvia"));
    }


    @AfterEach
    void tearDown() {

    }
}
