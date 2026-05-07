package ui.pages.demqa.widgets;

import config.ui.BasePage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class SliderPage extends BasePage {
    public final String URL = "https://demoqa.com/slider";

    public void openSitePage(){
        openUrl(URL);
    }

    public void checkSliderByKeys(){
        $x("//input[@id='slider']").click();
        while (75 != Integer.parseInt($("#sliderValue").getValue())){
            $x("//input[@id='slider']").sendKeys(Keys.ARROW_RIGHT);
        }
        $("#sliderValue").shouldHave(value(String.valueOf(75)));
    }
}
