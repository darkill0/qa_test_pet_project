package ui.demoqatests.bookstore;

import config.ui.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.bookstore.ProfilePageSteps;

@Tag("profile_ui_tests")
@DisplayName("[UI] тестирование bookstore")
public class ProfilePageTests extends BaseTest {
    private static ProfilePageSteps profilePageSteps;
    private final String login = "fuckingonegoat";
    private final String password = "Test12345678@";

    @BeforeAll()
    public static void setUp(){
        profilePageSteps = new ProfilePageSteps();
    }

    @Test
    @Tag("e2e_test")
    @DisplayName("UI test bookstore")
    @Description("Тестирование входа и работа с книгами")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ilya Koltsov")
    public void E2ETestBookStore(){
        profilePageSteps.openLoginPage();
        profilePageSteps.login(login, password);
        profilePageSteps.goToBookStore();
        profilePageSteps.addAllBooks();
        profilePageSteps.checkAllBooksInProfile();
        profilePageSteps.findBookInProfile("You");
        profilePageSteps.deleteOneBook();
        profilePageSteps.deleteAllBooksInProfile();

    }
}
