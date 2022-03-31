package api;

import helpers.SpecHelper;
import models.Lesson;
import models.User;
import models.createLesson.CreateLesson;

import static api.endpoints.LessonUrls.ADD_LESSON;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class LessonApi {

    public static Lesson createLesson(User user, CreateLesson createLesson) {
        return given()
                .spec(SpecHelper.getRequestSpec(user.getSessionId()))
                .when()
                .body(createLesson)
                .post(ADD_LESSON.getUrl())
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(Lesson.class);
    }
}
