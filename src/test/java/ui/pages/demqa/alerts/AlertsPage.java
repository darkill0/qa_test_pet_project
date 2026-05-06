package ui.pages.demqa.alerts;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertsPage extends BasePage {
    private final String URL = "https://demoqa.com/alerts";
    private final SelenideElement alertButton = $x("//button[@id='alertButton']");
    private final SelenideElement alert5SecondsButton = $x("//button[@id='timerAlertButton']");
    private final SelenideElement alertConfirmButton = $x("//button[@id='confirmButton']");
    private final SelenideElement promtAlertButton = $x("//button[@id='promtButton']");

    public void openSitePage(){
        openUrl(URL);
    }

    public void clickAlertBtn(){
        alertButton.click();
        confirm("You clicked a button");
    }

    public void clickAlertBtn5Second(){
        alert5SecondsButton.click();
        Wait().until(alertIsPresent());
        confirm("This alert appeared after 5 seconds");
    }

    public void clickAlertConfirmButton(){
        alertConfirmButton.click();
        confirm("Do you confirm action?");
        $x("//span[@id='confirmResult']").shouldHave(text("OK"));

    }

    public void clickAlertConfirmButtonDismiss(){
        alertConfirmButton.click();
        dismiss("Do you confirm action?");
        $x("//span[@id='confirmResult']").shouldHave(text("Cancel"));

    }

    public void clickPromtAlertButton(){
        promtAlertButton.click();
        switchTo().alert().sendKeys("Test");
        switchTo().alert().accept();
        $x("//span[@id='promptResult']").shouldHave(text("entered Test"));

    }
}
