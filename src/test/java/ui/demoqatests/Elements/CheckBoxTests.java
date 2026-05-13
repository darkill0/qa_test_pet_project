package ui.demoqatests.Elements;

import config.ui.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import ui.Steps.demoqa.Elements.CheckBoxSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("demo-qa-check-box-page")
@DisplayName("[UI] Провекра чекбоксов")
@Epic("Checkbox check")
public class CheckBoxTests extends BaseTest {

    private static CheckBoxSteps checkBoxSteps;



    @BeforeAll
    public static void setUp()
    {
        checkBoxSteps = new CheckBoxSteps();
    }

    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Проверка вывода элементов страницы")
    @DisplayName("Вывод всех вложенных элементов ")
    @Description("Вывод всех вложенных элементов чекбоксов")
    @Tag("smoke-test")
    public void printAllNestedElements(){
        checkBoxSteps.openCheckBoxPage();
        checkBoxSteps.printTreeLeafElements();
        int a = 1;
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
