package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RibbonPage extends BasePage {

    private static final SelenideElement
            createCourseBtn = $("div[class^='CreateCourseCard__content']"),
            createNewCourseBtn = $("[class^='OptionCard__root']:nth-child(1)"),
            CreateTemplateCourseBtn = $("[class^='OptionCard__root']:nth-child(2)"),
            templateEmployeeAdaptationCourseBtn = $("[class^='TemplateCard__root']:nth-child(2)"),
            useTemplateBtn = $("[class*='TemplatePage__useTemplateButton']"),
            qualificationSkipHints = $("[class^='btn-link OnboardingOfferScreen']");

    @Step("Открываем страницу")
    public static void openPage() {
        open("/courses");
    }

    @Step("Кликаем на кнопку \"Пропустить\" в квалификации")
    public static void clickQualifySkipHints() {
        qualificationSkipHints.shouldBe(visible).click();
    }

    @Step("Нажать кнопку 'Создать курс'")
    public static void clickCreateCourse() {
        createCourseBtn.scrollTo().click();
    }

    @Step("Нажать кнопку 'Создать новый курс'")
    public static void clickCreateNewCourse() {
        createNewCourseBtn.click();
    }

    @Step("Нажать кнопку 'Выбрать шаблон'")
    public static void clickCreateTemplateCourse() {
        CreateTemplateCourseBtn.click();
    }

    @Step("Нажать кнопку 'Курс для адаптации сотрудника'")
    public static void clickTemplateEmployeeAdaptationCourse() {
        templateEmployeeAdaptationCourseBtn.click();
    }

    @Step("Нажать кнопку 'Использовать шаблон'")
    public static void clickUseTemplate() {
        useTemplateBtn.click();
    }

}