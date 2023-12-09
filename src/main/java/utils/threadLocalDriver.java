package utils;

import org.openqa.selenium.WebDriver;

public class threadLocalDriver {

    private static ThreadLocal<WebDriver> myThreadLocal = new ThreadLocal<WebDriver>();
    private static ThreadLocal <String> scenarioName = new ThreadLocal<>();

    public static void setDriverToThreadLocalDriver (WebDriver driver) { myThreadLocal.set(driver); }

    public static WebDriver getDriverFromThreadLocalDriver() {
        return myThreadLocal.get();
    }

    public static void setScenarioName(String setScenarioName) {
        scenarioName.set(setScenarioName);
    }

    public static String getScenarioName() { return scenarioName.get(); }






}
