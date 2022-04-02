package tests;

import api.CourseApi;
import api.LessonApi;
import clients.CourseClient;
import com.google.common.collect.Lists;
import helpers.CourseHelper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import models.Lesson;
import models.User;
import models.courseSettings.CourseData;
import models.createLesson.CreateLesson;
import models.createPart.CreatePartData;
import models.lessons.Part;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.LessonsPage;
import pages.SignInPage;
import testdata.course.CourseDataProvider;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static enums.localization.CourseBlock.LESSON_NAME;
import static enums.localization.CourseBlock.PART_NAME;
import static testdata.UserProvider.getNewUser;

@Tags({@Tag("Box"), @Tag("Regress"), @Tag("Independent")})
public class MovingLessonsTest extends BaseTest {

    private final String partName = "Часть 2";
    private final List<String> lessonNames = List.of("1", "2", "3", "4", "5");
    private List<String> lessonUrls;
    private int coursePartId;

    private User admin;
    private CourseData courseData;

    @BeforeEach
    public void setUp() {
        admin = getNewUser();

        courseData = CourseDataProvider.getDefaultCourse(admin);

        CreatePartData createPartData = new CreatePartData(partName);
        coursePartId = CourseApi.createPart(admin, courseData, createPartData).getId();

        String lessonType = "lesson";
        lessonUrls = new ArrayList<>();
        for (String lessonName : lessonNames) {
            CreateLesson createLesson = new CreateLesson(coursePartId, lessonType, lessonName);
            Lesson lesson = LessonApi.createLesson(admin, createLesson);
            lessonUrls.add(CourseHelper.getEditLessonPath(courseData, lesson.getLessonId()));
        }
    }

    @Test
    @AllureId("143")
    @Epic("Перемещение уроков в курсе")
    public void checkingMovementOfLessonsWithinOnePart() {
        SignInPage.login(admin);
        open(lessonUrls.get(0));

        LessonsPage.dragAndDrop(lessonUrls.get(4), lessonUrls.get(0));
        LessonsPage.dragAndDrop(lessonUrls.get(3), lessonUrls.get(0));
        LessonsPage.dragAndDrop(lessonUrls.get(2), lessonUrls.get(0));
        LessonsPage.dragAndDrop(lessonUrls.get(1), lessonUrls.get(0));

        LessonsPage.checkLessonsInPart(partName, Lists.reverse(lessonNames));
    }

    @Test
    @AllureId("169")
    @Epic("Перемещение уроков в курсе")
    public void checkingMovementOfLessonsBetweenParts() {
        int firstLessonId = CourseClient.getLesson(admin, courseData, LESSON_NAME.getValue()).getId();
        String firstLessonUrl = CourseHelper.getEditLessonPath(courseData, firstLessonId);

        SignInPage.login(admin);
        open(lessonUrls.get(0));

        LessonsPage.dragAndDrop(lessonUrls.get(1), firstLessonUrl);
        LessonsPage.dragAndDrop(lessonUrls.get(3), firstLessonUrl);

        LessonsPage.checkLessonsInPart(partName, List.of(lessonNames.get(0), lessonNames.get(2), lessonNames.get(4)));
        LessonsPage.checkLessonsInPart(PART_NAME.getValue(), List.of(lessonNames.get(1), lessonNames.get(3), LESSON_NAME.getValue()));
    }

    @Test
    @AllureId("187")
    @Epic("Перемещение уроков в курсе")
    public void checkingMovementOfParts() {
        Part firstPart = CourseClient.getPart(admin, courseData, PART_NAME.getValue());
        String firstPartUrl = CourseHelper.getPartUrl(courseData, firstPart.getId());
        String secondPartUrl = CourseHelper.getPartUrl(courseData, coursePartId);

        SignInPage.login(admin);
        open(lessonUrls.get(0));

        LessonsPage.dragAndDrop(secondPartUrl, firstPartUrl);

        LessonsPage.checkLessonsInPart(0, lessonNames);
        LessonsPage.checkLessonsInPart(1, List.of(LESSON_NAME.getValue()));
    }
}
