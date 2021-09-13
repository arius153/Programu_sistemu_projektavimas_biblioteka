package validators;

public class PasswordChecker {

    private final int MIN_LENGTH_DEFAULT = 8;
    private final String DEFAULT_SPECIAL_SYMBOLS = "!@#$%^&*()+-";

    public boolean validatePassword(String password) {
       return minLength(password, MIN_LENGTH_DEFAULT) && containsUppercaseLetter(password) && containsSpecialSymbol(password, DEFAULT_SPECIAL_SYMBOLS);
    }

    public boolean validatePassword(String password, int minLength) {
        return minLength(password, minLength)  && containsUppercaseLetter(password) && containsSpecialSymbol(password, DEFAULT_SPECIAL_SYMBOLS);
    }

    public boolean validatePassword(String password, String specialSymbols) {
        return minLength(password, MIN_LENGTH_DEFAULT) && containsUppercaseLetter(password) && containsSpecialSymbol(password, specialSymbols);
    }

    public boolean validatePassword (String password, int minLength, String specialSymbols) {
        return minLength(password, minLength) && containsUppercaseLetter(password) && containsSpecialSymbol(password, specialSymbols);
    }

    private boolean minLength(String password, int Length) {
        return true;
    }

    private boolean containsUppercaseLetter(String password) {
        return true;
    }

    private boolean containsSpecialSymbol(String password, String specialSymbols) {
        return true;
    }
}
