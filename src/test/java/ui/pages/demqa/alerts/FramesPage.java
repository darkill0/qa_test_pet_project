package ui.pages.demqa.alerts;

import com.codeborne.selenide.Selenide;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class FramesPage extends BasePage {
    private final String URL = "https://demoqa.com/frames";

    public void openSitePage(){
        openUrl(URL);
    }

    public void shouldSwitchToFirstFrame(){
        switchTo().frame("frame1");
        $x("//h1[@id='sampleHeading']").shouldHave(text("This is a sample page"));
        switchTo().defaultContent();
    }

    public void shouldSwitchToSecondFrame(){
        switchTo().frame("frame2");
        $x("//h1[@id='sampleHeading']").shouldHave(text("This is a sample page"));
        switchTo().defaultContent();
    }
}
