package ui.Steps.demoqa.Elements;

import io.qameta.allure.Step;
import ui.pages.demqa.Elements.RadioButtonsPage;

public class RadioButtonSteps {
    private final RadioButtonsPage radioButtonsPage = new RadioButtonsPage();

    @Step("Открытие страницы")
    public void openPage(){
        radioButtonsPage.openRadioButtonPage();
    }

    @Step("Нажатие кнопки Yes")
    public void shouldSuccessClickButtonYes(){

        radioButtonsPage.clickYesButtonAndCheckSelectedText();
    }

    @Step("Нажатие кнопки Impressive")
    public void shouldSuccessClickButtonImpressive(){
        radioButtonsPage.clickImpressiveButtonAndCheckSelectedText();
    }
}
