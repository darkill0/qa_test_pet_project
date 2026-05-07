package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.SelectMenuPage;

public class SelectMenuSteps {

    private final SelectMenuPage selectMenuPage =
            new SelectMenuPage();

    @Step("Открыть страницу Select Menu")
    public void openPage() {

        selectMenuPage.openPage();
    }

    @Step("Выбрать значение в Select Value")
    public void selectValue(String value) {

        selectMenuPage.selectValue(value);
    }

    @Step("Проверить выбранное значение Select Value")
    public void shouldHaveSelectedValue(
            String value) {

        selectMenuPage
                .shouldHaveSelectedValue(value);
    }

    @Step("Выбрать значение в Select One")
    public void selectOneValue(String value) {

        selectMenuPage
                .selectOneValue(value);
    }

    @Step("Проверить значение Select One")
    public void shouldHaveSelectOneValue(
            String value) {

        selectMenuPage
                .shouldHaveSelectedOneValue(value);
    }

    @Step("Выбрать значение Old Style Select")
    public void selectOldStyleValue(
            String value) {

        selectMenuPage
                .selectOldStyleMenu(value);
    }

    @Step("Проверить значение Old Style Select")
    public void shouldHaveOldStyleValue(
            String value) {

        selectMenuPage
                .shouldHaveOldStyleSelectedValue(
                        value
                );
    }

    @Step("Выбрать значения Multi Select")
    public void selectMultiValues(
            String... values) {

        selectMenuPage
                .selectMultiValue(values);
    }

    @Step("Проверить значения Multi Select")
    public void shouldHaveMultiValues(
            String... values) {

        selectMenuPage
                .shouldHaveMultiSelectedValues(
                        values
                );
    }

    @Step("Выбрать значения Standard Multi Select")
    public void selectCars(
            String... values) {

        selectMenuPage
                .selectStandardMultiSelect(values);
    }

    @Step("Проверить выбранные машины")
    public void shouldHaveSelectedCars(
            String... values) {

        selectMenuPage
                .shouldHaveSelectedCars(values);
    }
}