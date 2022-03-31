package api;

import helpers.SpecHelper;
import io.restassured.common.mapper.TypeRef;
import models.User;
import models.login.Login;
import org.apache.http.HttpStatus;

import static api.endpoints.AuthUrls.LOGIN;
import static io.restassured.RestAssured.given;

public class LoginApi {

    public static String getSessionId(User user) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutAuthAndBody())
                .when()
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .post(LOGIN.getUrl())
                .then()
                .spec(SpecHelper.getResponseSpec(HttpStatus.SC_OK))
                .extract()
                .cookie("sessionId");
    }

    public static Login login(String sessionId) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutBody(sessionId))
                .when()
                .get(LOGIN.getUrl())
                .then()
                .spec(SpecHelper.getResponseSpec(HttpStatus.SC_OK))
                .extract()
                .as(new TypeRef<>() {});
    }
}
