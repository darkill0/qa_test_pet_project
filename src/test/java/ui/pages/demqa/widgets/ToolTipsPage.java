package ui.pages.demqa.widgets;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.interactions.Actions;

public class ToolTipsPage extends BasePage {

    private final String URL = "https://demoqa.com/tool-tips";

    public void openSitePage() {
        openUrl(URL);
    }

    private void checkTooltip(SelenideElement element,
                              String expectedText) {

        element.scrollIntoView(true);

        actions()
                .moveToElement(element)
                .pause(500)
                .perform();

        $("[role='tooltip']")
                .should(appear)
                .shouldHave(text(expectedText));
    }

    public void checkHoverToBtn() {

        checkTooltip(
                $("#toolTipButton"),
                "You hovered over the Button"
        );
    }

    public void checkHoverToTextField() {

        checkTooltip(
                $("#toolTipTextField"),
                "You hovered over the text field"
        );
    }

    public void checkHoverToTextContrary() {

        checkTooltip(
                $x("//a[text()='Contrary']"),
                "You hovered over the Contrary"
        );
    }

    public void checkHoverToTextNumber() {

        checkTooltip(
                $x("//a[text()='1.10.32']"),
                "You hovered over the 1.10.32"
        );
    }
}