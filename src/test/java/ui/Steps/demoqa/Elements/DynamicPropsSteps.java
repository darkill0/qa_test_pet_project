package ui.Steps.demoqa.Elements;

import io.qameta.allure.Step;
import ui.pages.demqa.Elements.DynamicPropertiesPage;

public class DynamicPropsSteps {
    private final DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();

    @Step("Открытие страницы сайта")
    public void openPage(){
        dynamicPropertiesPage.openDynamicPropsPage();
    }

    @Step("После 5 секунд ожидания должна появиться кнопка")
    public void shouldVisibleButtonAfter5Seconds(){
        dynamicPropertiesPage.shouldVisibleButtonAfter5Seconds();
    }

    @Step("После 5 секунд ожидания должен поменяться цвет текста кнопки")
    public void shouldChangeColorButtonAfter5Seconds(){
        dynamicPropertiesPage.shouldHaveClassDangerAfter5Seconds();
    }
    @Step("Должен быть текст с рандомным id")
    public void shouldHaveTextWithRandomId(){
        dynamicPropertiesPage.shouldHaveVisibleTextWithRandomId();
    }
}
