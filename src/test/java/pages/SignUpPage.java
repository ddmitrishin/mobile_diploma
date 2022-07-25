package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String password = faker.number().digits(9);

    SelenideElement nameInputField = $(AppiumBy.xpath("//android.widget.EditText[@text='Username']"));
    SelenideElement passwordInputField = $(AppiumBy.xpath("//android.widget.EditText[@text='Password']"));
    SelenideElement confirmPasswordInputField = $(AppiumBy.xpath("//android.widget.EditText[@text='Repeat password']"));
    SelenideElement submitButton = $(AppiumBy.id("org.wikipedia.alpha:id/create_account_submit_button"));
    SelenideElement continueWithoutEmailButton = $(AppiumBy.id("android:id/button1"));
    SelenideElement contentCaptcha = $(AppiumBy.id("org.wikipedia.alpha:id/request_account_text"));

    public void fillNameInputField(){
        nameInputField.sendKeys(name);
    }

    public void fillPasswordInputField(){
        passwordInputField.sendKeys(password);
    }

    public void confirmPassword(){
        confirmPasswordInputField.sendKeys(password);
    }

    public void pressNextButton(){
        submitButton.click();
    }

    public void pressContinueWithoutEmailButton(){
        continueWithoutEmailButton.click();
    }

    public void checkCaptchaContent(){
        contentCaptcha.shouldHave(Condition.text("Can't see the image? Request an account"));
    }
}
