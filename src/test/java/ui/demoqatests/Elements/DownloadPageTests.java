package ui.demoqatests.Elements;

import config.ui.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.Steps.demoqa.Elements.DownloadPageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("upload_download_ui_tests")
@DisplayName("[UI] Тестирование скачивание и закачку файла на сайт")
@Epic("загрузка и скачивание файлов")
public class DownloadPageTests extends BaseTest {
    private final DownloadPageSteps downloadPageSteps = new DownloadPageSteps();


    @Test
    @Tag("smoke_test")
    @DisplayName("тестирование скачивания файла")
    @Owner("Ilya Koltsov")
    @Feature("Скачка файла")
    public void checkDownloadFile(){
        downloadPageSteps.shouldOpenSitePage();
        downloadPageSteps.shouldDownloadFile();
    }

    @Test
    @Tag("smoke_test")
    @DisplayName("тестирование загрузки файла")
    @Owner("Ilya Koltsov")
    @Feature("загрузка файла")
    public void checkUploadFile(){
        downloadPageSteps.shouldOpenSitePage();
        downloadPageSteps.shouldUploadFile();
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
