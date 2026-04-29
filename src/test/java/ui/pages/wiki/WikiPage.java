package ui.pages.wiki;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class WikiPage extends BasePage {

    private SelenideElement historyBlock = $x("//h2[@id='History']");


    public WikiPage open(String url) {
        super.openUrl(url);
        return this;
    }

    public WikiPage checkResult(String text)
    {
        historyBlock.shouldHave(text(text));
        return this;
    }


}
