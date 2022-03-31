package api.endpoints;

import lombok.Getter;

public enum QaFeaturesUrls {
    COMPLETE_USER_REGISTRATION("/qaFeatures/completeUserRegistration"),
    ADD_USERS_FEATURES("/qaFeatures/addUsersFeatures"),
    COMPLETE_STUDENT_REGISTRATION("/qaFeatures/completeStudentRegistration");

    @Getter
    private final String url;

    QaFeaturesUrls(String url) {
        this.url = url;
    }
}
