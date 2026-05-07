package ui.Steps.demoqa.widgets;

import io.qameta.allure.Step;
import ui.pages.demqa.widgets.DatePickerPage;

public class DatePickerPageSteps {
    private final DatePickerPage datePickerPage = new DatePickerPage();

    @Step("Открытие страницы сайта")
    public void openSitePage(){
        datePickerPage.openSitePage();
    }
    @Step("Ввод даты")
    public String inputOnlyDate(String day, String month, String year){
       return datePickerPage.inputDate(day, month, year);
    }
    @Step("Проверка введенной даты")
    public void checkDateInputValue(String date){
        datePickerPage.checkDate(date);
    }

    @Step("Ввод даты и времени")
    public String inputDateAndTime(int day, String month, String year, String time){
        datePickerPage.inputDateTime(day, month, year, time);
        return String.format("%s %d, %s %s", month, day, year, time);
    }
    @Step("Проверка введенной даты и времени")
    public void checkDateAndTimeInputValue(String date){
        datePickerPage.checkDateAndTime(date);
    }


}
