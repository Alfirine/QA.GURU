package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static enums.localization.Course.SIGN_UP_TEXT;
import static java.lang.String.format;

public class CoursesPage extends BasePage {

    private static final SelenideElement
            courseRoot = $("[class*='CourseInfo__root']"),
            signUpCourseBtn = $x("//div[contains(@class, 'CourseInfoHeader__buttonGroup')] //button[contains(@class, 'CourseInfoHeader__actionButton')]//div[text()='" + SIGN_UP_TEXT.getValue() + "']"),
            emailForm = $("#email"),
            passwordForm = $("#password"),
            nameForm = $("#name"),
            secondNameForm = $("#secondName"),
            popupTitle = $("[class^='AccountModal__title']"),
            popupDescription = $("[class^='AccountModal__description']"),
            startCoursePopupBtn = $("[class*='AccountModal__confirmButton'] [class^='Button__content']"),
            courseDatesBtn = $("[class^='select-field-arrow']"),
            courseDatesOpenList = $("[class^='CourseInfoHeader__groupList'] .is-open");
    private static final String
            itemCourseDatesList = "[class^='dropdown-menu select-field-dropdown left'] li:nth-child(%s)";

    @Step("Открываем страницу")
    public static void openPage(Integer courseId) {
        open("/course-info/" + courseId);
    }

    @Step("Проверяем, что страница курса открыта")
    public static void checkCourseIsOpen() {
        courseRoot.shouldBe(visible);
    }

    @Step("Вводим \"Имя\"")
    public static void setName(String name) {
        nameForm.shouldBe(visible).setValue(name);
    }

    @Step("Вводим \"Фамилию\"")
    public static void setSecondName(String secondName) {
        secondNameForm.shouldBe(visible).setValue(secondName);
    }

    @Step("Вводим \"Email\"")
    public static void setEmail(String email) {
        emailForm.shouldBe(visible).setValue(email);
    }

    @Step("Вводим \"Пароль\"")
    public static void setPassword(String password) {
        passwordForm.shouldBe(visible).setValue(password);
    }

    @Step("Нажимаем кнопку \"Записаться\" на лендинге курса")
    public static void clickButtonSignUpCourse() {
        signUpCourseBtn.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку \"Начать\" курс в попапе на лендинге курса")
    public static void clickButtonStartCoursePopup() {
        startCoursePopupBtn.click();
    }

    @Step("Проверяем текст заголовка в попапе")
    public static void checkTitlePopup(String title) {
        popupTitle.shouldHave(text(title));
    }

    @Step("Проверяем текст в попапе")
    public static void checkDescriptionPopup(String title) {
        popupDescription.shouldHave(text(title));
    }

    @Step("Развернуть выпадающий список с датами на лендинге курса")
    public static void openMenuCourseData() {
        courseDatesBtn.shouldBe(visible).click();
        courseDatesOpenList.shouldBe(visible);
    }

    @Step("Выбрать элемент в выпадающем списке с датами на лендинге курса по порядковому номеру")
    public static void clickItemInCourseDataList(int itemNumber) {
        $(format(itemCourseDatesList, itemNumber)).shouldBe(visible).click();
        courseDatesOpenList.shouldNotBe(visible);
    }
}