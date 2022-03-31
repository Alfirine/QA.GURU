package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Базовый класс, описывающий любой тест.
 */
public abstract class BaseTest {

    /**
     * Метод, выполняюшщийся перед каждый тестом (@Test) в сьюте.
     * Инициализирует веб-драйвер, добавляет слушатель AllureSelenide с целью логирования действий Selenide'а, логирует имя теста.
     */
    @BeforeEach
    public void beforeTest() {
        DriverSettings.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false));
    }

    /**
     * Метод, выполняющийся после каждого теста (@Test) в сьюте.
     * Закрывает браузер, логирует имя выполнившегося теста.
     */
    @AfterEach()
    public void afterTest() {
        Selenide.closeWebDriver();
    }

}
