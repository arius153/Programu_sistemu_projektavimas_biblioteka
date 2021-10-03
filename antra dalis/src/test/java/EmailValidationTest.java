import org.junit.jupiter.api.*;
import validators.EmailValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidationTest {

    EmailValidator emailValidator;


    @BeforeEach
    void setup() {
        emailValidator = new EmailValidator();
    }

    @Test
    void emailEtaTest_NoEtaSign() {
        assertFalse(emailValidator.validateEmail("vardenis.pavardenisgmail.com"));
    }

    @Test
    void emailEtaTest_MoreEtaSigns() {
        assertFalse(emailValidator.validateEmail("vardenis.pava@ardenis@gmil.com"));
    }

    @Test
    void emailEtaTest_ValidEtaSign() {
        assertTrue(emailValidator.validateEmail("vardenis.pavardenis@gmail.com"));
    }

    @Test
    void emailCharactersTest_InvalidCharacters() {
        //Buvo neklaidingas el paštas -> vardenis!.pavardenis?@gmail.com, pakeista į vardenis!..pavardenis?@gmail.com
        assertFalse(emailValidator.validateEmail("vardenis!..pavardenis?@gmail.com"));
    }

    @Test
    void emailCharactersTest_ValidCharacters() {
        assertTrue(emailValidator.validateEmail("vardenis.pavardenis@gmail.com"));
    }

    @Test
    void emailDomainTest_InvalidDomain() {
        assertFalse(emailValidator.validateEmail("vardenis.pavardenis@ggg#mail.com"));
    }

    @Test
    void emailDomainTest_InvalidTopLevelDomain() {
        assertFalse(emailValidator.validateEmail("vardenis.pavardenis@gmail.commm"));
    }

    @Test
    void emailDomainTest_ValidDomain() {
        assertTrue(emailValidator.validateEmail("vardenis.pavardenis@gmail.com"));
    }

    @AfterEach
    void tearDown() {

    }
}
