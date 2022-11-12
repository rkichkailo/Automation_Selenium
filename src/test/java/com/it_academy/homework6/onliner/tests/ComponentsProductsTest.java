package com.it_academy.homework6.onliner.tests;

import com.it_academy.homework6.onliner.page_object.Header;
import org.testng.annotations.Test;

import static com.it_academy.homework6.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComponentsProductsTest {

    @Test
    public void testComponentsCategoryHasProductsWithNamesCountAndPrice(){
        navigateToOnlinerHomePage();
        new Header().clickOnCatalogLink()
                .selectCatalogBlock("Компьютеры и")
                .moveToCatalogBlockCategoryLink("Комплектующие")
                .assertEachProductHasTitle()
                .assertEachProductHasData()
                .assertEachProductHasCount()
                .assertEachProductHasPrice();
    }
}
