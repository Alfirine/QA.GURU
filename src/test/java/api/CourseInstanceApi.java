package api;

import helpers.SpecHelper;
import models.User;
import models.courseResponse.CourseResponseData;
import models.createCourse.CreateCourseData;

import static api.endpoints.CourseInstanceUrls.CREATE_COURSE;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class CourseInstanceApi {

    public static CourseResponseData createCourse(User user, CreateCourseData createCourseData) {
        return given()
                .spec(SpecHelper.getRequestSpec(user.getSessionId()))
                .body(createCourseData)
                .post(CREATE_COURSE.getUrl())
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(CourseResponseData.class);
    }
}
