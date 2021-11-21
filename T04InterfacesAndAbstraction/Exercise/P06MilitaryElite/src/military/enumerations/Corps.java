package military.enumerations;

import java.util.Locale;

public enum Corps {
    AIRFORCES,
    MARINES;

    @Override
    public String toString() {
        return String.format("%c%s", this.name().toUpperCase(Locale.ROOT).charAt(0), this.name().substring(1).toLowerCase());
    }
}
