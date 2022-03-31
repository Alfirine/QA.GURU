package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LessonsPage extends BasePage {

    private static final SelenideElement
            structureMenuBtn = $("[class*='leftHolder'] [class*='menuButton']");
    private static final ElementsCollection
            partsLoc = $$("[class^='CourseMenu__part']");
    private static final String
            lessonsLoc = "[class^='LineClamp__root']",
            hrefLoc = "[href='%s']";

    @Step("Открываем страницу")
    public static void openPage(Integer courseId, Integer lessonId) {
        open("/course/" + courseId + "lesson/" + lessonId);
    }

    @Step("Проверяем, что страница с уроками открыта\"")
    public static void checkOpenLessonPage() {
        $(structureMenuBtn).shouldBe(visible);
    }

    @Step("Перемещение уроков и частей")
    public static void dragAndDrop(String lessonUrlFrom, String lessonUrlTo) {
        SelenideElement from = $(String.format(hrefLoc, lessonUrlFrom));
        SelenideElement to = $(String.format(hrefLoc, lessonUrlTo));

        Actions action = new Actions(WebDriverRunner.getWebDriver());
        action.clickAndHold(from)
                .moveToElement(from.parent().$("div"))
                .moveToElement(to)
                .release()
                .build()
                .perform();
    }

    @Step("Находим часть по названию")
    public static SelenideElement getPart(String partName) {
        return partsLoc.shouldHave(sizeGreaterThan(0)).stream()
                .filter(p -> p.$("span").getText().equals(partName))
                .findFirst()
                .orElse(null);
    }

    @Step("Проверка отображения уроков в части по его названию")
    public static void checkLessonsInPart(String partName, List<String> expectedLessons) {
        List<String> actualLessons = getPart(partName)
                .$("ol")
                .$$(lessonsLoc)
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());

        assertEquals(actualLessons, expectedLessons);
    }

    @Step("Проверка отображения уроков в части по его номеру")
    public static void checkLessonsInPart(int partNumber, List<String> expectedLessons) {
        List<String> actualLessons = $$(partsLoc).get(partNumber)
                .$("ol")
                .$$(lessonsLoc)
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());

        assertEquals(actualLessons, expectedLessons);
    }
}
