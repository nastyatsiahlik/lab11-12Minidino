package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waits;

import java.util.ArrayList;
import java.util.List;

public class MinidinoSearchResultPage extends AbstractPage{

    private final String nameOfProductOnSearchResultPageCss = "div.category-item-description__title";


    @FindBy(css = nameOfProductOnSearchResultPageCss)
    private WebElement nameOfProductOnSearchResultPage;

    @FindBy(css = nameOfProductOnSearchResultPageCss)
    private List<WebElement>  listOfProductsName;


    protected MinidinoSearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTextOfNameOfProduct() {
        Waits.waitForPresenceOfElementLocatedBy(driver,By.cssSelector(nameOfProductOnSearchResultPageCss));
        return nameOfProductOnSearchResultPage.getText();
    }

    public List<String> getTextOfNameOfAllProduct() {
        ArrayList<String> itemTextList = new ArrayList<>();
        for (WebElement productItem : listOfProductsName) {
            itemTextList.add(productItem.getText());
        }
        return itemTextList;
    }










    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
