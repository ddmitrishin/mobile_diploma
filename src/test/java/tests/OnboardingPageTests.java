package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Onboarding Page")
public class OnboardingPageTests extends TestBase {

    @Test
    @DisplayName("Check Onboarding content")
    void checkOnboardingContentTest() {
        step("Verified first page", () ->
                onboardingPage.checkFirstPageContent());
        step("Verified second page", () -> {
            onboardingPage.goToSecondPage();
            onboardingPage.checkSecondPageContent();
        });
        step("Verified third page", () -> {
            onboardingPage.goToThirdPage();
            onboardingPage.checkThirdPageContent();
        });
        step("Verified fourth page", () -> {
            onboardingPage.goToFourthPage();
            onboardingPage.checkFourthPageContent();
        });
    }
}
