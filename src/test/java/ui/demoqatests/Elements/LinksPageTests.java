package ui.demoqatests.Elements;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.Elements.LinksPageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("link_page_ui_test")
@Tag("ui")
@DisplayName("[UI] Тестирование страницы рабочих ссылок")
@Epic("Тестирование открытие ссылок на страницк сайта")
public class LinksPageTests {

    private final LinksPageSteps linksPageSteps = new LinksPageSteps();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenHomePage(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenHomeLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenDynamicHomePage(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenDynamicHomeLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenCreatedLink(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenCreatedLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenNoContentLink(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenNoContentLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenMovedLink(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenMovedLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenBadRequestLink(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenBadRequestLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenUnauthorizedLink(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenUnauthorizedLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenForbiddenLink(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenForbiddenLink();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void checkOpenNotFoundLink(){
        linksPageSteps.openPage();
        linksPageSteps.shouldOpenNotFoundLink();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
