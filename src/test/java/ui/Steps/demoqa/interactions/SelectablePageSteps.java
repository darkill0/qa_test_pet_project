package ui.Steps.demoqa.interactions;

import io.qameta.allure.Step;
import ui.pages.demqa.interactions.SelectablePage;

public class SelectablePageSteps {
    private final SelectablePage selectablePage = new SelectablePage();

    @Step("Открыть сайт страницу")
    public void openSitePage(){
        selectablePage.openSitePage();
    }

    @Step("Тестирование list select")
    public void shouldSelectList(){
        selectablePage.checkSelectList();
    }

    @Step("Тестирование grid select")
    public void shouldSelectGrid(){
        selectablePage.checkSelectGrid();
    }
}
