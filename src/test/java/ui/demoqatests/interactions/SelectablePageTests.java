package ui.demoqatests.interactions;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.interactions.SelectablePageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("selectable_page_ui_tests")
@DisplayName("[UI] Тестирование Selectable Page")
public class SelectablePageTests extends BaseTest {
    private final SelectablePageSteps selectablePageSteps = new SelectablePageSteps();

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тестирование select в list")
    public void checkListSelect(){
        selectablePageSteps.openSitePage();
        selectablePageSteps.shouldSelectList();
    }


    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тестирование select в grid")
    public void checkGridSelect(){
        selectablePageSteps.openSitePage();
        selectablePageSteps.shouldSelectGrid();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
