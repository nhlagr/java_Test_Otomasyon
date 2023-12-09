package pages;

import constant.imdbConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.net.UnknownHostException;

public class imdbPage extends imdbConstant {

    String countOfPhotos;
    String nameOfTheDirector;
    String nameOfTheWriter;
    String nameOfTheStars;
    String nameOfTheMovie;

    public void iGoToIMDB() throws UnknownHostException {
        navigate();
    }

    public void iClickMenuButton(){
        clickJs(By.xpath(menuButtonXpath));
    }

    public void iClickOscarsButton(String parameter){
        waitVisibility(By.xpath("//div[@class='navlinkcat__listContainerInner']//ul//a//span[@class='ipc-list-item__text' and contains(text(),'"+ parameter +"')]"));
        clickJs(By.xpath("//div[@class='navlinkcat__listContainerInner']//ul//a//span[@class='ipc-list-item__text' and contains(text(),'"+ parameter +"')]"));

    }

    public void iCheckTheEventHistoryHeader(){
        isElementExist(By.xpath(eventHistoryHeaderXpath));
    }

    public void  iClickYearListButton(String parameter){
        scrollingPixel(200);
        clickJs((By.xpath("//section[@class='ipc-page-section ipc-page-section--base ipc-page-section--tp-none ipc-page-section--bp-none ipc-page-section--b-responsiveLine']//div[@role='presentation']//li[contains(text(),'"+ parameter +"')]")));

    }

    public void iClickTheChosenYearButton(String parameter){
        isElementExist(By.xpath("//div[@class='ipc-chip-list__scroller']//a//span[contains(text(),'"+ parameter +"')]"));
        clickJS(By.xpath("//div[@class='ipc-chip-list__scroller']//a//span[contains(text(),'"+ parameter +"')]"));
    }

    public void iCheckHonoraryAwardHeader(){
        moveToElement(By.xpath(honoraryAwardHeaderXpath));
        isElementExist(By.xpath(honoraryAwardHeaderXpath));
    }

    public void iClickTheMovieInTheMenu(String parameter){
        clickJS(By.xpath("//div[@class='event-widgets__original-title--primary']//a[contains(text(),'"+parameter+"')]"));
        waitVisibility(By.xpath("//div[@class='sc-d8941411-1 fTeJrK']"));
        nameOfTheDirector= getElementText(By.xpath(nameOfTheDirectorXpath));
        nameOfTheWriter = getElementText(By.xpath(nameOfTheWriterXpath));
        nameOfTheStars=getElementText(By.xpath((nameOfTheStarsXpath)));
    }


    public void iClickImdbLogo(){
        clickJS(By.xpath(imdbLogoXpath));
    }

    public void iSearchMovie(String parameter){
        sendKeys(By.xpath(searchInputXpath), parameter);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInputXpath)));
        nameOfTheMovie = parameter;
        System.out.println(nameOfTheMovie + "test");
    }



    public void iClickTheChosenMovie(){
        clickJS(By.xpath(chooseMovieInTheDropDownXpath));
        waitVisibility(By.xpath("//div[@class='sc-d8941411-1 fTeJrK']"));
        Assert.assertEquals(getElementText(By.xpath(nameOfTheDirectorXpath)), nameOfTheDirector);
        Assert.assertEquals(getElementText(By.xpath(nameOfTheWriterXpath)), nameOfTheWriter);
        Assert.assertEquals(getElementText(By.xpath(nameOfTheStarsXpath)), nameOfTheStars);

    }


    public void iClickSeeAllPhotosButton(){
        clickJs(By.xpath(seeAllPhotosXpath));
    }

    public void iClickSeeTheGalleryButton(){
        clickJS(By.xpath(seeTheGalleryButtonXpath));
    }

public void iCheckImageLinksButton(){
        waitVisibility(By.xpath(photoGallerHeaderXpath));
        countOfPhotos= getElementText(By.xpath(countOfPhotosXpath));
        findImageLinks();
}

public void iClickPhotoNextPageButton(){
        clickJS(By.xpath(galleryNextPageButtonXpath));
        Assert.assertFalse(getElementText(By.xpath(countOfPhotosXpath)).contains(countOfPhotos));

}




}
