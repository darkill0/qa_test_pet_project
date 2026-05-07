package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.ProgressorBarSteps;

@Tag("progressor_bar_ui_tests")
@DisplayName("тестирование progressor bar")
public class ProgressorBarPageTests extends BaseTest {

    private final ProgressorBarSteps progressorBarSteps = new ProgressorBarSteps();

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("тестирование запуска Progressor bar")
    @Order(2)
    public void checkStartProgressor(){
        progressorBarSteps.openSitePage();
        progressorBarSteps.shouldStartProgressorBar();
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("тестирование reset Progressor bar")
    @Order(1)
    public void checkResetProgressor(){
        progressorBarSteps.openSitePage();
        progressorBarSteps.shouldResetProgressorBar();
    }


}
