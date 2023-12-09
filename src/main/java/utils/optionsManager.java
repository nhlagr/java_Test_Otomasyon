package utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class optionsManager {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--allow-insecure-localhost");
        return options;
    }

}
