package api.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CourseInstanceUrls {
    CREATE_COURSE("/courseInstances/parts/lessons"),
    ADD_CONTACTS("/courseInstances/%s/addedContacts");

    private final String url;
}
