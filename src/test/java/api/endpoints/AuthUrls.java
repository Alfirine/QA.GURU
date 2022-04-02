package api.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AuthUrls {
    LOGIN("/login"),
    SIGN_UP("/signup"),
    REGISTRATION("/user"),
    COURSES_LOGIN("/courses/login");

    private final String url;
}
