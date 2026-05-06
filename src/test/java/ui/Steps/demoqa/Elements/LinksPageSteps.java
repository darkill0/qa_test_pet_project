package ui.Steps.demoqa.Elements;

import io.qameta.allure.Step;
import ui.pages.demqa.Elements.LinksPage;

public class LinksPageSteps {
    private final LinksPage linksPage = new LinksPage();

    @Step("открытие страницы сайта")
    public void openPage(){
        linksPage.openPage();
    }

    @Step("открытие страницы home сайта")
    public void shouldOpenHomeLink(){
        linksPage.openHomeLink();
    }

    @Step("открытие динамичной страницы home сайта")
    public void shouldOpenDynamicHomeLink(){
        linksPage.openDynamicHomeLink();
    }

    @Step("открытие Created страницы")
    public void shouldOpenCreatedLink(){
        linksPage.shouldContainsCreatedLinkDataApi();
    }

    @Step("открытие No Content страницы")
    public void shouldOpenNoContentLink(){
        linksPage.shouldContainsNoContentLinkDataApi();
    }

    @Step("открытие Moved страницы")
    public void shouldOpenMovedLink(){
        linksPage.shouldContainsMovedLinkDataApi();
    }

    @Step("открытие Bad Request страницы")
    public void shouldOpenBadRequestLink(){
        linksPage.shouldContainsBadRequestLinkDataApi();
    }

    @Step("открытие Unauthorized страницы")
    public void shouldOpenUnauthorizedLink(){
        linksPage.shouldContainsUnauthorizedLinkDataApi();
    }

    @Step("открытие Forbidden страницы")
    public void shouldOpenForbiddenLink(){
        linksPage.shouldContainsForbiddenLinkDataApi();
    }

    @Step("открытие Not Found страницы")
    public void shouldOpenNotFoundLink(){
        linksPage.shouldContainsInvalidUrlLinkDataApi();
    }


}
