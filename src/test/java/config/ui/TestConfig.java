package config.ui;

import com.codeborne.selenide.Configuration;
import config.utils.EnvConfig;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestConfig {
    public static void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--window-size=1920,1080"
        );
//        String remote = EnvConfig.getRemote();
//        if(remote != null && !remote.isEmpty()){
//            Configuration.remote = remote;
//        }
        Configuration.browser = "chrome";


        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 50000;
        Configuration.headless = true;
    }
}
