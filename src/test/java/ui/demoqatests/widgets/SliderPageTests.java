package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.SliderPageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("slider_page_ui_tests")
@Tag("ui")
@DisplayName("[UI] Проверка slider page")
public class SliderPageTests extends BaseTest {
    private final SliderPageSteps sliderPageSteps = new SliderPageSteps();

    @Tag("smoke_test")
    @Test
    @DisplayName("Проверка слайдера на странице")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSlider(){
        sliderPageSteps.openSitePage();
        sliderPageSteps.shouldSlideTo75Percentage();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
