package test;

import model.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MinidinoCartPage;
import pages.MinidinoItemPage;
import service.ProductCreator;

import static constants.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MinidinoCartTest extends CommonCondition {

    @BeforeMethod(onlyForGroups = {"NeedAddItemToCart"})
    public void addItemToCart() {
        Product testProduct = ProductCreator.productForCart();

        new MinidinoItemPage(driver, testProduct.getUrl())
                .openPage()
                .addProductToCart();
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
    @Test(groups = {"NeedAddItemToCart"})
    public void increaseCountOfProductsInCart() {

        Product testProduct = ProductCreator.productForCart();
        int priceOfProduct = Integer.parseInt(testProduct.getPrice());

        MinidinoCartPage cartPage = new MinidinoCartPage(driver)
                .openPage();

        cartPage.clickPlusCountOfProductButton();
        int afterPrice = Integer.parseInt(cartPage.getTextOfPriceOfProductInCart());

        assertThat(afterPrice, equalTo(priceOfProduct * cartPage.getCountOfProducts()) );
    }*/
}
