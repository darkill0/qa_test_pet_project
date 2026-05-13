package ui.pages.demqa.Elements;

import config.ui.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicPropertiesPage extends BasePage {
    private final String URL = "https://demoqa.com/dynamic-properties";

    public void openDynamicPropsPage(){
        openUrl(URL);
    }

    public void shouldHaveClassDangerAfter5Seconds(){
        $x("//button[@id='colorChange']").shouldHave(cssClass("text-danger"), Duration.ofSeconds(6));
    }

    public void shouldVisibleButtonAfter5Seconds(){
        $x("//button[@id='visibleAfter']").should(appear, Duration.ofSeconds(10));
    }

    public void shouldHaveVisibleTextWithRandomId(){
        $(byText("This text has random Id")).shouldBe(visible);
    }


}
