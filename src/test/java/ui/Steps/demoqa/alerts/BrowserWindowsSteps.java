package ui.Steps.demoqa.alerts;

import io.qameta.allure.Step;
import ui.pages.demqa.alerts.BrowserWindowsPage;

public class BrowserWindowsSteps {
    private final BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();

    @Step("Открытие страницы сайта")
    public void openSitePage(){
        browserWindowsPage.openPage();
    }

    @Step("открытие новой вкладки")
    public void clickNewTabBtnAndCheckThatTheTabOpen(){
        browserWindowsPage.shouldOpenNewTab();
    }

    @Step("открытие нового окна")
    public void clickNewWindowBtnAndCheckThatTheWindowOpen(){
        browserWindowsPage.shouldOpenNewWindow();
    }

    @Step("открытие нового окна и проверка содержания ")
    public void clickNewWindowWithMessageBtnAndCheckThatTheWindowOpenWithMessage(){
        browserWindowsPage.shouldOpenNewWindowWithMessage();
    }
}
