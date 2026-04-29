package ui.pages.demqa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;
import org.junit.jupiter.api.Assertions;

import java.util.*;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DemoCheckBoxPage extends BasePage {
    private final String URL = "https://demoqa.com/checkbox";
    private final ElementsCollection treeNode = $$x("//div[@class='rc-tree-list-holder-inner']/div[@role='treeitem']");
    public DemoCheckBoxPage openCheckBoxUrl()
    {
        openUrl(URL);
        expandAll();
        return this;
    }

    public DemoCheckBoxPage printAllLeafElements(){

//        for(SelenideElement elem: treeNode){
//            String name = elem.$x(".//span/span[@class='rc-tree-title']").getText();
//            System.out.println(name);
//
//
//        }
        clickCheckBoxNotes();
        return this;
    }

    public DemoCheckBoxPage clickCheckBoxNotes(){
        for(SelenideElement elem: treeNode){
            if(elem.$x(".//span/span[@class='rc-tree-title']").getText().equals("Notes")){
                elem.$x(".//span[@class='rc-tree-checkbox']").click();
            }


        }
        List<String> elems = new ArrayList<>();
        for(SelenideElement elem: treeNode){
            if(elem.$x(".//span[@class='rc-tree-checkbox rc-tree-checkbox-indeterminate']").exists()){
                elems.add(elem.$x(".//span[@class='rc-tree-title']").getText());
            }
        }
        List<String> expected = new ArrayList<>();
        expected.add("Home");
        expected.add("Desktop");
        Assertions.assertEquals(expected, elems);


        return this;
    }



    public DemoCheckBoxPage expandAll() {

        while (true) {
            ElementsCollection closedNodes =
                    $$x("//span[contains(@class,'rc-tree-switcher_close')]");

            if (closedNodes.isEmpty()) {
                break;
            }

            // всегда кликаем первый найденный
            closedNodes.first().click();
        }

        return this;
    }

}
