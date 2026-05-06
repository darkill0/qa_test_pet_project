package ui.pages.demqa.Elements;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LinksPage extends BasePage {

    private final String URL = "https://demoqa.com/links";
    private final SelenideElement homeLink = $x("//a[@id='simpleLink']");
    private final SelenideElement dynamicLink = $x("//a[@id='dynamicLink']");
    private final SelenideElement createdLink = $x("//a[@id='created']");
    private final SelenideElement noContentLink = $x("//a[@id='no-content']");
    private final SelenideElement movedLink = $x("//a[@id='moved']");
    private final SelenideElement badRequestLink = $x("//a[@id='bad-request']");
    private final SelenideElement unauthorizedLink = $x("//a[@id='unauthorized']");
    private final SelenideElement forbiddenLink = $x("//a[@id='forbidden']");
    private final SelenideElement invalidUrlLink = $x("//a[@id='invalid-url']");
    private final SelenideElement responseLink = $x("//p[@id='linkResponse']");

    public void openPage(){
        openUrl(URL);
    }

    public void openHomeLink(){
        homeLink.click();
        Wait().until(d -> d.getWindowHandles().size() > 1);
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
    }

    public void openDynamicHomeLink(){
        dynamicLink.click();
        Wait().until(d -> d.getWindowHandles().size() > 1);
        switchTo().window(1);
        closeWindow();
        switchTo().window(0);
    }

    public void shouldContainsCreatedLinkDataApi(){
        createdLink.click();
        responseLink.shouldHave(text("Link has responded with staus 201 and status text Created"));
    }

    public void shouldContainsNoContentLinkDataApi(){
        noContentLink.click();
        responseLink.shouldHave(text("Link has responded with staus 204 and status text No Content"));
    }
    public void shouldContainsMovedLinkDataApi(){
        movedLink.click();
        responseLink.shouldHave(text("Link has responded with staus 301 and status text Moved Permanently"));
    }
    public void shouldContainsBadRequestLinkDataApi(){
        badRequestLink.click();
        responseLink.shouldHave(text("Link has responded with staus 400 and status text Bad Request"));
    }

    public void shouldContainsUnauthorizedLinkDataApi(){
        unauthorizedLink.click();
        responseLink.shouldHave(text("Link has responded with staus 401 and status text Unauthorized"));
    }

    public void shouldContainsForbiddenLinkDataApi(){
        forbiddenLink.click();
        responseLink.shouldHave(text("Link has responded with staus 403 and status text Forbidden"));
    }

    public void shouldContainsInvalidUrlLinkDataApi(){
        invalidUrlLink.click();
        responseLink.shouldHave(text("Link has responded with staus 404 and status text Not Found"));
    }

}
