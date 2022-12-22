package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waits;

import java.nio.charset.StandardCharsets;
import java.time.Duration;


public class MinidinoCartPage extends AbstractPage{

    public static String CART_PAGE_URL = "https://минидино.рф/cart";
    public static  String MINIDINO_CART_PAGE_URL  = StandardCharsets.UTF_8.decode(StandardCharsets.UTF_8.encode(CART_PAGE_URL)).toString();

    private final String nameOfProductInCartCss =  "div.basket-item-info__top>a";
    private final String deleteAllButtonCss =  "div.header-cart__link";
    private final String confirmDeleteAllButtonXpath =  "//*[@id=\"layout\"]/div[1]/div/div[3]/div[2]/button[2]";
    private final String emptyCartMessageCss =  "div.header-cart__text";
    private final String plusCountOfProductButtonCss = "div.basket-item-info div.basket-item-counter-panel__option--plus";
    private final String countOfProductsCss = "div.basket-item-info div.basket-item-counter-panel__value";
    private final String priceOfProductInCartCss = "div.basket-item-info div.basket-item-counter__price";

    @FindBy(css = nameOfProductInCartCss)
    private WebElement nameOfProductInCart;

    @FindBy(css = deleteAllButtonCss)
    private WebElement deleteAllButton;

    @FindBy(xpath = confirmDeleteAllButtonXpath)
    private WebElement confirmDeleteAllButton;

    @FindBy(css = emptyCartMessageCss)
    private WebElement emptyCartMessage;

    @FindBy(css = plusCountOfProductButtonCss)
    private WebElement plusCountOfProductButton;

    @FindBy(css = countOfProductsCss)
    private WebElement countOfProducts;

    @FindBy(css = priceOfProductInCartCss)
    private WebElement priceOfProductInCart;

    public MinidinoCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTextOfNameOfProductInCart() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(nameOfProductInCartCss));
        logger.info("Name of product in cart: " + nameOfProductInCart.getText());
        return nameOfProductInCart.getText();
    }

    public String getTextOfPriceOfProductInCart() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(nameOfProductInCartCss));
        logger.info("Price of product: "+ priceOfProductInCart.getText().replaceAll("\\s", ""));
        return priceOfProductInCart.getText().replaceAll("\\s", "");
    }


    public MinidinoCartPage clickButtonDeleteAllInCart() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(deleteAllButtonCss));
        deleteAllButton.click();
        logger.info("Button delete all in cart pressed");
        return this;
    }

    public MinidinoCartPage clickConfirmDeleteAllInCart() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.xpath(confirmDeleteAllButtonXpath));
        confirmDeleteAllButton.click();
        logger.info("Button confirm delete all in cart pressed");
        return this;
    }

    public String getEmptyCartMessage() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(emptyCartMessageCss));
        return emptyCartMessage.getText();
    }

    public MinidinoCartPage clickPlusCountOfProductButton() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(plusCountOfProductButtonCss));
        Waits.waitForElementToBeClickable(driver, plusCountOfProductButton);
        plusCountOfProductButton.click();
        logger.info("Button plus count of product pressed");
        return this;
    }

    public int getCountOfProducts() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(countOfProductsCss));
        int countOfProduct = Integer.parseInt(countOfProducts.getText());
        logger.info("Count of product: "+ countOfProduct);
        return countOfProduct;
    }








    @Override
    public MinidinoCartPage openPage() {
        driver.get(MINIDINO_CART_PAGE_URL);
        return this;
    }
}
