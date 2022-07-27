package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackKeys;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static BrowserstackKeys conf = ConfigFactory.create(BrowserstackKeys.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", conf.username());
        mutableCapabilities.setCapability("browserstack.key", conf.accessKey());

        mutableCapabilities.setCapability("app", conf.app());

        mutableCapabilities.setCapability("device", conf.device());
        mutableCapabilities.setCapability("os_version", conf.osVersion());

        mutableCapabilities.setCapability("project", conf.project());
        mutableCapabilities.setCapability("build", conf.build());
        mutableCapabilities.setCapability("name", conf.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    private URL getBrowserstackUrl() {
        try {
            return new URL(conf.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
