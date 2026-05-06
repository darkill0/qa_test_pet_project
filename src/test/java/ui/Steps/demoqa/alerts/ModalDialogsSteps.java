package ui.Steps.demoqa.alerts;

import io.qameta.allure.Step;
import ui.pages.demqa.alerts.ModalDialogsPage;

public class ModalDialogsSteps {
    private final ModalDialogsPage modalDialogsPage = new ModalDialogsPage();

    @Step("Открытие страницы сайта")
    public void openModalDialogsPage(){
        modalDialogsPage.openSitePage();
    }

    @Step("Открытие и проверка маленького dialog modal")
    public void shouldOpenSmallDialog(){
        modalDialogsPage.shouldSmallModalDialog();
    }

    @Step("Открытие и проверка large dialog modal")
    public void shouldOpenLargeDialog(){
        modalDialogsPage.shouldLargeModalDialog();
    }
}
