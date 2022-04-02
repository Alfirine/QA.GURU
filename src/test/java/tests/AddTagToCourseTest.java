package tests;

import api.UsersApi;
import groovyjarjarantlr4.v4.runtime.misc.MultiMap;
import helpers.CourseHelper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import models.User;
import models.courseSettings.CourseData;
import models.users.Contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CourseEditorPage;
import pages.SignInPage;
import pages.blocks.AutoAssignSettingsModal;
import testdata.course.CourseDataProvider;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static testdata.UserProvider.getNewStudent;
import static testdata.UserProvider.getNewUser;

@Tags({@Tag("Box"), @Tag("Regress"), @Tag("Independent")})
public class AddTagToCourseTest extends BaseTest {
    private final String tag1 = "tag1";
    private User admin;
    private User student1;
    private String courseUrl;
    private String journalUrl;
    private String tag1Id;
    private String tag2Id;
    private CourseData courseData;
    private final MultiMap<String, String> tag = new MultiMap<>();
    private final MultiMap<String, String> tags = new MultiMap<>();
    private final MultiMap<String, String> tagNull = new MultiMap<>();

    @BeforeEach
    public void setUp() {
        admin = getNewUser();
        student1 = getNewStudent();
        User student2 = getNewStudent();

        courseData = CourseDataProvider.getDefaultCourse(admin);
        courseUrl = CourseHelper.getCourseUrl(courseData);
        journalUrl = CourseHelper.getJournalUrl(courseData);

        tag.put("tags[]", List.of(tag1));
        String tag2 = "tag2";
        tags.put("tags[]", List.of(tag1, tag2));
        tagNull.put("tags[]", null);

        Contacts contactStudent2 = UsersApi.addContacts(admin, student2, tags);
        tag1Id = contactStudent2.getTags().get(0).getId();
        tag2Id = contactStudent2.getTags().get(1).getId();
        UsersApi.editContacts(admin, contactStudent2, tagNull);
    }

    @Test
    @AllureId("252")
    @Epic("Автоназначение курса по тегам")
    public void addTagToCourse() {
        UsersApi.addContacts(admin, student1, tag);

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
        CourseEditorPage.checkRegisteredStudentInJournalIsVisible(student1);
    }

    @Test
    @AllureId("306")
    @Epic("Автоназначение курса по тегам")
    public void addMultipleTagsToCourse() {
        UsersApi.addContacts(admin, student1, tags);
        CourseDataProvider.changeToCourseWithOneGroupWithTags(admin, courseData, List.of(tag1Id, tag2Id));

        SignInPage.login(admin);
        open(journalUrl);
        CourseEditorPage.checkNumberOfStudentsInList(1);
        CourseEditorPage.checkRegisteredStudentInJournalIsVisible(student1);
    }

    @Test
    @AllureId("324")
    @Epic("Автоназначение курса по тегам")
    public void addTagToStudent() {
        CourseDataProvider.changeToCourseWithOneGroupWithTags(admin, courseData, List.of(tag1Id));
        UsersApi.addContacts(admin, student1, tag);

        SignInPage.login(admin);
        open(journalUrl);
        CourseEditorPage.checkNumberOfStudentsInList(1);
        CourseEditorPage.checkRegisteredStudentInJournalIsVisible(student1);
    }

    @Test
    @AllureId("209")
    @Epic("Автоназначение курса по тегам")
    public void addMultipleTagsToStudent() {
        CourseDataProvider.changeToCourseWithOneGroupWithTags(admin, courseData, List.of(tag1Id, tag2Id));
        UsersApi.addContacts(admin, student1, tags);

        SignInPage.login(admin);
        open(journalUrl);
        CourseEditorPage.checkNumberOfStudentsInList(1);
        CourseEditorPage.checkRegisteredStudentInJournalIsVisible(student1);
    }
}
