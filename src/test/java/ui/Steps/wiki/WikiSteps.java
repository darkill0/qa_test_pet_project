package ui.Steps.wiki;

import io.qameta.allure.Step;
import ui.pages.wiki.WikiPage;

public class WikiSteps {

    private final WikiPage wikiPage = new WikiPage();

    @Step("открыть страницу Wiki")
    public WikiSteps open(String url)
    {
        wikiPage.open(url);
        return this;
    }

    @Step("Проверка результатов {text}")
    public WikiSteps verifyText(String text){
        wikiPage.checkResult(text);
        return this;
    }
}
