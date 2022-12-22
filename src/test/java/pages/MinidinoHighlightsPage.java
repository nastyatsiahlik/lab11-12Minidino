package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waits;

import java.nio.charset.StandardCharsets;

public class MinidinoHighlightsPage extends AbstractPage{

    public static String HIGHLIGHTS_PAGE_URL = "https://минидино.рф/favorites/";
    public static  String MINIDINO_HIGHLIGHTS_PAGE_URL  = StandardCharsets.UTF_8.decode(StandardCharsets.UTF_8.encode(HIGHLIGHTS_PAGE_URL)).toString();

    private final String nameOfProductInHighlightsCss =  "div.category-item-description__title";
    private final String buttonGoToCatalogCss =  "div.favorites__empty>button";


    @FindBy(css = nameOfProductInHighlightsCss )
    private WebElement nameOfProductInHighlights;

    @FindBy(css = buttonGoToCatalogCss )
    private WebElement buttonGoToCatalog;

    public MinidinoHighlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTextOfNameOfProductInHighlights() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(nameOfProductInHighlightsCss));
        return nameOfProductInHighlights.getText();
    }

    public AbstractPage  clickButtonGoToCatalog() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(buttonGoToCatalogCss));
        buttonGoToCatalog.click();
        logger.info("button go to catalog pressed");
        return this ;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public MinidinoHighlightsPage openPage() {
        driver.get(MINIDINO_HIGHLIGHTS_PAGE_URL);
        return this;
    }
}
