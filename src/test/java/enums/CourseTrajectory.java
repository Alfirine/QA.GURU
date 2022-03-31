package enums;

public enum CourseTrajectory {
    CLOSE, OPEN;

    public String getApiValue() {
        return name().toLowerCase();
    }
}
