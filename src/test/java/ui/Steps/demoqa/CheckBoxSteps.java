package ui.Steps.demoqa;

import io.qameta.allure.Step;
import ui.pages.demqa.DemoCheckBoxPage;

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
