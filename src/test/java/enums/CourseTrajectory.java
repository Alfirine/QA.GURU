package enums;

public enum CourseTrajectory {
    CLOSE, OPEN;

    public String toApi() {
        return name().toLowerCase();
    }
}
