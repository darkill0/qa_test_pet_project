package config.ui;

import com.codeborne.selenide.Configuration;
import config.utils.EnvConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestConfig {
    public static void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        String remote = EnvConfig.getRemote();
        if(remote != null && !remote.isEmpty()){
            Configuration.remote = remote;
        }
        Configuration.browser = "chrome";


        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 40000;
        Configuration.headless = false;
    }
}
