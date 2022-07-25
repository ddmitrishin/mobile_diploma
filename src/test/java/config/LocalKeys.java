package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/local.properties"})
public interface LocalKeys extends Config {
    String platformName();
    String deviceName();
    String platformVersion();
    String appPackage();
    String appActivity();
    String localUrl();
    String downloadAppUrl();
}
