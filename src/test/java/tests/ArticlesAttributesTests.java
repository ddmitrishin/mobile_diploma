package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.back;

@Feature("Articles Attributes")
public class ArticlesAttributesTests extends TestBase {

    @Test
    @DisplayName("Compare date with actual day")
    void selectedArticleTodayTest() {
        back();
        mainPage.compareDayWithAcualDay();
    }
}
