package ui.pages.demqa.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TabsPage extends BasePage {
    private final String URL = "https://demoqa.com/tabs";
    private final ElementsCollection tabs = $$("[role='tab']");

    public void openSitePage(){
        openUrl(URL);
    }

    public void checkClickSecondAndFirstTab(){
        SelenideElement firstTab = tabs.get(0);
        SelenideElement secondTab = tabs.get(1);

        firstTab.shouldHave(attribute("aria-selected", "true"));
        secondTab.click();
        $(".active.show").shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text."));
        firstTab.shouldHave(attribute("aria-selected", "false"));
        secondTab.shouldHave(attribute("aria-selected", "true"));
        firstTab.click();
        $(".active.show").shouldHave(text("Lorem Ipsum is simply dummy text"));

    }
}
