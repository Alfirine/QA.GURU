package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})

public interface ProjectConfig extends Config {

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("prod")
    String environment();

    @DefaultValue("%s@qa-mail.webinar.ru")
    String emailTemplate();

    @DefaultValue("RU")
    String language();

    @DefaultValue("normal")
    String pageLoadStrategy();

    @DefaultValue("99.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("")
    String remoteDriverUrl();

    @DefaultValue("https://events.webinar.ru")
    String baseUrl();

    @DefaultValue("https://events.webinar.ru/api")
    String baseApiUrl();

    @DefaultValue("")
    String apiToken();

    @DefaultValue("15000")
    String timeoutElementWait();

    @DefaultValue("15000")
    String timeoutPageOpen();
}