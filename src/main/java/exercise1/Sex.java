package exercise1;

import java.util.Locale;

public enum Sex {
    FEMALE,
    MALE;

    public static Sex decodeSex(String sex) {
        switch (sex.toLowerCase(Locale.ROOT)) {
            case "c" -> {
                return FEMALE;
            }
            case "s" -> {
                return MALE;
            }
            default -> {
                throw new IllegalArgumentException("Nie rozpoznano płci!");
            }
        }
    }

}
