package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Check Search input")
    void searchTest() {
        back();
        step("Search BrowserStack in Wikipedia", () -> {
            mainPage.searchArticle("BrowserStack");
        });
        step("Verify results", () ->
                mainPage.checkSizeOfArticlesGreaterThan(0));
    }

    @Test
    @DisplayName("Check content")
    void openContentTest() {
        back();
        step("Search Beatles in Wikipedia", () -> {
            mainPage.searchArticle("Beatles");
        });
        step("Open content", () ->
                mainPage.openArticle());
        step("Verify title", () -> {
            mainPage.makeLayerActive();
            $(AppiumBy.xpath("//android.widget.TextView[@text='English rock band (1960–1970)']"))
                    .shouldHave(Condition.text("English rock band (1960–1970)"));
        });
    }

}
