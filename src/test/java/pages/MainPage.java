package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    DateFormat df = new SimpleDateFormat("MMMMM d", Locale.ENGLISH);
    String requiredDate = df.format(new Date());

    SelenideElement searchField = $(AppiumBy.id("org.wikipedia.alpha:id/search_container"));
    SelenideElement searchInputField = $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"));
    ElementsCollection listOfFoundElements = $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));
    SelenideElement firstElementInList = $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));
    SelenideElement menuButton = $(AppiumBy.id("org.wikipedia.alpha:id/menu_icon"));
    SelenideElement layer = $(AppiumBy.id("org.wikipedia.alpha:id/page_web_view"));
    SelenideElement dayHeaderText = $(AppiumBy.id("org.wikipedia.alpha:id/day_header_text"));

    public void searchArticle(String title) {
        searchField.click();
        searchInputField.sendKeys(title);
    }

    public void checkSizeOfArticlesGreaterThan(Integer count) {
        listOfFoundElements.shouldHave(CollectionCondition.sizeGreaterThan(count));
    }

    public void openMenu() {
        menuButton.click();
    }

    public void openArticle() {
        firstElementInList.click();
    }

    public void makeLayerActive() {
        layer.click();
    }

    public void compareDayWithAcualDay() {
        dayHeaderText.shouldHave(Condition.text(requiredDate));
    }
}
