package api;

import helpers.SpecHelper;
import models.User;
import models.qaFeatures.CreateUserResponse;

import static api.endpoints.QaFeaturesUrls.COMPLETE_STUDENT_REGISTRATION;
import static api.endpoints.QaFeaturesUrls.COMPLETE_USER_REGISTRATION;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;

public class QaFeaturesApi {

    public static CreateUserResponse completeUserRegistration(User user) {
        return given()
                .spec(SpecHelper.getRequestRegistrationSpec())
                .when()
                .body(user)
                .post(COMPLETE_USER_REGISTRATION.getUrl())
                .then()
                .spec(SpecHelper.getResponseSpec(SC_CREATED))
                .extract()
                .as(CreateUserResponse.class);
    }

    public static CreateUserResponse completeStudentRegistration(User user) {
        return given()
                .spec(SpecHelper.getRequestRegistrationSpec())
                .when()
                .body(user)
                .post(COMPLETE_STUDENT_REGISTRATION.getUrl())
                .then()
                .spec(SpecHelper.getResponseSpec(SC_CREATED))
                .extract()
                .as(CreateUserResponse.class);
    }
}
