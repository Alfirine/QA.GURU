package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static config.OptionsManager.getChromeOptions;
import static config.OptionsManager.getFirefoxOptions;
import static config.SelenideManager.selenideConfiguration;
import static helpers.TimeGenerateHelper.getMoscowTime;

public class DriverSettings {

    /**
     * Конфигурация веб-драйвера
     */
    public static void configure() {
        switch (Project.config.browser()) {
            case "chrome":
                collectOptions(getChromeOptions(), ChromeOptions.CAPABILITY);
                break;
            case "firefox":
                collectOptions(getFirefoxOptions(), FirefoxOptions.FIREFOX_OPTIONS);
                break;
        }
        selenideConfiguration();
    }

    private static void collectOptions(MutableCapabilities options, String type) {
        if (Project.isRemoteWebDriver()) {
            options.setCapability("enableVNC", true);
            options.setCapability("name", "Создатель: " + System.getProperty("user.name") + ", запуск в " + getMoscowTime());
            options.setCapability("env", new String[]{"LANG=ru_RU.UTF-8", "LANGUAGE=ru:en", "LC_ALL=ru_RU.UTF-8"});
            Configuration.remote = Project.config.remoteDriverUrl();
        }
        options.setCapability(type, options);
        Configuration.browserCapabilities = options;
    }
}
