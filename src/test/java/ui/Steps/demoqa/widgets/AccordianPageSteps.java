package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.AccordianPage;

public class AccordianPageSteps {
    private final AccordianPage accordianPage = new AccordianPage();

    @Step("Открытие страницы сайта")
    public AccordianPageSteps openSitePage(){
        accordianPage.openPage();
        return this;
    }

    @Step("Раскрытие объекта аккордиана")
    public AccordianPageSteps shouldOpenAccordianItem(){
        accordianPage.clickLoremBtn();
        return this;
    }

    @Step("Закрытие объекта аккордиана")
    public AccordianPageSteps shouldCloseAccordianItem(){
        accordianPage.unclickLoremBtn();
        return this;
    }

    @Step("Нажатие второго элемента в списке")
    public AccordianPageSteps shouldCollapsedFirstElementWhenClickFirstElement(){
        accordianPage.checkCollapsedTextWhenClickSecondBtn();
        return this;
    }
}
