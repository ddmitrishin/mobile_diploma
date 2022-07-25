package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

@Feature("Sign Up Page")
public class SignUpPageTests extends TestBase {

    @Test
    @DisplayName("Sign up")
    void signUpTest() {
        back();
        step("Open 'Menu'", () -> {
            mainPage.openMenu();
        });
        step("Press on 'Join Wikipedia' button", () ->
                menuPage.goToLoginPage());
        step("Fill fields", () -> {
            signUpPage.fillNameInputField();
            signUpPage.fillPasswordInputField();
            signUpPage.confirmPassword();
        });
        step("Press 'Next' button", () ->
                signUpPage.pressNextButton());
        step("Skip enter email", () ->
                signUpPage.pressContinueWithoutEmailButton());
        step("Verified CAPTCHA content", () ->
                signUpPage.checkCaptchaContent());
    }
}
