package ui.wikitests;

import config.ui.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.wiki.WikiSteps;

@Tag("ui-wiki-test")
@Epic("Тестирвоание вики страницы")
@Feature("ui_wiki_test_2")
@DisplayName("Тестирование страницы wiki")
public class TestWiki extends BaseTest {

    @Test
    @Description("Тестирование нахождения блока History")
    @DisplayName("BLock h2 should have text History")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.NORMAL)
    @Tag("test_wiki_page")
    @Story("Открываем страницу wiki и проверяем что есть блок История")
    public void shouldHaveText()
    {
        new WikiSteps().open("https://en.wikipedia.org/wiki/Java_(programming_language)").verifyText("History");
    }
}
