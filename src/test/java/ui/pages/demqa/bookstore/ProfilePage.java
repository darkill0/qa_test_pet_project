package ui.pages.demqa.bookstore;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ScrollIntoViewOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.collections.SizeGreaterThan;
import config.ui.BasePage;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.ScrollIntoViewOptions.instant;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePage extends BasePage {

    private final String URL = "https://demoqa.com/login";
    private final String URL_PROFILE = "https://demoqa.com/profile";

    private final SelenideElement userName = $("#userName");
    private final SelenideElement userPassword = $("#password");
    private final SelenideElement btnLogin = $("#login");
    private final SelenideElement btnGoToStore = $("#gotoStore");
    private final SelenideElement searchBox = $("#searchBox");

    private List<String> expectedBooks;

    public void openUrlSite() {

        open(URL);
    }

    public ProfilePage login(String username, String password) {

        userName.shouldBe(visible).setValue(username);
        userPassword.shouldBe(visible).setValue(password);

        btnLogin.shouldBe(enabled).click();

        webdriver().shouldHave(urlContaining("/profile"));

        return this;
    }

    public void goToBooksStore() {

        btnGoToStore.scrollIntoView(instant().block(ScrollIntoViewOptions.Block.center)).shouldBe(visible).click();

        webdriver().shouldHave(urlContaining("/books"));

        expectedBooks =
                $$x("//div[@class='action-buttons']//a").shouldHave(sizeGreaterThan(0)).texts();
    }

    public void addAllBooksToProfile() {

        List<String> booksNames =
                $$x("//div[@class='action-buttons']//a")
                        .shouldHave(sizeGreaterThan(0))
                        .texts();

        for (String bookName : booksNames) {

            $(byText(bookName)).scrollIntoView(true)
                            .shouldBe(visible)
                                    .click();

            webdriver().shouldHave(urlContaining("search"));

            $$("#addNewRecordButton")
                    .last()
                    .scrollIntoView(true)
                    .shouldBe(visible, enabled)
                    .click();

            confirm();

            $$("#addNewRecordButton")
                    .first()
                    .scrollIntoView(true)
                    .shouldBe(visible, enabled)
                    .click();

            webdriver().shouldHave(urlContaining("/books"));


        }
    }

    public void checkAllAddedBooksInProfile() {

        open(URL_PROFILE);

        List<String> actualBooks =
                $$x("//div[@class='action-buttons']//a").shouldBe(sizeGreaterThan(0))
                        .texts();

        assertEquals(expectedBooks.stream().sorted().toList(), actualBooks.stream().sorted().toList());
    }

    public void searchBook(String bookName) {

        searchBox.shouldBe(visible)
                .setValue(bookName);

        $x("//div[@class='action-buttons']//a")
                .shouldHave(text(bookName));
        searchBox.clear();
        openUrl(URL_PROFILE);
    }

    public void deleteFirstBook() {

        $$("[id*='delete-record-']")
                .first()
                .shouldBe(visible)
                .click();

        $("#closeSmallModal-ok")
                .shouldBe(visible)
                .click();

        confirm("Book deleted.");
        int booksCount =
                $$x("//div[@class='action-buttons']//a")
                        .shouldBe(sizeGreaterThan(0))
                        .size();

        assertEquals(7, booksCount);
    }

    public void deleteAllBooks() {

        open(URL_PROFILE);

        SelenideElement deleteButton =
                $x("//div[@class='text-right button di']/button");

        deleteButton
                .shouldBe(visible, enabled)
                .scrollIntoView("{block: 'center'}");

        deleteButton.shouldBe(visible, enabled)
                .scrollIntoView(true).click();

        $("#closeSmallModal-ok")
                .should(appear)
                .shouldBe(visible, enabled)
                .click();

        refresh();

        $$x("//div[@class='action-buttons']//a")
                .shouldHave(size(0));
    }

    public void logOut() {

        $("#submit")
                .shouldHave(text("Logout"))
                .click();

        webdriver().shouldHave(urlContaining("/login"));
    }

    public void registerNewUser(
            String firstName,
            String lastName,
            String userNameValue,
            String passwordValue
    ) {

        $("#firstname")
                .shouldBe(visible)
                .setValue(firstName);

        $("#lastname")
                .setValue(lastName);

        $("#userName")
                .setValue(userNameValue);

        $("#password")
                .setValue(passwordValue);

        $("#register")
                .scrollIntoView(true)
                .click();

        confirm("User Registered Successfully.");
    }
}