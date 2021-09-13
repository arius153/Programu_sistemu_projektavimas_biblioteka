package validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidatorTest {

    PhoneValidator phoneValidator = new PhoneValidator();

    @Test
    void validatePhoneNumber_lithuanianPhoneNumberContainsLetters_shouldReturnFalse() {
        String phoneNumber = "+370a623456";
        assertFalse(phoneValidator.validateLithuanianPhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_lithuanianPhoneNumberDoesNotContainsLetters_shouldReturnTrue() {
        String phoneNumber = "+3706623456";
        assertTrue(phoneValidator.validateLithuanianPhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_lithuanianPhoneNumberStartsWith8ContainsLetters_shouldReturnFalse() {
        String phoneNumber = "8623456";
        assertFalse(phoneValidator.validateLithuanianPhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_lithuanianPhoneNumberStartsWith8DoesNotContainsLetters_shouldReturnTrue() {
        String phoneNumber = "86623456";
        assertTrue(phoneValidator.validateLithuanianPhoneNumber(phoneNumber));
    }

    @Test
    void changeLithuanianLocalToInternational_phoneNumberStartsWith8_shouldReturnTrue() {
        String phoneNumber = "861234567";
        String changedPhoneNumber = phoneValidator.changeLocalLithuanianNumberToInternational(phoneNumber);
        assertTrue(changedPhoneNumber.startsWith("+370"));
    }

    @Test
    void changeLithuanianLocalToInternational_phoneNumberDoesNotStartsWith8_shouldReturnFalse() {
        String phoneNumber = "7561234567";
        String changedPhoneNumber = phoneValidator.changeLocalLithuanianNumberToInternational(phoneNumber);
        assertFalse(changedPhoneNumber.startsWith("+370"));
    }

    @Test
    void validatePhoneNumber_phoneNumberIsEmpty_shouldReturnFalse() {
        String phoneNumber = "";
        assertFalse(phoneValidator.validateLithuanianPhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_phoneNumberIsNull_shouldReturnFalse() {
        String phoneNumber = null;
        assertFalse(phoneValidator.validateLithuanianPhoneNumber(phoneNumber));
    }

    @Test
    void validateInternationalPhoneNumber_phoneNumberIsTooShort_shouldReturnFalse() {
        String phoneNumber = "+386456123";
        String prefix = "+386";
        int length = 20;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_phoneNumberIsTooLong_shouldReturnFalse() {
        String phoneNumber = "+386456123";
        String prefix = "+386";
        int length = 8;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_phoneNumberIsExactLength_shouldReturnTrue() {
        String phoneNumber = "+86456123";
        String prefix = "+386";
        int length = 10;
        assertTrue(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_phoneNumberHasWrongPrefix_shouldReturnFalse() {
        String phoneNumber = "+370456123";
        String prefix = "+386";
        int length = 10;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_phoneNumberHasGoodPrefix_shouldReturnFalse() {
        String phoneNumber = "+386456123";
        String prefix = "+386";
        int length = 10;
        assertTrue(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_phoneNumberIsEmpty_shouldReturnFalse() {
        String phoneNumber = "";
        String prefix = "+386";
        int length = 10;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_phoneNumberIsNull_shouldReturnFalse() {
        String phoneNumber = null;
        String prefix = "+386";
        int length = 10;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }
    @Test
    void validateInternationalPhoneNumber_prefixIsEmpty_shouldReturnFalse() {
        String phoneNumber = "+386456123";
        String prefix = "";
        int length = 10;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_prefixIsNull_shouldReturnFalse() {
        String phoneNumber = "+386456123";
        String prefix = null;
        int length = 10;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

    @Test
    void validateInternationalPhoneNumber_lengthIsZeroOrNegative_shouldReturnFalse() {
        String phoneNumber = "+386456123";
        String prefix = "+386";
        int length = 0;
        assertFalse(phoneValidator.validateInternationalPhoneNumber(phoneNumber, prefix, length));
    }

}