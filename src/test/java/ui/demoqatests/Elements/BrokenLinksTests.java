package ui.demoqatests.Elements;

import config.ui.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.Elements.BrokenLinksSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("broken_link_ui_test")
@DisplayName("[UI] Тестирование валидных и невалидных ссылок")
@Epic("тестирование работы с ссылками на сайте")
public class BrokenLinksTests extends BaseTest {
    private final BrokenLinksSteps brokenLinksSteps = new BrokenLinksSteps();

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Тестирование открытия валидного url")
    public void checkOpenValidUrl(){
        brokenLinksSteps.shouldOpenPage();
        brokenLinksSteps.shouldOpenValidLink();
    }

    @Tag("smoke_test")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Тестирование открытия невалидного url")
    public void checkOpenInvalidUrl(){
        brokenLinksSteps.shouldOpenPage();
        brokenLinksSteps.shouldOpenInvalidLink();
    }
    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
