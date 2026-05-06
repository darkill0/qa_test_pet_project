package ui.demoqatests.alerts;

import config.ui.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.alerts.AlertsPageSteps;

@Tag("alerts_page_ui_tests")
public class AlertsPageTests extends BaseTest {
    private final AlertsPageSteps alertsPageSteps = new AlertsPageSteps();

    @Test
    @Tag("smoke_test")
    @Severity(SeverityLevel.MINOR)
    public void checkOpenAlertModal(){
        alertsPageSteps.openAlertPage();
        alertsPageSteps.shouldOpenAlertWindow();
    }

    @Test
    @Tag("smoke_test")
    @Severity(SeverityLevel.MINOR)
    public void checkOpenAlertModalAfter5Seconds(){
        alertsPageSteps.openAlertPage();
        alertsPageSteps.shouldOpenAlertWindowAfter5Seconds();
    }

    @Test
    @Tag("smoke_test")
    @Severity(SeverityLevel.MINOR)
    public void checkOpenConfirmAlertModal(){
        alertsPageSteps.openAlertPage();
        alertsPageSteps.shouldOpenConfirmAlertWindow();
    }

    @Test
    @Tag("smoke_test")
    @Severity(SeverityLevel.MINOR)
    public void checkOpenConfirmAlertModalWithCancel(){
        alertsPageSteps.openAlertPage();
        alertsPageSteps.shouldOpenConfirmAlertWindowWithCancel();
    }

    @Test
    @Tag("smoke_test")
    @Severity(SeverityLevel.MINOR)
    public void checkOpenPromtAlertModal(){
        alertsPageSteps.openAlertPage();
        alertsPageSteps.shouldOpenPromtAlertWindowWith();
    }
}
