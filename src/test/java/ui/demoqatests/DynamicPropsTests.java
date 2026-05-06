package ui.demoqatests;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.DynamicPropsSteps;

@Tag("dynamic_props_ui_tests")
@DisplayName("[UI] Тестирование динамичных объектов сайта")
@Description("Проверяем динамичные объекты")
public class DynamicPropsTests extends BaseTest {
    private final DynamicPropsSteps dynamicPropsSteps = new DynamicPropsSteps();

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка появление кнопки после 5 секунд")
    public void checkVisibleButtonAfter5Seconds(){
        dynamicPropsSteps.openPage();
        dynamicPropsSteps.shouldVisibleButtonAfter5Seconds();
    }

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка изменения цвета кнопки после 5 секунд")
    public void checkChangeColorButtonAfter5Seconds(){
        dynamicPropsSteps.openPage();
        dynamicPropsSteps.shouldChangeColorButtonAfter5Seconds();
    }

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка видимости текста с рандомным id")
    public void checkVisibleTextWithRandomId(){
        dynamicPropsSteps.openPage();
        dynamicPropsSteps.shouldHaveTextWithRandomId();
    }

}
