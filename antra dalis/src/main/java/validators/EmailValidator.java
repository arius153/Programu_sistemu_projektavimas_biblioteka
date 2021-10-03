package validators;

import java.util.List;

public class EmailValidator {

    private final List<String> validTopLevelDomains;
    private final String unquotedSpecialSymbols = "!#$%&'*+-/=?^_`{|}~.";

    public EmailValidator() {
        validTopLevelDomains = List.of(".com", ".lt", ".org", ".net");
    }

    public boolean validateEmail(String email) {
        return email != null && checkEtaSign(email) && validateName(email) && validateDomain(email) && validateUpperDomain(email);
    }

    private boolean checkEtaSign(String email) {
        int etaSigns = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                etaSigns++;
            }
        }
        return etaSigns == 1;
    }

    private boolean validateName(String email) {
        String name = email.substring(0, email.indexOf('@'));
        boolean previousDot = false;
        if (name.length() > 64) {
            return false;
        }
        if (name.charAt(0) == '.' || name.charAt(name.length() - 1) == '.') {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            char charToCheck = name.charAt(i);
            if (!Character.isLetterOrDigit(charToCheck) && unquotedSpecialSymbols.indexOf(charToCheck) == -1) {
                return false;
            }
            if (charToCheck == '.') {
                if (previousDot) {
                    return false;
                } else {
                    previousDot = true;
                }
            } else {
                previousDot = false;
            }
        }
        return true;
    }

    private boolean validateDomain(String email) {
        String domain = email.substring(email.indexOf('@') + 1);
        if (domain.length() > 255) {
            return false;
        }
        if (!(Character.isLetterOrDigit(domain.charAt(0)) && Character.isLetterOrDigit(domain.charAt(domain.length() - 1)))) {
            return false;
        }
        for (int i = 0; i < domain.length(); i++) {
            char charToCheck = domain.charAt(i);
            if (!(Character.isLetterOrDigit(charToCheck) || charToCheck == '-' || charToCheck == '.')) {
                return false;
            }
        }
        return true;
    }

    private boolean validateUpperDomain(String email) {
        for (String topLevelDomain : validTopLevelDomains) {
            if (email.endsWith(topLevelDomain)) {
                return true;
            }
        }
        return false;
    }
}
