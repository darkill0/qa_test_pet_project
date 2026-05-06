package ui.pages.demqa.Elements;

import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.Base64;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DownloadPage extends BasePage {
    private final String URL = "https://demoqa.com/upload-download";
    private final SelenideElement downloadBtn = $x("//a[@id='downloadButton']");
    private final SelenideElement uploadForm = $x("//input[@id='uploadFile']");


    public void openDownloadPage(){
        openUrl(URL);
    }

    public void clickDownloadAndCheckFile() {
        // Получаем data URL из атрибута href
        String dataUrl = downloadBtn.getAttribute("href");

        // Проверяем, что это data URL
        Assertions.assertTrue(dataUrl.startsWith("data:image/jpeg;base64,"));

        // Извлекаем base64 часть
        String base64Data = dataUrl.substring(dataUrl.indexOf(",") + 1);

        // Декодируем base64 в байты
        byte[] imageBytes = Base64.getDecoder().decode(base64Data);

        // Проверяем магические числа JPEG (FF D8 FF)
        Assertions.assertEquals((byte) 0xFF, imageBytes[0]);
        Assertions.assertEquals((byte) 0xD8, imageBytes[1]);
        Assertions.assertEquals((byte) 0xFF, imageBytes[2]);

        // Проверяем размер файла (не должен быть пустым)
        Assertions.assertTrue(imageBytes.length > 1000);


    }

    public void clickAndAddFileToUpload(){

        uploadForm.uploadFile(new File("src/test/resources/sampleFile.jpeg"));
        SelenideElement uploadPath = $x("//p[@id='uploadedFilePath']");
        uploadPath.shouldHave(text("sampleFile.jpeg"));
    }

}
