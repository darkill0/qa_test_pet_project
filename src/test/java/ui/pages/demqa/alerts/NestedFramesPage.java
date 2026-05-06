package ui.pages.demqa.alerts;

import com.codeborne.selenide.Selenide;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NestedFramesPage extends BasePage {
    private final String URL = "https://demoqa.com/nestedframes";

    public void openSitePage(){
        openUrl(URL);
    }

    public void shouldSwitchToChildFrame(){
        switchTo().frame("frame1");
        switchTo().frame($("iframe"));
        $x("//p").shouldHave(text("Child Iframe"));
        switchTo().parentFrame();
        switchTo().defaultContent();
    }
}
