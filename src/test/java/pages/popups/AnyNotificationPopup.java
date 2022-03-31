package pages.popups;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnyNotificationPopup {

    private static final SelenideElement
            mainElement = $("[class^='Notification__close'] button");

    @Step("Нажимаем кнопку закрытия любой нотификации")
    public void closeAnyNotification() {
        mainElement.shouldBe(visible).click();
    }
}
