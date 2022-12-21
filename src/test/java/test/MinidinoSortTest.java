package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MinidinoCatalogOdezhdaPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class MinidinoSortTest extends CommonCondition{
    @Test
    public void SortByPriceAscending() throws InterruptedException {
        MinidinoCatalogOdezhdaPage sortedCatalogPage = new MinidinoCatalogOdezhdaPage(driver)
                .openPage()
                .clickToSortButton()
                .clickToSortButton()
                .clickToAscendingPriceRadio();

        List<Integer> intListOfPrices = sortedCatalogPage.getIntPriceOfAllProduct();
        List<Integer> sortedPrices = intListOfPrices.stream().sorted().collect(Collectors.toList());
      //  boolean result = MinidinoCatalogOdezhdaPage.isSortedAscendingIntPriceOfAllProduct(intListOfPrices);

        assertThat(String.valueOf(intListOfPrices), equals(sortedPrices));
    }

    @Test
    public void SortByNameAscending() {
        MinidinoCatalogOdezhdaPage sortedCatalogPage = new MinidinoCatalogOdezhdaPage(driver)
                .openPage()
                .clickToSortButton()
                .clickToSortButton()
                .clickToAscendingNameRadio();

        List<String> listOfNames = sortedCatalogPage.getTextOfNameOfAllProduct();
        List<String> sortedNames = listOfNames.stream().sorted().collect(Collectors.toList());

        assertThat(String.valueOf(listOfNames), equals(sortedNames));
    }
}

