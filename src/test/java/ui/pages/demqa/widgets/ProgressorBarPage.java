package ui.pages.demqa.widgets;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProgressorBarPage extends BasePage {
    private final String URL = "https://demoqa.com/progress-bar";
    private final SelenideElement btn = $("#startStopButton");

    public void openSitePage(){
        openUrl(URL);
    }

    public void startProgressorBar(){
        btn.click();
        $("[role='progressbar']").shouldHave(attribute("aria-valuenow", "100"), Duration.ofSeconds(17)).shouldHave(text("100%"));

    }

    public void resetProgressorBar(){
        btn.click();


        $("[role='progressbar']")
                .shouldHave(attribute("aria-valuenow", "100"), Duration.ofSeconds(17))
                .shouldHave(text("100%"));

        $("#resetButton").click();

        $("[role='progressbar']")
                .shouldHave(attribute("aria-valuenow", "0"), Duration.ofSeconds(10))
                .shouldHave(text("0%"));
    }
}
