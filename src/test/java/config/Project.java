package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public final static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

}