package ui.Steps.demoqa;

import io.qameta.allure.Step;
import ui.pages.demqa.DownloadPage;

public class DownloadPageSteps {
    private final DownloadPage downloadPage = new DownloadPage();

    @Step("открытие страницы сайта")
    public  void shouldOpenSitePage(){
        downloadPage.openDownloadPage();
    }
    @Step("Скачивание файла")
    public void shouldDownloadFile(){
        downloadPage.clickDownloadAndCheckFile();
    }

    @Step("Закачка файла на сайт")
    public void shouldUploadFile(){
        downloadPage.clickAndAddFileToUpload();
    }
}
