package api.endpoints;

import lombok.Getter;

public enum CourseInstanceUrls {
    CREATE_COURSE("/courseInstances/parts/lessons"),
    ADD_CONTACTS("/courseInstances/%s/addedContacts");

    @Getter
    private final String url;

    CourseInstanceUrls(String url) {
        this.url = url;
    }
}
