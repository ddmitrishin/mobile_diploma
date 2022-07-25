package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class Tests extends TestBase {

    @Test
    @DisplayName("Check Search input")
    void searchTest() {
        back();
        step("Search BrowserStack in Wikipedia", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify results", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    @Disabled("Flick")
    @DisplayName("Check content")
    void openContentTest() {
        back();
        step("Search Beatles in Wikipedia", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Beatles");
        });
        step("Open content", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click());
        step("Verify title", () ->
                $(AppiumBy.id("pcs-edit-section-title-description")).shouldHave(Condition.text("English rock band (1960–1970)")));
    }

    @Test
    @DisplayName("Check Onboarding content")
    void checkOnboardingContentTest() {
        step("Verified first page", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("The Free Encyclopedia\n" +
                        "…in over 300 languages")));
        step("Verified second page", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[2]")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("New ways to explore"));
        });
        step("Verified third page", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[3]")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("Reading lists with sync"));
        });
        step("Verified fourth page", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout[4]")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("Send anonymous data"));
        });
    }
}
