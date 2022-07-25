package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class MenuPage {
    SelenideElement loginJoinButton = $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_login_button"));

    public void goToLoginPage(){
        loginJoinButton.click();
    }
}
