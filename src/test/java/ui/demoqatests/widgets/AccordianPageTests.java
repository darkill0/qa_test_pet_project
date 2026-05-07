package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.AccordianPageSteps;

@Tag("accordian_page_ui_tests")
@DisplayName("Проверка страницы аккордиана")
public class AccordianPageTests extends BaseTest {
    private final AccordianPageSteps accordianPageSteps = new AccordianPageSteps();

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка раскрытия объекта аккордиона")
    @Order(1)
    public void checkOpenAccordianObject(){
        accordianPageSteps.openSitePage();
        accordianPageSteps.shouldOpenAccordianItem();
    }


    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка закрытия объекта аккордиона")
    @Order(2)
    public void checkCloseAccordianObject(){
        accordianPageSteps.openSitePage().shouldCloseAccordianItem();
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка закрытия первого объекта аккордиона после нажатия второго элмента")
    @Order(2)
    public void checkCloseAccordianObjectAfterClickNextElement(){
        accordianPageSteps.openSitePage().shouldCollapsedFirstElementWhenClickFirstElement();
    }

}
