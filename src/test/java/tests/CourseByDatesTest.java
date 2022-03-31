package tests;

import config.Project;
import helpers.CourseHelper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import models.User;
import models.courseSettings.CourseData;
import pages.CoursesPage;
import pages.LessonsPage;
import pages.SignInPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import testdata.course.CourseProvider;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static enums.localization.Course.*;
import static java.time.LocalDateTime.now;
import static testdata.UserProvider.getNewStudent;
import static testdata.UserProvider.getNewUser;

@Tags({@Tag("Box"), @Tag("Regress"), @Tag("Independent")})
public class CourseByDatesTest extends BaseTest {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale(Project.config.language()));
    private final String startDateSecondGroup = now().truncatedTo(ChronoUnit.SECONDS).plusDays(2).format(formatter);

    @BeforeEach
    public void setUp() {
        User admin = getNewUser();
        User student = getNewStudent();

        CourseData courseData = CourseProvider.createCourse(admin).getCourseWithTwoGroups();
        String courseUrl = CourseHelper.getCourseUrl(courseData);

        SignInPage.login(student);
        open(courseUrl);
    }

    @Test
    @AllureId("307")
    @Epic("Курсы по датам")
    @Description("Участник выбирает группу на текущую дату, записывается на курс, проверяет текст в модалке и открытие первого урока из курса")
    public void registrationForCourseOnCurrentDate() {
        CoursesPage.clickButtonSignUpCourse();
        CoursesPage.checkTitlePopup(SUCCESSFUL_REGISTRATION_FOR_COURSE_TEXT.getValue());
        CoursesPage.checkDescriptionPopup(COURSE_STARTED_TEXT.getValue());
        CoursesPage.clickButtonStartCoursePopup();
        LessonsPage.checkOpenLessonPage();
    }

    @Test
    @AllureId("321")
    @Epic("Курсы по датам")
    @Description("Участник выбирает группу на будущую дату, записывается на курс, проверяет текст в модалке и не доступность курса")
    public void registrationForCourseOnFutureDate() {
        CoursesPage.openMenuCourseData();
        CoursesPage.clickItemInCourseDataList(2);
        CoursesPage.clickButtonSignUpCourse();
        CoursesPage.checkTitlePopup(SUCCESSFUL_REGISTRATION_FOR_COURSE_TEXT.getValue());
        CoursesPage.checkDescriptionPopup(COURSE_WILL_START_TEXT.getValue() + " " + startDateSecondGroup);
    }
}
