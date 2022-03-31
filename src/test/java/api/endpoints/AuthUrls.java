package api.endpoints;

import lombok.Getter;

public enum AuthUrls {
    LOGIN("/login"),
    SIGN_UP("/signup"),
    REGISTRATION("/user"),
    COURSES_LOGIN("/courses/login");

    @Getter
    private final String url;

    AuthUrls(String url) {
        this.url = url;
    }
}
