package constants;

import java.nio.charset.StandardCharsets;

public class Constants {
    public static  String empty_cart_message = "В вашей корзине пока ничего нет.\n" +
            "Вы можете начать покупки прямо сейчас!";

    public static  String endCatalogUrl = "/catalog/";

    public static  String  search_query_for_product_by_full_name = "Шапка трикотажная ушки фламинго";

    public static  String search = "Шапка";
    public static  String search_query_for_product_by_word = StandardCharsets.UTF_8.decode(StandardCharsets.UTF_8.encode(search)).toString();

}
