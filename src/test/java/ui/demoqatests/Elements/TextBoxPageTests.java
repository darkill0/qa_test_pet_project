package ui.demoqatests.Elements;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.Elements.TextBoxSteps;

@Tag("textboxpage_test")
@DisplayName("Тестирование страницы с textbox")
public class TextBoxPageTests {

    private final TextBoxSteps textBoxSteps = new TextBoxSteps();

    @Tag("smoke_test")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тестирование что данные при вводе в поля совпадают")
    @Owner("Ilya Koltsov")
    @Feature("Тестирование ввода данных в поля")
    @Test
    public void shouldContainsAllInputData(){
        textBoxSteps.openTextBoxPage();
        textBoxSteps.inputData();
        textBoxSteps.checkInputDataEqualOutputData();
    }

    @Tag("smoke_test")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тестирование неверного email при вводе")
    @Owner("Ilya Koltsov")
    @Feature("Тестирование неверного email при вводе")
    @Test
    public void shouldHaveErrorLabelEmail(){
        textBoxSteps.openTextBoxPage();
        textBoxSteps.checkShouldHaveErrorLabelForEmail();
    }
}
