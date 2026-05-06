package ui.Steps.demoqa.alerts;

import io.qameta.allure.Step;
import ui.pages.demqa.alerts.FramesPage;

public class FramesPageSteps {
    private final FramesPage framesPage = new FramesPage();

    @Step("Открытие страницы сайта")
    public void openSitePageWithFrames(){
        framesPage.openSitePage();
    }

    @Step("Проверка перехода к первому frame на странице")
    public void shouldSwitchToFirstFrame(){
        framesPage.shouldSwitchToFirstFrame();
    }

    @Step("Проверка перехода к второму frame на странице")
    public void shouldSwitchToSecondFrame(){
        framesPage.shouldSwitchToSecondFrame();
    }
}
