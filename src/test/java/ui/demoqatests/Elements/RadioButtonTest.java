package ui.demoqatests.Elements;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.Elements.RadioButtonSteps;

@Tag("radiobutton_ui_test")
@DisplayName("Тестирование страницы с radio кнопки")
public class RadioButtonTest {

    private final RadioButtonSteps radioButtonSteps = new RadioButtonSteps();

    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("тестирование кнопки yes")
    @Feature("тестирование кнопки yes")
    @Description("Тестирование нажатие кнопки yes")
    @Test
    public void checkClickYesButton(){
        radioButtonSteps.openPage();
        radioButtonSteps.shouldSuccessClickButtonYes();
    }

    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("тестирование кнопки Impressive")
    @Feature("тестирование кнопки Impressive")
    @Description("Тестирование нажатие кнопки Impressive")
    @Test
    public void checkClickImpressiveButton(){
        radioButtonSteps.openPage();
        radioButtonSteps.shouldSuccessClickButtonImpressive();
    }

}
