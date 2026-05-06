package ui.pages.demqa.Elements;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class RadioButtonsPage extends BasePage {
    private final String URL = "https://demoqa.com/radio-button";
    private final SelenideElement yesButton = $x("//input[@id='yesRadio']");
    private final SelenideElement impressiveRadio = $x("//input[@id='impressiveRadio']");
    private final SelenideElement spanText = $x("//span[@class='text-success']");
    public void openRadioButtonPage(){
        openUrl(URL);
    }

    public void clickYesButtonAndCheckSelectedText(){
        yesButton.click();
        spanText.shouldHave(text("Yes"));

    }

    public void clickImpressiveButtonAndCheckSelectedText(){
        impressiveRadio.click();
        spanText.shouldHave(text("Impressive"));

    }


}
