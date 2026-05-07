package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.ToolTipsPage;

public class ToolTipsPageSteps {
    private final ToolTipsPage toolTipsPage = new ToolTipsPage();

    @Step("Открытие страницы сайта")
    public void openSitePage(){
        toolTipsPage.openSitePage();
    }

    @Step("наведение на кнопку и проверка появление текста")
    public void shouldHoverAndVisibleToolTipText(){
        toolTipsPage.checkHoverToBtn();
    }
    @Step("наведение на text field и проверка появление текста")
    public void shouldHoverToTextFieldAndVisibleToolTipText(){
        toolTipsPage.checkHoverToTextField();
    }
    @Step("наведение на ссылку в тексте и проверка появление текста")
    public void shouldHoverToLinkTextAndVisibleToolTipText(){
        toolTipsPage.checkHoverToTextContrary();
    }
    @Step("наведение на ip адрес в тексте и проверка появление текста")
    public void shouldHoverIpAddressAndVisibleToolTipText(){
        toolTipsPage.checkHoverToTextNumber();
    }
}
