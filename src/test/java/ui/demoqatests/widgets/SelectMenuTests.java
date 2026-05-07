package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.SelectMenuSteps;

@Tag("select_menu_page")
@DisplayName("[UI] Проверка страницы Select Menu")
public class SelectMenuTests extends BaseTest {

    private final SelectMenuSteps selectMenuSteps =
            new SelectMenuSteps();

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка Select Value")
    public void checkSelectValue() {

        selectMenuSteps.openPage();

        selectMenuSteps
                .selectValue("Group 1, option 1");

        selectMenuSteps
                .shouldHaveSelectedValue(
                        "Group 1, option 1"
                );
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка Select One")
    public void checkSelectOne() {

        selectMenuSteps.openPage();

        selectMenuSteps
                .selectOneValue("Mr.");

        selectMenuSteps
                .shouldHaveSelectOneValue("Mr.");
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка Old Style Select Menu")
    public void checkOldStyleSelect() {

        selectMenuSteps.openPage();

        selectMenuSteps
                .selectOldStyleValue("Purple");

        selectMenuSteps
                .shouldHaveOldStyleValue(
                        "Purple"
                );
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка Multi Select")
    public void checkMultiSelect() {

        selectMenuSteps.openPage();

        selectMenuSteps
                .selectMultiValues(
                        "Green",
                        "Blue",
                        "Black"
                );

        selectMenuSteps
                .shouldHaveMultiValues(
                        "Green",
                        "Blue",
                        "Black"
                );
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка Standard Multi Select")
    public void checkStandardMultiSelect() {

        selectMenuSteps.openPage();

        selectMenuSteps
                .selectCars(
                        "Volvo",
                        "Audi"
                );

        selectMenuSteps
                .shouldHaveSelectedCars(
                        "Volvo",
                        "Audi"
                );
    }
}