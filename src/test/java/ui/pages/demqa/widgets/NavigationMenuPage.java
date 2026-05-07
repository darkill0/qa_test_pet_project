package ui.pages.demqa.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationMenuPage extends BasePage {
    private final String URL =
            "https://demoqa.com/menu";

    private final ElementsCollection mainMenuItems =
            $$("#nav > li");

    public void openPage() {
        openUrl(URL);
    }

    public void shouldHaveMainMenuItems() {

        mainMenuItems.shouldHave(size(3));

        mainMenuItems.shouldHave(
                texts(
                        "Main Item 1",
                        "Main Item 2",
                        "Main Item 3"
                )
        );
    }

    public void hoverMainItem2() {

        mainMenuItems
                .findBy(visible)
                .scrollIntoView(true);

        mainMenuItems
                .findBy(text("Main Item 2"))
                .hover();
    }

    public void shouldVisibleSubMenu() {

        SelenideElement subMenu =
                $("#nav > li:nth-child(2) ul");

        subMenu.shouldBe(visible);

        subMenu.$$(":scope > li")
                .shouldHave(size(3));

        subMenu.$$(":scope > li")
                .shouldHave(
                        texts(
                                "Sub Item",
                                "Sub Item",
                                "SUB SUB LIST »"
                        )
                );
    }

    public void hoverSubSubList() {

        $("#nav > li:nth-child(2)")
                .$(byText("SUB SUB LIST »"))
                .hover();
    }

    public void shouldVisibleSubSubMenu() {

        ElementsCollection subSubItems =

                $("#nav > li:nth-child(2)")
                        .$(byText("SUB SUB LIST »"))
                        .parent()
                        .$$("ul > li");

        subSubItems.shouldHave(size(2));

        subSubItems.shouldHave(
                texts(
                        "Sub Sub Item 1",
                        "Sub Sub Item 2"
                )
        );
    }
}
