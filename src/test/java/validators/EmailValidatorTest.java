package validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EmailValidatorTest {

    private EmailValidator emailValidator;

    @BeforeAll
    void setUp()
    {
        emailValidator = new EmailValidator();
    }

    @Test
    void validateEmail_emailIsEmpty_ShouldReturnFalse() {
        String email = "";
        assertFalse(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailIsNull_ShouldReturnFalse() {
        String email = null;
        assertFalse(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailContainsAtSymbol_ShouldReturnTrue() {
        String email = "arijus@gmail.com";
        assertTrue(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailDoesNotContainsAtSymbol_ShouldReturnFalse() {
        String email = "arijusgmail.com";
        assertFalse(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailContainsTooManyAtSymbols_ShouldReturnFalse() {
        String email = "arijus@@@gmail.com";
        assertFalse(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailContainsIllegalSymbols_ShouldReturnFalse() {
        String email = "ari<jus@gma?il.com";
        assertFalse(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailDoesNotContainsIllegalSymbols_ShouldReturnTrue() {
        String email = "arijus@gmail.com";
        assertTrue(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailContainsValidDomainAndTLD_ShouldReturnTrue() {
        String email = "arijus@gmail.com";
        assertTrue(emailValidator.validateEmail(email));
    }

    @Test
    void validateEmail_emailDoesNotContainsValidDomainAndTLD_ShouldReturnFalse() {
        String email = "arijus@.rdfmkpoasdj";
        assertFalse(emailValidator.validateEmail(email));
    }



}