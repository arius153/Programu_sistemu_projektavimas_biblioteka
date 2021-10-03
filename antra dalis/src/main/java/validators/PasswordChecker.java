package validators;

public class PasswordChecker {

    private final String DEFAULT_SPECIAL_SYMBOLS = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private final int DEFAULT_PASSWORD_LENGTH = 0;

    public boolean validatePassword(String password) {
        return password != null && validLength(password, DEFAULT_PASSWORD_LENGTH) && containsUppercase(password) && containsSpecialCharacter(password, DEFAULT_SPECIAL_SYMBOLS);
    }

    public boolean validatePassword(String password, int minLength) {
        return password != null && validLength(password, minLength) && containsUppercase(password) && containsSpecialCharacter(password, DEFAULT_SPECIAL_SYMBOLS);
    }

    public boolean validatePassword(String password, String specialSymbols) {
        return password != null && validLength(password, DEFAULT_PASSWORD_LENGTH) && containsUppercase(password) && containsSpecialCharacter(password, specialSymbols);
    }

    public boolean validatePassword(String password, int minLength, String specialSymbols) {
        return password != null && validLength(password, minLength) && containsUppercase(password) && containsSpecialCharacter(password, specialSymbols);
    }

    private boolean validLength(String password, int length) {
        return password.length() >= length;
    }

    private boolean containsUppercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password, String specialCharacters) {
        for (int i = 0; i < password.length(); i++) {
            if (specialCharacters.indexOf(password.charAt(i)) > -1) {
                return true;
            }
        }
        return false;
    }

}
