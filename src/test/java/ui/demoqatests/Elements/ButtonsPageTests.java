package ui.demoqatests.Elements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junitpioneer.jupiter.RetryingTest;
import ui.Steps.demoqa.Elements.ButtonsPageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("buttons_page_ui_test")
@Tag("ui")
@Owner("Ilya Koltov")
@DisplayName("[UI] тестирование страницы кнопок")
public class ButtonsPageTests {

    private final ButtonsPageSteps buttonsPageSteps = new ButtonsPageSteps();

    @Tag("smoke_test")
    @DisplayName("тестирование двойного клика")
    @Description("тестирование двойного клика")
    @Severity(SeverityLevel.MINOR)
    @RetryingTest(maxAttempts = 3)
    public void checkDoubleClick(){
        buttonsPageSteps.shouldOpenPage();
        buttonsPageSteps.shouldDoubleClick();
    }

    @Tag("smoke_test")
    @DisplayName("тестирование правого клика")
    @Description("тестирование правого клика")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void checkRightClick(){
        buttonsPageSteps.shouldOpenPage();
        buttonsPageSteps.shouldRightClick();
    }

    @Tag("smoke_test")
    @DisplayName("тестирование одиночного клика")
    @Description("тестирование одиночного клика")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void checkDynamicClick(){
        buttonsPageSteps.shouldOpenPage();
        buttonsPageSteps.shouldDynamicClick();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }

}
