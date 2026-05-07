package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.TabsPageSteps;

@Tag("tabs_page_ui_tests")
@DisplayName("Тестирование страницы с tabs")
public class TabsPageTests extends BaseTest {
    private final TabsPageSteps tabsPageSteps = new TabsPageSteps();

    @Test
    @Tag("smoke_test")
    @DisplayName("Проверка прыгаем с первой по второй вкладке и чекаем текст")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkClickToSecondAndToFirstTabAndCheckTextTabs(){
        tabsPageSteps.openSitePage();
        tabsPageSteps.shouldClickToSecondTabAndAfterToFirst();
    }
}
