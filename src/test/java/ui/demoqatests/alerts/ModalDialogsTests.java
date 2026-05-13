package ui.demoqatests.alerts;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.alerts.ModalDialogsSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("modal_dialogs_ui_tests")
@Tag("ui")
@DisplayName("[UI] Проверка modal dialogs")
public class ModalDialogsTests {
    private final ModalDialogsSteps modalDialogsSteps = new ModalDialogsSteps();

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    public void checkSmallModalDialog(){
        modalDialogsSteps.openModalDialogsPage();
        modalDialogsSteps.shouldOpenSmallDialog();
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    public void checkLargeModalDialog(){
        modalDialogsSteps.openModalDialogsPage();
        modalDialogsSteps.shouldOpenLargeDialog();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }

}
