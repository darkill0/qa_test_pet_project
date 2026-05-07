package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.ProgressorBarPage;

public class ProgressorBarSteps {
    private final ProgressorBarPage progressorBarPage = new ProgressorBarPage();

    @Step("Открытие страницы сайта")
    public void openSitePage(){
        progressorBarPage.openSitePage();
    }

    @Step("Start progressor bar")
    public void shouldStartProgressorBar(){
        progressorBarPage.startProgressorBar();
    }

    @Step("Reset progressor bar")
    public void shouldResetProgressorBar(){
        progressorBarPage.resetProgressorBar();
    }
}
