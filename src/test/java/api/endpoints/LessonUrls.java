package api.endpoints;

import lombok.Getter;

public enum LessonUrls {
    ADD_LESSON("/lessons");

    @Getter
    private final String url;

    LessonUrls(String url) {
        this.url = url;
    }
}
