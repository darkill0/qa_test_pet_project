package ui.demoqatests.widgets;

import config.ui.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.demqa.widgets.NavigationMenuPage;

@Tag("navigation_menu")
@DisplayName("[UI] Проверка navigation menu")
public class NavigationMenuPageTests extends BaseTest {

    private final NavigationMenuPage navigationMenuPage =
            new NavigationMenuPage();

    @Test
    @Tag("smoke")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка main menu")
    public void checkMainMenu() {

        navigationMenuPage.openPage();

        navigationMenuPage
                .shouldHaveMainMenuItems();
    }

    @Test
    @Tag("smoke")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка submenu через hover")
    public void checkSubMenu() {

        navigationMenuPage.openPage();

        navigationMenuPage.hoverMainItem2();

        navigationMenuPage
                .shouldVisibleSubMenu();
    }

    @Test
    @Tag("smoke")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка sub-sub menu")
    public void checkSubSubMenu() {

        navigationMenuPage.openPage();

        navigationMenuPage.hoverMainItem2();

        navigationMenuPage.hoverSubSubList();

        navigationMenuPage
                .shouldVisibleSubSubMenu();
    }
}