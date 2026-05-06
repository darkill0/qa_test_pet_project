package ui.pages.demqa;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$x;

public class TextBoxPage extends BasePage {
    private final String URL = "https://demoqa.com/text-box";
    private final SelenideElement UserName = $x("//input[@id='userName']");
    private final SelenideElement UserEmail = $x("//input[@id='userEmail']");
    private final SelenideElement CurrentAddress = $x("//textarea[@id='currentAddress']");
    private final SelenideElement PermanentAddress = $x("//textarea[@id='permanentAddress']");
    private final SelenideElement OutputForm = $x("//div[@id='output']");
    private final SelenideElement submitButton = $x("//button[@id='submit']");

    public void openTextBoxPage() {
        openUrl(URL);
    }

    public void setInfoInTextBox(String userName, String Email, String currentAddress, String permanentAddress){
        UserName.setValue(userName);
        UserEmail.setValue(Email);
        CurrentAddress.sendKeys(currentAddress);
        PermanentAddress.sendKeys(permanentAddress);
        submitButton.click();
    }
    public void checkErrorEmailField(String email){
        UserEmail.setValue(email);
        submitButton.click();
        UserEmail.shouldHave(cssClass("field-error"));
    }

    public Map<String, String> getDataFromOutputForm(){
        SelenideElement outputName = OutputForm.$x(".//p[@id='name']");
        SelenideElement outputEmail = OutputForm.$x(".//p[@id='email']");
        SelenideElement outputCurrentAddress = OutputForm.$x(".//p[@id='currentAddress']");
        SelenideElement outputPermanentAddress = OutputForm.$x(".//p[@id='permanentAddress']");
        Map<String, String> outputData = new HashMap<>();
        outputData.put(outputName.getText().split(":")[0].trim(), outputName.getText().split(":")[1].trim());
        outputData.put(outputEmail.getText().split(":")[0].trim(), outputEmail.getText().split(":")[1].trim());
        outputData.put(outputCurrentAddress.getText().split(":")[0].trim(), outputCurrentAddress.getText().split(":")[1].trim());
        outputData.put(outputPermanentAddress.getText().split(":")[0].trim(), outputPermanentAddress.getText().split(":")[1].trim());
        return outputData;
    }
}
