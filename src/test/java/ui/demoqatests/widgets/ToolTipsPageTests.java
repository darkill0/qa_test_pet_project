package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.widgets.ToolTipsPageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("tool_tips_ui_page")
@Tag("ui")
@DisplayName("[UI] Проверка страницы tooltips")
public class ToolTipsPageTests extends BaseTest {
    private final ToolTipsPageSteps toolTipsPageSteps = new ToolTipsPageSteps();


    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка подсказки на кнопки")
    public void  checkHoverToBtn(){
        toolTipsPageSteps.openSitePage();
        toolTipsPageSteps.shouldHoverAndVisibleToolTipText();
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка подсказки на text field")
    public void  checkHoverToTF(){
        toolTipsPageSteps.openSitePage();
        toolTipsPageSteps.shouldHoverToTextFieldAndVisibleToolTipText();
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка подсказки на внутренный текст ссылку")
    public void  checkHoverToLinkText(){
        toolTipsPageSteps.openSitePage();
        toolTipsPageSteps.shouldHoverToLinkTextAndVisibleToolTipText();
    }

    @Test
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка подсказки на ip адрес в ссылки")
    public void  checkHoverToNumberText(){
        toolTipsPageSteps.openSitePage();
        toolTipsPageSteps.shouldHoverIpAddressAndVisibleToolTipText();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
