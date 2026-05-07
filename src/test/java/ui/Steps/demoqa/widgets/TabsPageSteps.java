package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.TabsPage;

public class TabsPageSteps {
    private final TabsPage tabsPage = new TabsPage();

    @Step("открытие страницы текста")
    public void openSitePage(){
        tabsPage.openSitePage();
    }

    @Step("Кликаем по второй вкладке а потом снова по первой. Проверяем текст")
    public void shouldClickToSecondTabAndAfterToFirst(){
        tabsPage.checkClickSecondAndFirstTab();
    }
}
