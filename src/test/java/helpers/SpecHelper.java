package helpers;

import config.Project;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api.endpoints.AuthUrls.SIGN_UP;

public class SpecHelper {

    private static final String BASE_URI = Project.config.baseApiUrl();

    public static RequestSpecification getRequestSpec(String sessionId) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addCookie("sessionId", sessionId)
                .setContentType(ContentType.JSON)
                .log(LogDetail.URI)
                .build();
    }

    public static RequestSpecification getRequestSpecWithoutBody(String sessionId) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addCookie("sessionId", sessionId)
                .log(LogDetail.URI)
                .build();
    }

    public static RequestSpecification getRequestSpecWithoutAuthAndBody() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .log(LogDetail.URI)
                .build();
    }

    public static RequestSpecification getRequestRegistrationSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("X-Auth-Token", Project.config.apiToken())
                .addHeader("Referer", Project.config.baseUrl() + SIGN_UP.getUrl())
                .log(LogDetail.URI)
                .build();
    }

    public static ResponseSpecification getResponseSpec(int httpStatus) {
        return new ResponseSpecBuilder()
                .log(LogDetail.STATUS)
                .expectStatusCode(httpStatus)
                .build();
    }
}
