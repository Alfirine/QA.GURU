package pages.blocks;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AutoAssignSettingsModal extends BasePage {

    private static final SelenideElement
            searchInput = $("[class^='AutoAssignSettingsModal__searchSection'] input[class^='Field__input']"),
            firstTag = $("[class^='AutoAssignSettingsModal__tagItem'] div"),
            saveButton = $("[class^='AutoAssignSettingsModal__actionsSection'] button", 1),
            confirmButton = $("[class*='AccountModal__confirmButton']");

    @Step("Поиск тега по заданному имени")
    public static void searchTagByName(String tagName) {
        searchInput.shouldBe(visible).click();
        searchInput.sendKeys(tagName);
    }

    @Step("Выбираем первый тег в списке")
    public static void selectFirstTag() {
        firstTag.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку \"Сохранить\"")
    public static void clickSaveButton() {
        saveButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку \"Подтвердить\"")
    public static void clickConfirmButton() {
        confirmButton.shouldBe(visible).click();
    }
}
