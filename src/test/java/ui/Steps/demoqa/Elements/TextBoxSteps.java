package ui.Steps.demoqa.Elements;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ui.pages.demqa.Elements.TextBoxPage;

import java.util.Map;

public class TextBoxSteps {
    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final Map<String, String> inputData = Map.of("Name", "darkil", "Email", "darkil@mail.ru",
            "Current Address", "Test address", "Permananet Address", "Test2 address");

    @Step("Открытие страницы TextBox")
    public void openTextBoxPage(){
        textBoxPage.openTextBoxPage();
    }

    @Step("Заполнение данных в TextPage")
    public void inputData(){
        textBoxPage.setInfoInTextBox(inputData.get("Name"), inputData.get("Email"), inputData.get("Current Address"), inputData.get("Permananet Address"));
    }

    @Step("Проверка что данные совпадают")
    public void checkInputDataEqualOutputData(){
        Assertions.assertEquals(inputData, textBoxPage.getDataFromOutputForm());
    }

    @Step("Проверка на ввода неверного email")
    public void checkShouldHaveErrorLabelForEmail(){
        textBoxPage.checkErrorEmailField("erroremail");
    }
}
