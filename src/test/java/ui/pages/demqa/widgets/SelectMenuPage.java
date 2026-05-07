package ui.pages.demqa.widgets;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.util.Arrays;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelectMenuPage extends BasePage {

    private final String URL =
            "https://demoqa.com/select-menu";

    private final SelenideElement selectValueDropdown =
            $("#withOptGroup");

    private final SelenideElement selectOneDropdown =
            $("#selectOne");

    private final SelenideElement oldStyleSelectMenu =
            $("#oldSelectMenu");

    private final SelenideElement multiSelectDropdown =
            $("#react-select-4-input");

    private final SelenideElement standardMultiSelect =
            $("#cars");

    public void openPage() {

        openUrl(URL);
    }

    public void selectValue(String option) {

        selectValueDropdown.click();

        $(byText(option)).click();
    }

    public void shouldHaveSelectedValue(String value) {

        selectValueDropdown
                .shouldHave(text(value));
    }

    public void selectOneValue(String value) {

        selectOneDropdown.click();

        $(byText(value)).click();
    }

    public void shouldHaveSelectedOneValue(String value) {

        selectOneDropdown
                .shouldHave(text(value));
    }

    public void selectOldStyleMenu(String value) {

        oldStyleSelectMenu.selectOption(value);
    }

    public void shouldHaveOldStyleSelectedValue(String value) {

        oldStyleSelectMenu
                .getSelectedOption()
                .shouldHave(text(value));
    }

    public void selectMultiValue(String... values) {

        for (String value : values) {

            multiSelectDropdown.setValue(value);

            multiSelectDropdown.pressEnter();
        }
    }

    public void shouldHaveMultiSelectedValues(
            String... values) {

        $$(".css-12jo7m5")
                .shouldHave(texts(values));
    }

    public void selectStandardMultiSelect(
            String... values) {

        standardMultiSelect
                .selectOption(Arrays.toString(values));
    }

    public void shouldHaveSelectedCars(
            String... values) {

        standardMultiSelect
                .getSelectedOptions()
                .shouldHave(texts(values));
    }
}