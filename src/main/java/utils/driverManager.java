package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverManager {
    optionsManager optionsManager = new optionsManager();

    public WebDriver setDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeDriver chromeDriver = new ChromeDriver();
            threadLocalDriver.setDriverToThreadLocalDriver(chromeDriver);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        } else if (browserName.equalsIgnoreCase("safari")) {
            threadLocalDriver.setDriverToThreadLocalDriver(new SafariDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            threadLocalDriver.setDriverToThreadLocalDriver(new EdgeDriver());
        } else if (browserName.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();

        }
        return getDriver();

    }
         public static synchronized WebDriver getDriver(){
        return threadLocalDriver.getDriverFromThreadLocalDriver();
    }
}


