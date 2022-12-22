package test;

import driver.DriverSingleton;
import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import service.ProductCreator;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MinidinoTest extends CommonCondition {

   // public static String SEARCH_QUERY_FOR_COMMON_RESULTS = TestDataReader.getTestData("testdata.search_query_for_common_results");
    public static  String SEARCH_QUERY_FOR_FIND_PRODUCT_BY_FULL_NAME = "Шапка трикотажная ушки фламинго";
    public static  String SEARCH_QUERY_FOR_FIND_PRODUCT_BY_WORD = "Шапка";
   // public static  String SEARCH_QUERY_FOR_AD_PRODUCT_TO_HIGHLIGHTS = "Юбка Школа серая клетка";

    //public static  String SEARCH_QUERY_FOR_AD_PRODUCT_TO_CART = "Купальник слитный Розовый единорог";

    //public String minidiniItemUrlForHighlights = "https://минидино.рф/catalog/odezhda/platya_yubki/yubka_shkola_seraya_kletka/?offer_id=51509";
    //public String minidiniItemUrlForCart = "https://минидино.рф/catalog/aksessuary/kupalniki_i_kupalnye_plavki/kupalnik_slitnyy_rozovyy_edinorog_1/?offer_id=22947";
    //public String minidiniItemUrlForIncreaseCount = "https://минидино.рф/catalog/odezhda/dzhemper_barashek_dzhins/?offer_id=55441";


    public static  String empty_cart_message = "В вашей корзине пока ничего нет.\n" +
            "Вы можете начать покупки прямо сейчас!";

    @BeforeMethod(onlyForGroups = {"NeedAddItemToCart"})
    public void addItemToCart() {
        Product testProduct = ProductCreator.productForCart();

        new MinidinoItemPage(driver, testProduct.getUrl())
                .openPage()
                .addProductToCart();
    }


    @Test
    public void findByFullProductNameTest() {
        String productNameOnPage = new MinidinoHomePage(driver)
                .openPage()
                .clickTOSearchIcon()
                .enterSearchTermTOSearchLine(SEARCH_QUERY_FOR_FIND_PRODUCT_BY_FULL_NAME)
                .getTextOfNameOfProduct();
        assertThat(productNameOnPage, equalToIgnoringCase(SEARCH_QUERY_FOR_FIND_PRODUCT_BY_FULL_NAME));
    }

    @Test
    public void findByWordTest() {
        List<String> textOfSearchedItemes = new MinidinoHomePage(driver)
                .openPage()
                .clickTOSearchIcon()
                .enterSearchTermTOSearchLine(SEARCH_QUERY_FOR_FIND_PRODUCT_BY_WORD)
                .getTextOfNameOfAllProduct();

        assertThat(textOfSearchedItemes, everyItem(containsString(SEARCH_QUERY_FOR_FIND_PRODUCT_BY_WORD)));
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

    @Test
    public void addProductToCart() {
        Product testProduct = ProductCreator.productForCart();
        MinidinoCartPage cartPage = new MinidinoItemPage(driver, testProduct.getUrl() )
                .openPage()
                .addProductToCart();
        String nameOfProductInCart = cartPage
                .getTextOfNameOfProductInCart();

        String priceOfProductInCart = cartPage
                .getTextOfPriceOfProductInCart();

        assertThat(nameOfProductInCart, startsWith(testProduct.getName()) );
        assertThat(priceOfProductInCart, equalTo(testProduct.getPrice()) );
    }

    @Test(groups = {"NeedAddItemToCart"})
    public void deleteAllProductsFromCart() {
        String cartMessage = new MinidinoCartPage(driver)
                .openPage()
                .clickButtonDeleteAllInCart()
                .clickConfirmDeleteAllInCart()
                .getEmptyCartMessage();
        assertThat(empty_cart_message, equalTo(cartMessage) );
    }
/*
    @Test
    public void SortByPriceAscendind() throws InterruptedException {
        MinidinoCatalogOdezhdaPage sortedCatalogPage = new MinidinoCatalogOdezhdaPage(driver)
                .openPage()
                .clickToSortButton()
                .clickToSortButton()
                .clickToAscendingRadio();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Thread.sleep(2000);
        List<Integer> intListOfPrices = sortedCatalogPage.getIntPriceOfAllProduct();
        boolean result = MinidinoCatalogOdezhdaPage.isSortedAscendingIntPriceOfAllProduct(intListOfPrices);

        Assert.assertTrue(result);
    }*/

    //afterPrice == beforePrice

    @Test(groups = {"NeedAddItemToCart"})
    public void increaseCountOfProductsInCart() {

        Product testProduct = ProductCreator.productForCart();
        int priceOfProduct = Integer.parseInt(testProduct.getPrice());

        MinidinoCartPage cartPage = new MinidinoCartPage(driver)
                .openPage();

        cartPage.clickPlusCountOfProductButton();

        assertThat(Integer.parseInt(cartPage.getTextOfPriceOfProductInCart()), equalTo(priceOfProduct*cartPage.getCountOfProducts()) );
    }

    @Test
    public void goToCatalogFromHighlights() {
        AbstractPage page = new MinidinoHighlightsPage(driver)
                .openPage()
                .clickButtonGoToCatalog();
        String currentUrl = driver.getCurrentUrl();

        assertThat(currentUrl, endsWith("/catalog/") );
    }





}
