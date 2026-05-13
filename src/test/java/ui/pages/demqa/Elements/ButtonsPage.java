package ui.pages.demqa.Elements;


import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ButtonsPage extends BasePage {
    private final String URL = "https://demoqa.com/buttons";
    private final SelenideElement doubleClickButton = $x("//button[@id='doubleClickBtn']");
    private final SelenideElement rightClickButton = $x("//button[@id='rightClickBtn']");
    private final SelenideElement dynamicClickButton = $x("//button[text()='Click Me']");


    public void openButtonsPage(){
        openUrl(URL);
    }

    public void shouldDoubleClickButton(){

        doubleClickButton.shouldBe(visible,enabled).scrollIntoView(true).doubleClick();
        SelenideElement outputText = $x("//p[@id='doubleClickMessage']");
        outputText.shouldHave(text("You have done a double click"));

    }

    public void shouldRightClickButton(){

        rightClickButton.shouldBe(visible, enabled).scrollIntoView(true).contextClick();
        SelenideElement outputText = $x("//p[@id='rightClickMessage']");
        outputText.shouldHave(text("You have done a right click"));

    }

    public void shouldDynamicClickButton(){

        dynamicClickButton.shouldBe(visible, enabled).scrollIntoView(true).click();
        SelenideElement outputText = $x("//p[@id='dynamicClickMessage']");
        outputText.shouldHave(text("You have done a dynamic click"));

    }
}
