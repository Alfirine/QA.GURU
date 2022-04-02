package api;

import helpers.SpecHelper;
import io.restassured.common.mapper.TypeRef;
import models.User;
import models.courseResponse.Course;
import models.courseResponse.CourseInstance;
import models.courseSettings.CourseData;
import models.createCourse.Reminder;
import models.createPart.CreatePartData;
import models.lessons.Part;

import java.util.List;

import static api.endpoints.CourseEndpoints.*;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;

public class CourseApi {

    public static List<Reminder> getReminders(User user, int courseId) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutBody(user.getSessionId()))
                .get(format(COURSE_REMINDERS.getPath(), courseId))
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(new TypeRef<>() {});
    }

    public static CourseData courseSettings(User user, CourseData courseData) {
        return given()
                .spec(SpecHelper.getRequestSpec(user.getSessionId()))
                .when()
                .body(courseData)
                .post(COURSE_SETTING.getPath())
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(CourseData.class);
    }

    public static void publishCourse(User user, CourseData courseData) {
        given()
                .spec(SpecHelper.getRequestSpecWithoutBody(user.getSessionId()))
                .when()
                .patch(format(COURSE_PUBLISH.getPath(), courseData.getCourse().getId()))
                .then()
                .spec(SpecHelper.getResponseSpec(SC_NO_CONTENT));
    }

    public static Course getCourse(User user, int courseId) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutBody(user.getSessionId()))
                .when()
                .get(format(COURSE.getPath(), courseId))
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(Course.class);
    }

    public static List<Part> getParts(User user, CourseData courseData) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutBody(user.getSessionId()))
                .when()
                .get(format(LESSONS.getPath(), courseData.getCourse().getId()))
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(new TypeRef<>() {});
    }


    public static Part createPart(User user, CourseData courseData, CreatePartData createPartData) {
        return given()
                .spec(SpecHelper.getRequestSpec(user.getSessionId()))
                .when()
                .body(createPartData)
                .post(format(CREATE_PART.getPath(), courseData.getCourse().getId()))
                .then()
                .spec(SpecHelper.getResponseSpec(SC_OK))
                .extract()
                .as(Part.class);
    }

    public static List<CourseInstance> getCourseInstances(User user, int courseId) {
        return given()
                .spec(SpecHelper.getRequestSpecWithoutBody(user.getSessionId()))
                .when()
                .get(format(COURSE_INSTANCES.getPath(), courseId))
                .then()
                .extract()
                .as(new TypeRef<>() {});
    }
}
