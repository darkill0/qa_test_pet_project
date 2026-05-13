package config.ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestConfig {
    public static void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";

        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 40000;
        Configuration.headless = false;
    }
}
