package api.endpoints;

import lombok.Getter;

public enum UsersUrls {
    ADD_CONTACT("/users/%s/contacts"),
    EDIT_CONTACT("/users/%s/contacts/%s");

    @Getter
    private final String url;

    UsersUrls(String url) {
        this.url = url;
    }
}
