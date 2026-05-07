package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.AutocompletePageSteps;

@Tag("autocomplete_page_ui_test")
@DisplayName("Тестирование автодополнения на странице")
public class AutocompletePageTests extends BaseTest {
    private final AutocompletePageSteps autocompletePageSteps = new AutocompletePageSteps();

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @DisplayName("тестирование единичного автодополнения")
    @Severity(SeverityLevel.MINOR)
    public void checkSingleInputAutocomplete(){
        autocompletePageSteps.openSitePage();
        autocompletePageSteps.shouldAddSingleInputPage();
    }

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @DisplayName("тестирование множественного автодополнения")
    @Severity(SeverityLevel.MINOR)
    public void checkMultipleInputAutocomplete(){
        autocompletePageSteps.openSitePage();
        autocompletePageSteps.shouldAddTwoMultipleInputPage();
    }

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @DisplayName("тестирование единичного автодополнения и итерация с помощью кнопок")
    @Severity(SeverityLevel.MINOR)
    public void checkSingleInputAutocompleteAndKeysExecution(){
        autocompletePageSteps.openSitePage();
        autocompletePageSteps.shouldAddSingleInputPageAndKeysExecution();
    }
}
