package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    SelenideElement nameInputField = $(AppiumBy.xpath("//android.widget.EditText[@text='Username']"));
    SelenideElement passwordInputField = $(AppiumBy.xpath("//android.widget.EditText[@text='Password']"));
    SelenideElement confirmPasswordInputField = $(AppiumBy.xpath("//android.widget.EditText[@text='Repeat password']"));
    SelenideElement submitButton = $(AppiumBy.id("org.wikipedia.alpha:id/create_account_submit_button"));
    SelenideElement continueWithoutEmailButton = $(AppiumBy.id("android:id/button1"));
    SelenideElement contentCaptcha = $(AppiumBy.id("org.wikipedia.alpha:id/request_account_text"));

    public void fillNameInputField(String name) {
        nameInputField.sendKeys(name);
    }

    public void fillPasswordInputField(String password) {
        passwordInputField.sendKeys(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordInputField.sendKeys(password);
    }

    public void pressNextButton() {
        submitButton.click();
    }

    public void pressContinueWithoutEmailButton() {
        continueWithoutEmailButton.click();
    }

    public void checkCaptchaContent() {
        contentCaptcha.shouldHave(Condition.text("Can't see the image? Request an account"));
    }
}
