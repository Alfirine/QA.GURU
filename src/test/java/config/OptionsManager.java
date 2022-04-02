package config;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

    /**
     * Создание экземпляра ChromeOptions
     */
    public static ChromeOptions getChromeOptions() {
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
    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--kiosk");
        firefoxOptions.addArguments("-no-remote");
        return firefoxOptions;
    }
}
