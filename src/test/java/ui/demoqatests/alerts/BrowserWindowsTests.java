package ui.demoqatests.alerts;


import config.ui.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.alerts.BrowserWindowsSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("browser_window_ui_tests")
@Tag("ui")
@DisplayName("[UI] Проверка windows страницы сайта")
public class BrowserWindowsTests extends BaseTest {
    private final BrowserWindowsSteps browserWindowsSteps = new BrowserWindowsSteps();



    @Test
    @Severity(SeverityLevel.MINOR)
    public void checkOpenNewTabBtn(){
        browserWindowsSteps.openSitePage();
        browserWindowsSteps.clickNewTabBtnAndCheckThatTheTabOpen();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void checkOpenNewWindowBtn(){
        browserWindowsSteps.openSitePage();
        browserWindowsSteps.clickNewWindowBtnAndCheckThatTheWindowOpen();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void checkOpenNewWindowWithMessageBtn(){
        browserWindowsSteps.openSitePage();
        browserWindowsSteps.clickNewWindowWithMessageBtnAndCheckThatTheWindowOpenWithMessage();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }

}
