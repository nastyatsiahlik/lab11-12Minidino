package test;

import model.Product;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.MinidinoHighlightsPage;
import pages.MinidinoItemPage;
import service.ProductCreator;

import static constants.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;

public class MinidinoHightlightsTest extends  CommonCondition {
    @Test
    public void goToCatalogFromHighlights() {
        AbstractPage page = new MinidinoHighlightsPage(driver)
                .openPage()
                .clickButtonGoToCatalog();
        String currentUrl = driver.getCurrentUrl();

        assertThat(currentUrl, endsWith(endCatalogUrl) );
    }

    @Test
    public void addProductToHighlights() {
        Product testProduct = ProductCreator.productForHighlights();
        String nameOfProductInHighlights = new MinidinoItemPage(driver, testProduct.getUrl())
                .openPage()
                .clickIconAddProductToHighlights()
                .clickHighlightsIcon()
                .getTextOfNameOfProductInHighlights();
        assertThat(testProduct.getName(), equalTo(nameOfProductInHighlights) );
    }
}
