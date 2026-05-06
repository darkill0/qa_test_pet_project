package ui.Steps.demoqa;

import io.qameta.allure.Step;
import ui.pages.demqa.BrokenLinksPage;

public class BrokenLinksSteps {
    private final BrokenLinksPage brokenLinksPage = new BrokenLinksPage();

    @Step("открытие страницы сайта")
    public void shouldOpenPage(){
        brokenLinksPage.openPage();
    }

    @Step("тестировагние открытия валидного url сайта")
    public void shouldOpenValidLink(){
        brokenLinksPage.openValidUrl();
    }
    @Step("тестировагние открытия невалидного url сайта")
    public void shouldOpenInvalidLink(){
        brokenLinksPage.openInvalidUrl();
    }
}
