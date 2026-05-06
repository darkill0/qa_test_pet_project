package ui.pages.demqa.Elements;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BrokenLinksPage extends BasePage {

    private final String URL = "https://demoqa.com/broken";
    private final SelenideElement validLink = $x("//a[text()='Click Here for Valid Link']");
    private final SelenideElement invalidLink = $x("//a[text()='Click Here for Broken Link']");

    public void openPage(){
        openUrl(URL);
    }

    public void openValidUrl(){
        validLink.click();
        webdriver().shouldHave(url("https://demoqa.com/"));
        $x("//body").shouldHave(text("Elements"));
    }

    public void openInvalidUrl(){
        invalidLink.click();
        webdriver().shouldHave(url("https://the-internet.herokuapp.com/status_codes/500"));
        $x("//div[@class='example']/p").shouldHave(text("500"));
    }



}
