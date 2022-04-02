package config;

public class SelenideManager {

    public static void selenideConfiguration() {
        com.codeborne.selenide.Configuration.timeout = Long.parseLong(Project.config.timeoutElementWait());
        com.codeborne.selenide.Configuration.pageLoadTimeout = Long.parseLong(Project.config.timeoutPageOpen());
        com.codeborne.selenide.Configuration.pageLoadStrategy = Project.config.pageLoadStrategy();
        com.codeborne.selenide.Configuration.browser = Project.config.browser();
        com.codeborne.selenide.Configuration.baseUrl = Project.config.baseUrl();
        com.codeborne.selenide.Configuration.browserSize = Project.config.browserSize();
    }
}
