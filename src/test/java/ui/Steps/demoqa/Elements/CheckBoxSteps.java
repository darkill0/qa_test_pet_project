package ui.Steps.demoqa.Elements;

import io.qameta.allure.Step;
import ui.pages.demqa.Elements.DemoCheckBoxPage;

public class CheckBoxSteps {

    private final DemoCheckBoxPage checkBoxPage = new DemoCheckBoxPage();
    @Step("Открытие страницы DemoQa с CheckBox")
    public void openCheckBoxPage(){
        checkBoxPage.openCheckBoxUrl();
    }

    @Step("Получение всех элементов в списке")
    public void printTreeLeafElements(){
        checkBoxPage.printAllLeafElements();
    }


}
