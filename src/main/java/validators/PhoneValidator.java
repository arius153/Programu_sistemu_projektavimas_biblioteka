package validators;

public class PhoneValidator {

    public boolean validateLithuanianPhoneNumber(String phoneNumber) {
        return containsLetters(changeLocalLithuanianNumberToInternational(phoneNumber));
    }

    public boolean validateInternationalPhoneNumber(String phoneNumber, String internationalPrefix, int length)
    {
        return true;
    }

    private boolean containsLetters(String phoneNumber) {
        return true;
    }

    public String changeLocalLithuanianNumberToInternational(String phoneNumber) {
        return phoneNumber;
    }

    public String changeCustomLocalNumberToInternational(String phoneNumber, String localPrefix, String internationalPrefix) {
        return phoneNumber;
    }



}
