package ui.demoqatests.interactions;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.interactions.SortablePageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("sortable_page_ui_tests")
@Tag("ui")
@DisplayName("[UI] Тестирование ручной сортировки ")
public class SortablePageTests extends BaseTest {
    private final SortablePageSteps sortablePageSteps = new SortablePageSteps();

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Тестирование list drag and drop")
    public void checkListDragAndDrop(){
        sortablePageSteps.openSitePage();
        sortablePageSteps.checkDragAndDropForList();
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Тестирование grid drag and drop")
    public void checkGridDragAndDrop(){
        sortablePageSteps.openSitePage();
        sortablePageSteps.checkDragAndDropForGrid();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
