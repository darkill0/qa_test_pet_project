package ui.pages.demqa.interactions;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.ElementsCollection;
import config.ui.BasePage;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SortablePage extends BasePage {
    private final String URL = "https://demoqa.com/sortable";
    private final ElementsCollection list = $$(".list-group > .list-group-item");
    private final ElementsCollection grid = $$(".create-grid > .list-group-item");

    public void openSitePage(){
        openUrl(URL);
    }

    public void checkListItems(){
        list.shouldHave(texts(
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six"
        ));

    }


    public void dragAndDropFirstElementToThree() {
        var one = list.findBy(text("One"));
        var three = list.findBy(text("Three"));

        one.dragAndDrop(DragAndDropOptions.to(three));

        list.shouldHave(texts(
                "Two",
                "Three",
                "One",
                "Four",
                "Five",
                "Six"
        ));
    }

    public void dragAndDropFirstElementToThreeGrid() {
        $("#demo-tab-grid").click();
        var one = grid.findBy(text("One"));
        var three = grid.findBy(text("Nine"));

        one.dragAndDrop(DragAndDropOptions.to(three));

        grid.shouldHave(texts(
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "One"
        ));
    }
}
