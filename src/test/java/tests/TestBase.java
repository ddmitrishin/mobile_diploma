package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
import pages.MenuPage;
import pages.OnboardingPage;
import pages.SignUpPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBase {
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String password = faker.number().digits(9);

    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();
    MenuPage menuPage = new MenuPage();
    SignUpPage signUpPage = new SignUpPage();

    static String deviceHost = System.getProperty("deviceHost", "local");

    @BeforeAll
    public static void setUp() {
        if (Objects.equals(deviceHost, "local")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        } else if (Objects.equals(deviceHost, "browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        if (Objects.equals(deviceHost, "browserstack")) {
            Attach.video(sessionId);
        }
    }
}
