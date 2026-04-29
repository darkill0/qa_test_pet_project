package config.ui;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public void openUrl(String url)
    {
        open(url);
    }
}
