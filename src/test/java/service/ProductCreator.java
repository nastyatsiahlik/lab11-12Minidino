package service;

import model.Product;

public class ProductCreator {

    //public static  String TESTDATA_TO_CART_PRODUCT_NAME =  "testdata.product.nameForCart";
    //public static  String TESTDATA_TO_CART_PRODUCT_PRICE =  "testdata.product.priceForCart";
    //public static  String TESTDATA_TO_CART_PRODUCT_URL =  "testdata.product.urlForCart";

    public static  String TESTDATA_TO_CART_PRODUCT_NAME = "Комбинезон для сна принт лыжник";
    public static  String TESTDATA_TO_CART_PRODUCT_PRICE = "1890";
    public static  String TESTDATA_TO_CART_PRODUCT_URL = "https://минидино.рф/catalog/odezhda/kombinezon_dlya_sna_print_lyzhnik/?offer_id=55555";

    public static  String TESTDATA_TO_HIGHLIGHTS_PRODUCT_NAME = "Юбка Школа серая клетка";
    public static  String TESTDATA_TO_HIGHLIGHTS_PRODUCT_PRICE = "999";
    public static  String TESTDATA_TO_HIGHLIGHTS_PRODUCT_URL =  "https://минидино.рф/catalog/odezhda/platya_yubki/yubka_shkola_seraya_kletka/?offer_id=51509";

    public static Product productForCart(){
        return new Product(TESTDATA_TO_CART_PRODUCT_NAME, TestDataReader.getTestData(TESTDATA_TO_CART_PRODUCT_PRICE), TESTDATA_TO_CART_PRODUCT_URL);
    }

    public static Product productForHighlights(){
        return new Product(TESTDATA_TO_HIGHLIGHTS_PRODUCT_NAME, TESTDATA_TO_HIGHLIGHTS_PRODUCT_PRICE, TESTDATA_TO_HIGHLIGHTS_PRODUCT_URL);
    }


}
