package validators;

public class EmailValidator {

    public boolean validateEmail(String email) {
        return containsAtSymbol(email) && doesNotContainsIllegalSymbols(email) && containsValidDomainAndTLD(email);
    }

    private boolean containsAtSymbol(String email) {
        return true;
    }

    private boolean doesNotContainsIllegalSymbols(String email) {
        return true;
    }

    private boolean containsValidDomainAndTLD(String email) {
        return true;
    }
}
