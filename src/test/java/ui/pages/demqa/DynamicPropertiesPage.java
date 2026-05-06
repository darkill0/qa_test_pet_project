package ui.pages.demqa;

import config.ui.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;

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
        $x("//button[@id='visibleAfter']").shouldBe(visible, Duration.ofSeconds(5));
    }

    public void shouldHaveVisibleTextWithRandomId(){
        $(byText("This text has random Id")).shouldBe(visible);
    }


}
