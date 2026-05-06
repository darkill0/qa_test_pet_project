package ui.Steps.demoqa.alerts;

import io.qameta.allure.Step;
import ui.pages.demqa.alerts.AlertsPage;

public class AlertsPageSteps {
    private final AlertsPage alertsPage = new AlertsPage();

    @Step("Открытие страницы сайта")
    public void openAlertPage(){
        alertsPage.openSitePage();
    }

    @Step("Проверка открытия alert окна")
    public void shouldOpenAlertWindow(){
        alertsPage.clickAlertBtn();
    }

    @Step("Проверка открытия alert окна после 5 секунд")
    public void shouldOpenAlertWindowAfter5Seconds(){
        alertsPage.clickAlertBtn5Second();
    }

    @Step("Проверка открытия confirm alert окна")
    public void shouldOpenConfirmAlertWindow(){
        alertsPage.clickAlertConfirmButton();
    }

    @Step("Проверка открытия confirm alert окна и нажатия cancel")
    public void shouldOpenConfirmAlertWindowWithCancel(){
        alertsPage.clickAlertConfirmButtonDismiss();
    }

    @Step("Проверка открытия promt alert окна")
    public void shouldOpenPromtAlertWindowWith(){
        alertsPage.clickPromtAlertButton();
    }
}
