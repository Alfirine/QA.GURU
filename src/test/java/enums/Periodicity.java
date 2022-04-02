package enums;

public enum Periodicity {
    ENDLESS, END;

    public String toApi() {
        return name().toLowerCase();
    }
}
