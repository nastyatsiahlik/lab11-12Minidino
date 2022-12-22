package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waits;

import java.nio.charset.StandardCharsets;

public class MinidinoHomePage extends AbstractPage{

    public static String HOME_PAGE_URL = "https://минидино.рф/";
    public static  String MINIDINO_HOME_PAGE_URL = StandardCharsets.UTF_8.decode(StandardCharsets.UTF_8.encode(HOME_PAGE_URL)).toString();

    private final String searchIconClassName = "header-main-menu-search";
    private final String searchInputXpath = "//div[@class='header-main-menu-list']//input[@type = 'search']";

    @FindBy(className = searchIconClassName)
    private WebElement searchIcon;

    // @FindBy(xpath = "/html/body/div[1]/div/header/div[2]/div[5]/div/div[3]/form/label/div/div/div/input")
    @FindBy(xpath = searchInputXpath)
    private WebElement searchInput;

    public MinidinoHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MinidinoHomePage clickTOSearchIcon(){
        Waits.waitForElementToBeClickable(driver, searchIcon);
        searchIcon.click();
        logger.info("search icon pressed");
        return this;
    }

    public MinidinoSearchResultPage enterSearchTermTOSearchLine(String searchTerm){
        Waits.waitForPresenceOfElementLocatedBy(driver, By.xpath(searchInputXpath));
        Waits.waitForElementToBeClickable(driver, searchInput);
        searchInput.sendKeys(searchTerm, Keys.ENTER);
        logger.info("search query entered");
        return new MinidinoSearchResultPage(driver);
    }


    @Override
    public MinidinoHomePage openPage() {
        driver.get(MINIDINO_HOME_PAGE_URL);
        Waits.waitForPresenceOfElementLocatedBy(driver, By.className(searchIconClassName));
        return this;
    }

}
