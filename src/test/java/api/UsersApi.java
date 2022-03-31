package api;

import groovyjarjarantlr4.v4.runtime.misc.MultiMap;
import helpers.SpecHelper;
import models.User;
import models.users.Contacts;

import static api.endpoints.UsersUrls.ADD_CONTACT;
import static api.endpoints.UsersUrls.EDIT_CONTACT;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class UsersApi {

    public static Contacts addContacts(User createUser, User addingUser, MultiMap<String, String> tags) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutBody(createUser.getSessionId()))
                .formParam("name", addingUser.getFirstName())
                .formParam("secondName", addingUser.getLastName())
                .formParam("position", addingUser.getLastName())
                .formParam("company", addingUser.getCompany())
                .formParams(tags)
                .formParam("email", addingUser.getEmail())
                .formParam("phoneMain", addingUser.getPhone())
                .post(String.format(ADD_CONTACT.getUrl(), createUser.getId()))
                .then()
                .spec(SpecHelper.getResponseSpec(SC_CREATED))
                .extract()
                .as(Contacts.class);
    }

    public static Contacts editContacts(User createUser, Contacts editingUser, MultiMap<String, String> tags) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutBody(createUser.getSessionId()))
                .formParam("name", editingUser.getName())
                .formParam("secondName", editingUser.getSecondName())
                .formParam("position", editingUser.getPosition())
                .formParam("company", editingUser.getCompany())
                .formParams(tags)
                .formParam("email", editingUser.getEmail())
                .formParam("phoneMain", editingUser.getPhoneMain())
                .put(String.format(EDIT_CONTACT.getUrl(), createUser.getId(), editingUser.getId()))
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(Contacts.class);
    }
}
