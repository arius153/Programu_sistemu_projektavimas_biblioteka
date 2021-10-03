package validators;

import models.CountryPhoneNumberDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneValidator {

    List<CountryPhoneNumberDescription> descriptions = new ArrayList<CountryPhoneNumberDescription>();

    public PhoneValidator() {
        descriptions.addAll(CountryPhoneNumberDescription.getDemoList());
    }

    public boolean validatePhoneNumber(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        String changedNumber = changeLocalNumber(number);
        return containsValidChars(changedNumber);
    }

    public boolean validatePhoneNumber(String number, String country) {
        if (number == null || country == null || number.isEmpty() || country.isEmpty()) {
            return false;
        }
        return descriptions.stream()
                .filter(description -> Objects.equals(description.getEnglishName(), country))
                .findFirst()
                .map(rules -> validateNumberWithDescriptionRules(number, rules))
                .orElse(false);
    }

    public String changeLocalNumber(String localNumber) {
        if (localNumber.startsWith("86")) {
            return "+370" + localNumber.substring(1);
        }
        return localNumber;
    }

    public boolean checkNewRule(String prefix, int length, String countryNameEnglish) {
        if (!containsValidChars(prefix) || length <= 3) {
            return false;
        }
        descriptions.add(new CountryPhoneNumberDescription(countryNameEnglish, prefix, length));
        return true;
    }

    private boolean containsValidChars(String number) {
        if (number.charAt(0) != '+') {
            return false;
        }
        for (int i = 1; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validateNumberWithDescriptionRules(String number, CountryPhoneNumberDescription countryPhoneNumberDescription) {
        return number.startsWith(countryPhoneNumberDescription.getPrefix()) && number.length() == countryPhoneNumberDescription.getLength();
    }

    public List<CountryPhoneNumberDescription> getDescriptions() {
        return descriptions;
    }
}
