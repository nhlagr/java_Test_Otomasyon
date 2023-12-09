package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.driverManager;
import utils.propertiesReader;
import utils.threadLocalDriver;

import java.net.MalformedURLException;


public class hooks {

    private driverManager driverFactory;
    private static int scenarioCount = 0;
    public WebDriver driver;

    @Before
    public void launchBrowser(Scenario scenario) throws MalformedURLException {
        driverFactory = new driverManager();
        System.out.println(propertiesReader.getBrowser());
        driver = driverFactory.setDriver(propertiesReader.getBrowser());
        threadLocalDriver.setScenarioName(++scenarioCount + " " + scenario.getName());
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }



}
