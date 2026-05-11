package ui.Steps.demoqa.interactions;

import io.qameta.allure.Step;
import ui.pages.demqa.interactions.SortablePage;

public class SortablePageSteps {
    private final SortablePage sortablePage = new SortablePage();
    @Step("Открытие страницы сайта")
    public void openSitePage(){
        sortablePage.openSitePage();
    }

    @Step("Тестирование перемещение элементов в листе")
    public void checkDragAndDropForList(){
        sortablePage.dragAndDropFirstElementToThree();
    }

    @Step("Тестирование перемещение элементов в сетке")
    public void checkDragAndDropForGrid(){
        sortablePage.dragAndDropFirstElementToThreeGrid();
    }
}
