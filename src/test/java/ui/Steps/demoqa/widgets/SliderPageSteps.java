package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.SliderPage;

public class SliderPageSteps {
    private final SliderPage sliderPage = new SliderPage();

    @Step("Открытие страницы сайта")
    public void openSitePage(){
        sliderPage.openSitePage();
    }

    @Step("Проверка слайдера")
    public void shouldSlideTo75Percentage(){
        sliderPage.checkSliderByKeys();
    }
}
