package test;

import org.testng.annotations.Test;
import pages.MinidinoHomePage;

import java.util.List;

import static constants.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MinidinoSearchTest extends CommonCondition{


    @Test
    public void findByFullProductNameTest() {
        String productNameOnPage = new MinidinoHomePage(driver)
                .openPage()
                .clickTOSearchIcon()
                .enterSearchTermTOSearchLine(search_query_for_product_by_full_name)
                .getTextOfNameOfProduct();
        assertThat(productNameOnPage, equalToIgnoringCase(search_query_for_product_by_full_name));
    }

    @Test
    public void findByWordTest() {
        List<String> textOfSearchedItemes = new MinidinoHomePage(driver)
                .openPage()
                .clickTOSearchIcon()
                .enterSearchTermTOSearchLine(search_query_for_product_by_word)
                .getTextOfNameOfAllProduct();

        assertThat(textOfSearchedItemes, everyItem(containsString(search_query_for_product_by_word)));
    }
}
