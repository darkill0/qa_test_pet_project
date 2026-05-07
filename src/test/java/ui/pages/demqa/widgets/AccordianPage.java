package ui.pages.demqa.widgets;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AccordianPage extends BasePage {
    private final String URL = "https://demoqa.com/accordian";
    private final SelenideElement whereBtn = $x("//button[text()='Where does it come from?']");
    private final SelenideElement loremBtn = $x("//button[text()='What is Lorem Ipsum?']");

    public void openPage(){
        openUrl(URL);
    }

    public void clickLoremBtn(){
        whereBtn.click();
        whereBtn.shouldNotHave(cssClass("collapsed"));
        $x("//div[@class='accordion-collapse collapse show']").shouldHave(text("Contrary to popular belief, Lorem Ipsum"));

    }

    public void unclickLoremBtn(){
        whereBtn.click();
        whereBtn.click();
        whereBtn.shouldHave(cssClass("collapsed"));
    }

    public void checkCollapsedTextWhenClickSecondBtn(){
        loremBtn.shouldHave(cssClass("accordion-button"));
        whereBtn.click();
        loremBtn.shouldHave(cssClass("collapsed"));
    }
}
