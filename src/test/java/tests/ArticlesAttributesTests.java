package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.back;


public class ArticlesAttributesTests extends TestBase {

    @Test
    @DisplayName("Compare date with actual day")
    @Feature("Articles Attributes")
    void selectedArticleTodayTest() {
        back();
        mainPage.compareDayWithAcualDay();
    }
}
