package ui.demoqatests.alerts;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.alerts.FramesPageSteps;

@Tag("frame_page_ui_tests")
@DisplayName("Тестирование frames на страницах")
@Owner("Ilya Koltsov")
public class FramesPageTests extends BaseTest {
    private final FramesPageSteps framesPageSteps = new FramesPageSteps();

    @Test
    @Tag("smoke_test")
    @Severity(SeverityLevel.MINOR)
    public void shouldSwitchToFirstIframe(){
        framesPageSteps.openSitePageWithFrames();
        framesPageSteps.shouldSwitchToFirstFrame();
    }

    @Test
    @Tag("smoke_test")
    @Severity(SeverityLevel.MINOR)
    public void shouldSwitchToSecondIframe(){
        framesPageSteps.openSitePageWithFrames();
        framesPageSteps.shouldSwitchToSecondFrame();
    }
}
