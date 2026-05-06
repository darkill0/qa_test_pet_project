package ui.Steps.demoqa.alerts;

import io.qameta.allure.Step;
import ui.pages.demqa.alerts.NestedFramesPage;

public class NestedFramesSteps {
    private final NestedFramesPage nestedFramesPage = new NestedFramesPage();

    @Step("Открытие страницы сайта")
    public void openNestedFramesPage(){
        nestedFramesPage.openSitePage();
    }

    @Step("Переход к вложенному frame")
    public void shouldSwitchToChildFrame(){
        nestedFramesPage.shouldSwitchToChildFrame();
    }
}
