package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waits;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class MinidinoCatalogOdezhdaPage extends  AbstractPage{

    public static String CATALOG_PAGE_URL = "https://минидино.рф/catalog/odezhda/";
    public static  String MINIDINO_CATALOG_PAGE_URL  = StandardCharsets.UTF_8.decode(StandardCharsets.UTF_8.encode(CATALOG_PAGE_URL)).toString();

    private final String sortButtonCss = "div#sort";
    private final String ascendingPriceRadioXpath ="//*[@id=\"category-settings\"]/div[1]/div[2]/div/div[2]/div[2]/div";
    private final String ascendingNameRadioXpath ="//*[@id=\"category-settings\"]/div[1]/div[2]/div/div[2]/div[4]";
    private final String priceOfProductCss = "span.category-item-description__price";
    private final String categoryDivCss = "div.category-list";
    private final String nameOfAllProductCss = "category-item-description__title";

    @FindBy(css = sortButtonCss)
    private WebElement sortButton;

    @FindBy(xpath =ascendingPriceRadioXpath)
    private WebElement  ascendingPriceRadio;

    @FindBy(xpath =ascendingNameRadioXpath)
    private WebElement  ascendingNameRadio;

    @FindBy(css =priceOfProductCss)
    private List<WebElement>  listOfProductsPrice;

    @FindBy(css = nameOfAllProductCss)
    private List<WebElement>  listOfProductsName;

    @FindBy(css =categoryDivCss)
    private WebElement categoryDiv;

    public MinidinoCatalogOdezhdaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MinidinoCatalogOdezhdaPage clickToSortButton(){
        Waits.waitForElementToBeClickable(driver, sortButton);
        sortButton.click();
        logger.info("sort button pressed");
        return this;
    }

    public MinidinoCatalogOdezhdaPage clickToAscendingPriceRadio(){
        Waits.waitForPresenceOfElementLocatedBy(driver, By.xpath(ascendingPriceRadioXpath));
        Waits.waitForElementToBeClickable(driver, ascendingPriceRadio);
        ascendingPriceRadio.click();
        logger.info("ascending price radio pressed");
        return this;
    }


    public List<Integer> getIntPriceOfAllProduct() {
        Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(priceOfProductCss));

        ArrayList<Integer> itemPriceTextList = new ArrayList<>();
        for (WebElement productItem : listOfProductsPrice) {
            itemPriceTextList.add(Integer.parseInt(productItem.getText().replaceAll("\\s", "")));
        }
        logger.info("List of prices" + itemPriceTextList);
        return itemPriceTextList;
    }

    public List<String> getTextOfNameOfAllProduct() {
        ArrayList<String> itemTextList = new ArrayList<>();
        for (WebElement productItem : listOfProductsName) {
            itemTextList.add(productItem.getText());
        }
        return itemTextList;
    }

    public MinidinoCatalogOdezhdaPage clickToAscendingNameRadio(){
        Waits.waitForPresenceOfElementLocatedBy(driver, By.xpath(ascendingNameRadioXpath));
        Waits.waitForElementToBeClickable(driver, ascendingNameRadio);
        ascendingNameRadio.click();
        logger.info("ascending name radio pressed");
        //  Waits.waitForPresenceOfElementLocatedBy(driver, By.cssSelector(categoryDivCss));
        return this;
    }

    public static boolean isSortedAscendingIntPriceOfAllProduct(List<Integer> intPricesList) {
        for(int i=0; i<intPricesList.size()-1;i++ )
        {
            if(intPricesList.get(i)>intPricesList.get(i+1))
                return false;
        }
        return true;
    }

    @Override
    public MinidinoCatalogOdezhdaPage openPage() {
        driver.get(MINIDINO_CATALOG_PAGE_URL);
        return this;
    }
}
