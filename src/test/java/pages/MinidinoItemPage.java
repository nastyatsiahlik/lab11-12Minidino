package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waits;

public class MinidinoItemPage extends AbstractPage{

    public String url;

    private final String iconAddToHighlightsCss =  "div.product-detail-icons__favorites";
    private final String highlightsIconCss =  " div.header-main-menu-item__icon--favorites";
    private final String addToCartButtonCss =  "div.product-detail__buy>button";
    private final String goToCartButtonCss =  "div.header-cart-notify__bottom>button";

    @FindBy(css = iconAddToHighlightsCss)
    private WebElement iconAddToHighlights;

    @FindBy(css = highlightsIconCss)
    private WebElement highlightsIcon;

    @FindBy(css = addToCartButtonCss)
    private WebElement addToCartButton;

    @FindBy(css = goToCartButtonCss)
    private WebElement goToCartButton;


    public MinidinoItemPage(WebDriver driver, String url) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.url = url;
    }

    public MinidinoItemPage clickIconAddProductToHighlights() {
        Waits.waitForElementToBeClickable(driver, iconAddToHighlights);
        iconAddToHighlights.click();
        return this;
    }
    public MinidinoHighlightsPage clickHighlightsIcon() {
        Waits.waitForElementToBeClickable(driver, highlightsIcon);
        highlightsIcon.click();
        return new MinidinoHighlightsPage(driver);
    }

    public MinidinoCartPage addProductToCart() {
        Waits.waitForElementToBeClickable(driver, addToCartButton);
        addToCartButton.click();
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(goToCartButtonCss));
        Waits.waitForElementToBeClickable(driver, goToCartButton);
        goToCartButton.click();

        return new MinidinoCartPage(driver);
    }


    @Override
    public MinidinoItemPage openPage() {
        driver.get(url);
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(iconAddToHighlightsCss));
        return this;
    }
}
