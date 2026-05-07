package ui.pages.demqa.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DatePickerPage extends BasePage {
    private final String URL = "https://demoqa.com/date-picker";
    private final SelenideElement dateInput = $("#datePickerMonthYearInput");
    private final SelenideElement dateAndTimeInput = $("#dateAndTimePickerInput");

    public void openSitePage(){
        openUrl(URL);
    }

    public String inputDate(String day, String month, String year){
        String result = String.format("%s/%s/%s", month,day, year);
        dateInput.sendKeys(
                Keys.chord(
                        Keys.CONTROL,
                        "a"
                ),
                Keys.BACK_SPACE
        );
        dateInput.setValue(result);
        return result;
    }

    public void inputDateTime(
            int day,
            String month,
            String year,
            String time) {

        dateAndTimeInput.click();

        $(".react-datepicker__month-read-view")
                .click();

        $$(".react-datepicker__month-option")
                .findBy(text(month))
                .click();

        $(".react-datepicker__year-read-view")
                .click();

        $$(".react-datepicker__year-option")
                .findBy(text(year))
                .click();

        String formattedDay =
                String.format("%03d", day);

        $(".react-datepicker__day--" +
                formattedDay +
                ":not(.react-datepicker__day--outside-month)")
                .click();

        $$(".react-datepicker__time-list-item")
                .findBy(text(time))
                .click();
    }

    public void checkDate(String date){
        dateInput.shouldHave(value(date));
    }

    public void checkDateAndTime(String dateAndTime){
        dateAndTimeInput.shouldHave(value(dateAndTime));
    }
}
