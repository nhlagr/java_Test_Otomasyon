package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driverManager;
import utils.propertiesReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class basePage {
    String url = "";
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor jsExec;
    protected static final Logger log = LogManager.getLogger(basePage.class);
    public Duration waitSecond = Duration.ofSeconds(40);

    public void navigate() throws UnknownHostException {
        driver= driverManager.getDriver();
        jsExec= (JavascriptExecutor) driver;
        driver.get(propertiesReader.getUrl());
        driver.manage().window().maximize();
    }


    public void tearDown(){
        driver.quit();
    }

//  FİND

    public WebElement find(By by) {
        waitForLoad();
        waitPresence(by);
        WebElement element = driver.findElement(by);
        log.info(Thread.currentThread().getName() + " : " + by + " elementi bulundu.");
        return element;
    }

    public List<WebElement> finds(By by) {
        waitForLoad();
//		if(PropertiesReader.getBrowser().equalsIgnoreCase("chrome")){
//			ajaxWaiter.waitAllRequest();
//    }
        waitPresence(by);
        List<WebElement> ListElement = driver.findElements(by);
        log.info(Thread.currentThread().getName() + " : " + by + " elementleri bulundu.");
        return ListElement;
    }


//  CLİCK

    public void clickElement(By by) {
        waitForLoad();
        find(by).click();
    }

    public void doubleClick(By by) {
        Actions act = new Actions(driver);
        WebElement doubleClick = find(by);
        act.doubleClick(doubleClick).perform();
    }

    public void rightClick(By by) {
        Actions act = new Actions(driver);
        WebElement rightClick = find(by);
        act.contextClick(rightClick).perform();
    }

    public void clickJs(By by) {
        WebElement element = find(by);
        jsExec.executeScript("arguments[0].click();", element);
        log.info(Thread.currentThread().getName() + " : " + by + " elementine JS ile tıklandı.");
    }

    public void clickJS(WebElement element, String elementName) {
        waitForLoad();
        jsExec.executeScript("arguments[0].click();", element);
        log.info(Thread.currentThread().getName() + " : " + elementName + " elementine JS ile tıklandı.");
    }

    public void clickJS(By by) {
        WebElement element =find(by);
        jsExec.executeScript("arguments[0].click();", element);
        log.info(Thread.currentThread().getName()+" : "+by+" elementine JS ile tıklandı.");
    }


    public void switchTab(int index) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public void switchTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        System.out.println(driver.switchTo().window(tabs.get(tabs.size() - 1)));
    }

    public void switchToFrame(By by) {
        driver.switchTo().frame(find(by));
    }


    public void switchWindow() {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            wait(2);
            driver.switchTo().window(winHandleBefore);
        }
    }


//  SENDKEYS

    public void sendKeys(WebElement element, String text) {
        waitForLoad();
        element.sendKeys(text);
        log.info(Thread.currentThread().getName() + " : " + element + " elementine " + text + " yazılıyor.");
    }

    public void sendKeys(By by, String text) {
        waitForLoad();
        find(by).clear();
        find(by).sendKeys(text);
        log.info(Thread.currentThread().getName() + ": " + by + " elementine " + text + " + yazıldı.");
    }

//  WAIT

    public WebElement waitPresence(By by) {
        wait = new WebDriverWait(driver, waitSecond);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForLoad() {
        new WebDriverWait(driver, waitSecond).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitVisibility(By by) {
        wait = new WebDriverWait(driver, waitSecond);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getDateTime() {
        //SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }


//  BROWSER OPTIONS

    public String getBrowserName() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        return browserName;
    }


// SCROLL

    public void scrollingPixel(int pixel) {
        jsExec.executeScript("window.scrollBy(0," + pixel + ")", "");
        System.out.println(driver);
        System.out.println("Scroll edildi.");


    }

    public void moveToElement(By by){
        Actions actions = new Actions(driver);
        WebElement elementToMove = find(by);
        actions.moveToElement(elementToMove).perform();
    }


    //     ######################## EXİST AND DİSPLAYED #########################

    public boolean isElementExist(By by) {
        if (driver.findElements(by).size() > 0) {
            log.info(Thread.currentThread().getName() + " : " + by + " elementi var.");
            return true;
        } else {
            log.info(Thread.currentThread().getName() + " : " + by + " elementi yok.");
            return false;
        }
    }

//       GET AND SET ELEMENTS

    public String getElementText(By by) {
        return find(by).getText();
    }


    public void findImageLinks() {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total images on the Web Page: " + images.size());

        for (WebElement image : images) {
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);
        }
    }

    public static void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            // Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " is a broken link or image");
            }

            // Fetching and Printing the response code obtained
            else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
