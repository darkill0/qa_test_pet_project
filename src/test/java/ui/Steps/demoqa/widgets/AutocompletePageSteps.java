package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.AutocompletePage;

public class AutocompletePageSteps {
    private final AutocompletePage autocompletePage = new AutocompletePage();

    @Step("Открываем страницу сайта")
    public void openSitePage(){
        autocompletePage.openSitePage();
    }

    @Step("Заполняем единичный input")
    public void shouldAddSingleInputPage(){
        autocompletePage.inputAndCheckSingleContainer();
    }

    @Step("Заполняем multiple input")
    public void shouldAddTwoMultipleInputPage(){
        autocompletePage.inputMultipleAutocomplete();
    }

    @Step("Заполняем single input и итерируемся по стрелкам")
    public void shouldAddSingleInputPageAndKeysExecution(){
        autocompletePage.testWithKeyboardNavigation();
    }
}
