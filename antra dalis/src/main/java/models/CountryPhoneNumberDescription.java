package models;

import java.util.List;

public class CountryPhoneNumberDescription {

    private String englishName;
    private String prefix;
    private int length;

    public CountryPhoneNumberDescription(String englishName, String prefix, int length) {
        this.englishName = englishName;
        this.prefix = prefix;
        this.length = length;
    }

    public static List<CountryPhoneNumberDescription> getDemoList() {
        return List.of(
                new CountryPhoneNumberDescription("Estonia", "+372", 11),
                new CountryPhoneNumberDescription("Poland", "+48", 10),
                new CountryPhoneNumberDescription("Germany", "+49", 13),
                new CountryPhoneNumberDescription("Ghana", "+233", 12));
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getLength() {
        return length;
    }
}
