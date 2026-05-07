package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.DatePickerPageSteps;

@Tag("date_time_picker_ui_tests")
@DisplayName("[UI] Тестирование ввода даты и времени")
public class DateTimePickerPageTests extends BaseTest {
    private final DatePickerPageSteps datePickerPageSteps = new DatePickerPageSteps();

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Ввод и проверка даты")
    public void checkInputOnlyDate(){
        datePickerPageSteps.openSitePage();
        String res = datePickerPageSteps.inputOnlyDate("8","6", "2026");
        datePickerPageSteps.checkDateInputValue(res);
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Ввод и проверка даты и времени")
    public void checkInputDateAndTime(){
        datePickerPageSteps.openSitePage();
        String res = datePickerPageSteps.inputDateAndTime(8,"April","2027","12:30");
        datePickerPageSteps.checkDateAndTimeInputValue(res);
    }
}
