package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static helpers.TimeGenerateHelper.getMoscowTime;

public class DriverSettings {

    /**
     * Конфигурация веб-драйвера
     */
    public static void configure() {
        switch (Project.config.browser()) {
            case "chrome":
                ChromeOptions chromeOptions = getChromeOptions();
                if (Project.isRemoteWebDriver()) {
                    chromeOptions.setCapability("enableVNC", true);
                    chromeOptions.setCapability("name", "Создатель: " + System.getProperty("user.name") + ", запуск в " + getMoscowTime());
                    chromeOptions.setCapability("env", new String[]{"LANG=ru_RU.UTF-8", "LANGUAGE=ru:en", "LC_ALL=ru_RU.UTF-8"});
                    Configuration.remote = Project.config.remoteDriverUrl();
                }
                chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                Configuration.browserCapabilities = chromeOptions;
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = getFirefoxOptions();
                if (Project.isRemoteWebDriver()) {
                    firefoxOptions.setCapability("enableVNC", true);
                    firefoxOptions.setCapability("name", "Создатель: " + System.getProperty("user.name") + ", запуск в " + getMoscowTime());
                    firefoxOptions.setCapability("env", new String[]{"LANG=ru_RU.UTF-8", "LANGUAGE=ru:en", "LC_ALL=ru_RU.UTF-8"});
                    Configuration.remote = Project.config.remoteDriverUrl();
                }
                firefoxOptions.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                Configuration.browserCapabilities = firefoxOptions;
                break;
        }
        selenideConfiguration();
    }

    /**
     * Создание экземпляра ChromeOptions
     */
    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-w3c");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--use-fake-device-for-media-stream");
        chromeOptions.addArguments("--use-fake-ui-for-media-stream");
        chromeOptions.addArguments("--incognito");
        return chromeOptions;
    }

    /**
     * Создание экземпляра FirefoxOptions
     */
    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--kiosk");
        firefoxOptions.addArguments("-no-remote");
        return firefoxOptions;
    }

    private static void selenideConfiguration() {
        com.codeborne.selenide.Configuration.timeout = Long.parseLong(Project.config.timeoutElementWait());
        com.codeborne.selenide.Configuration.pageLoadTimeout = Long.parseLong(Project.config.timeoutPageOpen());
        com.codeborne.selenide.Configuration.pageLoadStrategy = Project.config.pageLoadStrategy();
        com.codeborne.selenide.Configuration.browser = Project.config.browser();
        com.codeborne.selenide.Configuration.baseUrl = Project.config.baseUrl();
        com.codeborne.selenide.Configuration.browserSize = Project.config.browserSize();
    }
}
