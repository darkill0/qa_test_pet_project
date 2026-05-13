package ui.demoqatests.alerts;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.alerts.NestedFramesSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("nested_frame_ui_test")
@DisplayName("[UI] Тестирование вложенного frame")
public class NestedFramesTests extends BaseTest {
    private final NestedFramesSteps nestedFramesSteps = new NestedFramesSteps();



    @Test
    @Tag("smoke_test")
    @DisplayName("Проверка вложженого frame")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.NORMAL)
    public void checkSwitchToNestedFrame(){
        nestedFramesSteps.openNestedFramesPage();
        nestedFramesSteps.shouldSwitchToChildFrame();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
