package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QualificationPage extends BasePage {

    private static final SelenideElement
            qualificationCardCorporate = $("[data-id='corporate']"),
            qualificationCardOnboarding = $("[data-id='onboarding']"),
            qualificationCardPer10 = $("[data-id='per10']");

    @Step("Открываем страницу")
    public static void openPage() {
        open("/qualification");
    }

    @Step("Нажать кнопку 'Буду обучать сотрудников компании'")
    public static void clickQualificationCardCorporate() {
        qualificationCardCorporate.shouldBe(visible).click();
    }

    @Step("Нажать кнопку 'Адаптация новых сотрудников'")
    public static void clickQualificationCardOnboarding() {
        qualificationCardOnboarding.shouldBe(visible).click();
    }

    @Step("Нажать кнопку '1-10'")
    public static void clickQualificationCardPer10() {
        qualificationCardPer10.shouldBe(visible).click();
    }
}
