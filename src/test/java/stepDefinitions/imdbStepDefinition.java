package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.imdbPage;

import java.net.UnknownHostException;

public class imdbStepDefinition {
   imdbPage imdbPage = new imdbPage();


    @And("^I go to imdb page$")
    public void iGoToIMDB() throws UnknownHostException {
        imdbPage.iGoToIMDB();
    }

    @And("^I click the menu button$")
    public void iClickMenuButton(){
        imdbPage.iClickMenuButton();
    }

    @And("^I click the (.*) button in the menu list$")
    public void iClickOscarsButton(String parameter){
        imdbPage.iClickOscarsButton(parameter);
    }

    @And("^I check the event history header$")
    public void iCheckTheEventHistoryHeader(){
        imdbPage.iCheckTheEventHistoryHeader();

    }

    @And ("^I click the (.*) list button$")
    public void iClickYearListButton(String parameter){
        imdbPage.iClickYearListButton(parameter);
    }

    @And("^I click the (.*) chosen year button$")
    public void iClickTheChosenYearButton(String parameter){
        imdbPage.iClickTheChosenYearButton(parameter);
    }

    @And("^I check the honorary award header$")
    public void iCheckHonoraryAwardHeader(){
        imdbPage.iCheckHonoraryAwardHeader();
    }

    @And("^I click (.*) movie in the menu$")
    public void iClickTheCircusMovie(String parameter){
        imdbPage.iClickTheMovieInTheMenu(parameter);
    }
    @And("^I click the imdb logo$")
    public void iClickImdbLogo(){
        imdbPage.iClickImdbLogo();
    }

    @And("^I search (.*) movie$")
    public void iSearchMovie(String parameter){
        imdbPage.iSearchMovie(parameter);
    }


    @And("^I click the chosen movie$")
    public void iClickTheChosenMovie(){
        imdbPage.iClickTheChosenMovie();
    }

    @And("^I click the see all photos button$")
    public void iClickSeeAllPhotosButton(){
        imdbPage.iClickSeeAllPhotosButton();
    }
    @And("^I click see the gallery button$")

    public void iClickSeeTheGalleryButton(){
        imdbPage.iClickSeeTheGalleryButton();
    }

    @And("^I check image links button$")
    public void iCheckImageLinksButton(){
        imdbPage.iCheckImageLinksButton();
    }
    @And("^I click photo next page button$")
    public void iClickPhotoNextPageButton(){
        imdbPage.iClickPhotoNextPageButton();
    }

}
