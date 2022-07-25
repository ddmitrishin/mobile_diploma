package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class OnboardingPage {
    SelenideElement pageContent = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"));
    SelenideElement secondPageButton = $(AppiumBy.xpath("//android.widget.LinearLayout[2]"));
    SelenideElement thirdPageButton = $(AppiumBy.xpath("//android.widget.LinearLayout[3]"));
    SelenideElement fourthPageButton = $(AppiumBy.xpath("//android.widget.LinearLayout[4]"));

    public void checkFirstPageContent() {
        pageContent.shouldHave(Condition.text("The Free Encyclopedia\n" +
                "…in over 300 languages"));
    }

    public void goToSecondPage() {
        secondPageButton.click();
    }

    public void checkSecondPageContent() {
        pageContent.shouldHave(Condition.text("New ways to explore"));
    }

    public void goToThirdPage() {
        thirdPageButton.click();
    }

    public void checkThirdPageContent() {
        pageContent.shouldHave(Condition.text("Reading lists with sync"));
    }

    public void goToFourthPage() {
        fourthPageButton.click();
    }

    public void checkFourthPageContent() {
        pageContent.shouldHave(Condition.text("Send anonymous data"));
    }
}
