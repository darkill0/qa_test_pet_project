package ui.pages.demqa.alerts;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ModalDialogsPage extends BasePage {
    private final String URL = "https://demoqa.com/modal-dialogs";
    private final SelenideElement smallBtn = $x("//button[@id='showSmallModal']");
    private final SelenideElement largeBtn = $x("//button[@id='showLargeModal']");
    public void openSitePage(){
        openUrl(URL);
    }

    public void shouldSmallModalDialog(){
        smallBtn.click();
        SelenideElement smModal = $x("//div[@class='modal-dialog modal-sm']").shouldBe(visible, Duration.ofSeconds(2));

        smModal.find(".modal-body").shouldHave(text("This is a small modal. It has very less content"));
        smModal.find("#closeSmallModal").click();
    }

    public void shouldLargeModalDialog(){
        largeBtn.click();
        SelenideElement lgModal = $x("//div[@class='modal-dialog modal-lg']").shouldBe(visible, Duration.ofSeconds(2));
        lgModal.find(".modal-body").shouldHave(text("Lorem Ipsum"));
        lgModal.find("#closeLargeModal").click();
    }
}
