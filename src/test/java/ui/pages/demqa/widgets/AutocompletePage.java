package ui.pages.demqa.widgets;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AutocompletePage extends BasePage {
    private final String URL = "https://demoqa.com/auto-complete";

    public void openSitePage(){
        openUrl(URL);
    }

    public void inputAndCheckSingleContainer(){
        $("#autoCompleteSingleInput").sendKeys("Re");
        $(".auto-complete__menu").shouldBe(visible);
        $(".auto-complete__option").shouldHave(text("Red"));
        $(".auto-complete__option").click();
        $(".auto-complete__single-value").shouldHave(text("Red"));

    }

    public void inputMultipleAutocomplete(){
        SelenideElement multipleInput = $("#autoCompleteMultipleInput");

        // Вводим первый цвет
        multipleInput.setValue("r");
        $(".auto-complete__menu").shouldBe(visible);
        $$(".auto-complete__option").findBy(text("Red")).click();

        // Вводим второй цвет
        multipleInput.setValue("b");
        $(".auto-complete__menu").shouldBe(visible);
        $$(".auto-complete__option").findBy(text("Blue")).click();

        // Проверяем, что оба цвета выбраны
        $$(".auto-complete__multi-value__label")
                .shouldHave(exactTexts("Red", "Blue"));
    }

    public void testWithKeyboardNavigation() {

        SelenideElement input = $("#autoCompleteSingleInput");
        input.clear();
        input.sendKeys("g");

        // Ждем появления меню
        $(".auto-complete__menu").shouldBe(visible);

        // Навигация стрелками
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ENTER);

        // Проверяем выбранное значение
        String selectedValue = $(".auto-complete__single-value").getText();
        System.out.println("Selected: " + selectedValue);
    }
}
