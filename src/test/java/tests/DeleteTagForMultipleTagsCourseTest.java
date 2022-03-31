package tests;

import api.UsersApi;
import groovyjarjarantlr4.v4.runtime.misc.MultiMap;
import helpers.CourseHelper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import models.User;
import models.courseSettings.CourseData;
import models.users.Contacts;
import pages.CourseEditorPage;
import pages.SignInPage;
import pages.blocks.AutoAssignSettingsModal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import testdata.course.CourseProvider;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static testdata.UserProvider.getNewStudent;
import static testdata.UserProvider.getNewUser;

@Tags({@Tag("Box"), @Tag("Regress"), @Tag("Independent")})
public class DeleteTagForMultipleTagsCourseTest extends BaseTest {

    private final String tag1 = "tag1";
    private User admin;
    private User student;
    private String courseUrl;
    private String journalUrl;
    private Contacts contactStudent;
    private final MultiMap<String, String> tags = new MultiMap<>();
    private final MultiMap<String, String> tag = new MultiMap<>();

    @BeforeEach
    public void setUp() {
        admin = getNewUser();
        student = getNewStudent();

        tag.put("tags[]", List.of(tag1));
        String tag2 = "tag2";
        tags.put("tags[]", List.of(tag1, tag2));

        contactStudent = UsersApi.addContacts(admin, student, tags);
        String tag1Id = contactStudent.getTags().get(0).getId();
        String tag2Id = contactStudent.getTags().get(1).getId();

        CourseData courseData = CourseProvider.createCourse(admin).getCourseWithTags(List.of(tag1Id, tag2Id));
        courseUrl = CourseHelper.getCourseUrl(courseData);
        journalUrl = CourseHelper.getJournalUrl(courseData);
    }

    @Test
    @AllureId("639")
    @Epic("Автоназначение курса по тегам")
    public void deleteOneOfTwoTagsInCourse() {
        SignInPage.login(admin);
        open(courseUrl);
        CourseEditorPage.clickAutoAssignSettingsButton();
        AutoAssignSettingsModal.searchTagByName(tag1);
        AutoAssignSettingsModal.selectFirstTag();
        AutoAssignSettingsModal.clickSaveButton();
        AutoAssignSettingsModal.clickConfirmButton();
        CourseEditorPage.clickButtonApplySetting();
        CourseEditorPage.clickJournalTab();

        CourseEditorPage.checkNumberOfStudentsInList(1);
        CourseEditorPage.checkRegisteredStudentInJournalIsVisible(student);
    }

    @Test
    @AllureId("638")
    @Epic("Автоназначение курса по тегам")
    public void deleteOneOfTwoTagsFromStudent() {
        UsersApi.editContacts(admin, contactStudent, tag);

        SignInPage.login(admin);
        open(journalUrl);
        CourseEditorPage.checkNumberOfStudentsInList(1);
        CourseEditorPage.checkRegisteredStudentInJournalIsVisible(student);
    }
}
