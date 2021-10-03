package AdditionalTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validators.PhoneValidator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArijusPhoneValidationTest {

    PhoneValidator phoneValidator;

    @BeforeEach
    void setup() {
        phoneValidator = new PhoneValidator();
    }

    @Test
    void PhoneNumbersWithRulesTest_NumberWithNonExistingCountry_ShouldReturnFalse() {
        String phoneNumber = "+9789456413";
        String country = "Opertofika";
        assertFalse(phoneValidator.validatePhoneNumber(phoneNumber, country));
    }

    @Test
    void PhoneRuleTest_AddingNewRule_ListShouldHaveOneElementMore() {
        var oldRules = new ArrayList<>(phoneValidator.getDescriptions());
        String prefix = "+978";
        int length = 10;
        String countryName = "Opertofik";
        phoneValidator.checkNewRule(prefix, length, countryName);
        var newRules = phoneValidator.getDescriptions();
        int lengthDifference = newRules.size() - oldRules.size();
        assertEquals(1, lengthDifference);
    }

    @Test
    void PhoneNumberWithRulesTest_NumberWithExistingCountryWrongLength_ShouldReturnFalse() {
        String prefix = "+978";
        int length = 10;
        String countryName = "Opertofik";
        phoneValidator.checkNewRule(prefix, length, countryName);
        String phoneNumber = "+978123456789123456789";
        assertFalse(phoneValidator.validatePhoneNumber(phoneNumber, countryName));
    }

    @Test
    void PhoneNumberWithRulesTest_NumberWithExistingCountryWrongPrefix_ShouldReturnFalse() {
        String prefix = "+978";
        int length = 10;
        String countryName = "Opertofik";
        phoneValidator.checkNewRule(prefix, length, countryName);
        String phoneNumber = "+112123456";
        assertFalse(phoneValidator.validatePhoneNumber(phoneNumber, countryName));
    }

    @Test
    void PhoneNumberWithRulesTest_NumberWithExistingCountryEverythingGood_ShouldReturnTrue() {
        String prefix = "+978";
        int length = 10;
        String countryName = "Opertofik";
        phoneValidator.checkNewRule(prefix, length, countryName);
        String phoneNumber = "+978123456";
        assertTrue(phoneValidator.validatePhoneNumber(phoneNumber, countryName));
    }


}
