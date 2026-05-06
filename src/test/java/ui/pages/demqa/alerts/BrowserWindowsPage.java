package ui.pages.demqa.alerts;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.awt.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BrowserWindowsPage extends BasePage {
    private final String URL = "https://demoqa.com/browser-windows";
    private final SelenideElement newTabBtn = $x("//button[@id='tabButton']");
    private final SelenideElement newWindowBtn = $x("//button[@id='windowButton']");
    private final SelenideElement newWindowWithMessageBtn = $x("//button[@id='messageWindowButton']");

    public void openPage(){
        openUrl(URL);
    }

    public void shouldOpenNewTab(){
        newTabBtn.click();
        Wait().until(d -> d.getWindowHandles().size() > 1);
        switchTo().window(1);
        $x("//body").shouldHave(text("This is a sample page"));
        closeWindow();
        switchTo().window(0);
    }

    public void shouldOpenNewWindow(){
        newWindowBtn.click();
        Wait().until(d -> d.getWindowHandles().size() > 1);
        switchTo().window(1);
        $x("//body").shouldHave(text("This is a sample page"));
        closeWindow();
        switchTo().window(0);
    }

    public void shouldOpenNewWindowWithMessage(){
        newWindowWithMessageBtn.click();
        Wait().until(d -> d.getWindowHandles().size() > 1);
        switchTo().window(1);
        $(byText("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        closeWindow();
        switchTo().window(0);
    }
}
