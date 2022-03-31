package enums;

public enum Periodicity {
    ENDLESS, END;

    public String getApiValue() {
        return name().toLowerCase();
    }
}
