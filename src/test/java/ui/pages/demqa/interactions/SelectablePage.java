package ui.pages.demqa.interactions;

import com.codeborne.selenide.ElementsCollection;
import config.ui.BasePage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectablePage extends BasePage {
    private final String URL = "https://demoqa.com/selectable";
    private final ElementsCollection list = $$("#verticalListContainer > .list-group-item-action");
    private final ElementsCollection grid = $$("#gridContainer  > .list-group  > .list-group-item");

    public void openSitePage(){
        openUrl(URL);
    }

    public void checkSelectList(){
        list.findBy(text("Dapibus ac facilisis in")).click();
        list.findBy(text("Morbi leo risus")).click();

         $$("#verticalListContainer > .list-group-item-action.active").shouldHave(texts(
                 "Dapibus ac facilisis in",
                 "Morbi leo risus"
         ));
    }

    public void checkSelectGrid(){
        $("#demo-tab-grid").click();
        grid.findBy(text("One")).click();
        grid.findBy(text("Five")).click();
        grid.findBy(text("Nine")).click();

        $$("#gridContainer  > .list-group  > .list-group-item.active").shouldHave(texts(
                "One",
                "Five",
                "Nine"
        ));
    }
}
