package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CoursesPage;
import pages.QualificationPage;
import pages.RibbonPage;
import pages.SignInPage;

import static testdata.UserProvider.getNewUser;

@Tags({@Tag("Box"), @Tag("Regress"), @Tag("Independent")})
public class CreateCourseTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        User admin = getNewUser();

        SignInPage.login(admin);
        QualificationPage.clickQualificationCardCorporate();
        QualificationPage.clickQualificationCardOnboarding();
        QualificationPage.clickQualificationCardPer10();
        RibbonPage.clickQualifySkipHints();
    }

    @Test
    @AllureId("2208")
    @Epic("Создание курса")
    public void checkCreateNewCourse() {
        RibbonPage.clickCreateCourse();
        RibbonPage.clickCreateNewCourse();
        CoursesPage.checkCourseIsOpen();
    }

    @Test
    @AllureId("2209")
    @Epic("Создание курса")
    public void checkCreateTemplateCourse() {
        RibbonPage.clickCreateCourse();
        RibbonPage.clickCreateTemplateCourse();
        RibbonPage.clickTemplateEmployeeAdaptationCourse();
        RibbonPage.clickUseTemplate();
        CoursesPage.checkCourseIsOpen();
    }
}
