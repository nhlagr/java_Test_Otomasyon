package constant;

import base.basePage;

public class imdbConstant extends basePage {
    protected String menuButtonXpath="//label[@id='imdbHeader-navDrawerOpen']//span";
    protected  String eventHistoryHeaderXpath="//a[@class='ipc-title-link-wrapper']/h3";
    protected  String honoraryAwardHeaderXpath="//div[@class='event-widgets__award']//div[@class='event-widgets__award-name' and contains(text(),'Honorary Award')]";
    protected String theCircusMovieXpath="//div[@class='event-widgets__original-title--primary']//a[@href='/title/tt0018773/?ref_=ev_nom']";

    protected String nameOfTheDirectorXpath="//div[@class='sc-69e49b85-3 dIOekc']//li[@data-testid='title-pc-principal-credit'][1]//div[@class='ipc-metadata-list-item__content-container']//li[@class='ipc-inline-list__item']//a[@role='button']";
    protected String nameOfTheWriterXpath="//div[@class='sc-69e49b85-3 dIOekc']//li[@data-testid='title-pc-principal-credit'][2]//div[@class='ipc-metadata-list-item__content-container']";
    protected String nameOfTheStarsXpath="//section[@class='sc-69e49b85-4 icBxAK']//div[@class='sc-69e49b85-3 dIOekc']//li[@data-testid='title-pc-principal-credit'][3]//ul";
    protected String imdbLogoXpath="//a[@class='sc-bqGGcD rtTVk imdb-header__logo-link']";

    protected String searchInputXpath="//div[@role='combobox']//input[@type='text']";
    protected String chooseMovieInTheDropDownXpath="//li[@id='react-autowhatever-navSuggestionSearch--item-2']//div[@class='sc-fFSPgy ihPlnu']//div[@class='sc-bkbjWr pfibY searchResult__constTitle']";
    protected String seeAllPhotosXpath="//section[@data-testid='Photos']//h3";
    protected String  seeTheGalleryButtonXpath="//a[@data-testid='mv-gallery-button']";
    protected String  photoGallerHeaderXpath="//h1[@class='header']";
    protected String galleryNextPageButtonXpath="//div[@id='media_index_content']//div[@class='media_index_pagination leftright'][1]//div[@id='right']//a[@class='prevnext']";
    protected String countOfPhotosXpath="//div[@class='media_index_pagination leftright'][1]//div[@id='left']";

}
