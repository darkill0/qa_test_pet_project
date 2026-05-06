package ui.Steps.demoqa.Elements;

import io.qameta.allure.Step;
import ui.pages.demqa.Elements.ButtonsPage;

public class ButtonsPageSteps {
    private final ButtonsPage buttonsPage = new ButtonsPage();

    @Step("Открытие страницы")
    public void shouldOpenPage(){
        buttonsPage.openButtonsPage();
    }

    @Step("Двойной клик")
    public void shouldDoubleClick(){
        buttonsPage.shouldDoubleClickButton();
    }

    @Step("Правая кнопка клик")
    public void shouldRightClick(){
        buttonsPage.shouldRightClickButton();
    }

    @Step("Обычный  клик")
    public void shouldDynamicClick(){
        buttonsPage.shouldDynamicClickButton();
    }
}
