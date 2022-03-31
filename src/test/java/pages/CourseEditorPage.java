package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.User;
import pages.popups.AnyNotificationPopup;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.clickViaJs;
import static com.codeborne.selenide.Selenide.*;

public class CourseEditorPage extends BasePage {

    private static final SelenideElement
            journalTab = $("div[class^='CourseInfoHeader__footer'] [href*='/journal']"),
            buttonApplySetting = $("[class^='CourseOptionsMenu__submitButton']"),
            spinnerParticipantsList = $("[class^='Spinner__spinner'][class*='Spinner__material']"),
            studentModeratorNameText = $("[class^='UserView__name']"),
            autoAssignSettingsBtn = $("[class^='AutoAssignSettings'] button");
    private static final ElementsCollection
            allStudentsInJournal = $$("[class^='ParticipantList__ul'] div [class*='ParticipantList__li']");

    @Step("Открываем страницу")
    public static void openPage(Integer courseId) {
        open("/course-info/" + courseId);
    }

    @Step("Нажимаем на вкладку \"Журнал\"")
    public static void clickJournalTab() {
        journalTab.click();
        spinnerParticipantsList.shouldNotBe(visible);
    }

    @Step("Проверяем количество студентов в журнале")
    public static void checkNumberOfStudentsInList(int expectedNumberOfModerators) {
        allStudentsInJournal.first().shouldBe(visible);
        allStudentsInJournal.shouldBe(size(expectedNumberOfModerators));
    }

    @Step("Нажимаем на кнопку \"Применить\" в редакторе курса на боковой панели настройки")
    public static void clickButtonApplySetting() {
        if (buttonApplySetting.is(visible)) {
            clickViaJs = true;
            buttonApplySetting.click();
            clickViaJs = false;
            AnyNotificationPopup anyNotificationPopup = new AnyNotificationPopup();
            anyNotificationPopup.closeAnyNotification();
        }
    }

    @Step("Проверяем, что студент отображается в журнале")
    public static void checkRegisteredStudentInJournalIsVisible(User user) {
        $(studentModeratorNameText).shouldHave(text(user.getFullName())).shouldBe(visible);
    }

    @Step("Нажать кнопку \"Назначать автоматически\"")
    public static void clickAutoAssignSettingsButton() {
        $(autoAssignSettingsBtn).shouldBe(visible).click();
    }
}
