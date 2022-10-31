package com.it_academy.homework5.onliner.tests;

import com.it_academy.homework5.onliner.page_object.Header;
import com.it_academy.homework5.onliner.page_object.Product;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.it_academy.homework5.onliner.framework.DriverManager.closeDriver;
import static com.it_academy.homework5.onliner.framework.DriverManager.startDriver;
import static com.it_academy.homework5.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;
import static org.assertj.core.api.Assertions.assertThat;

public class ComponentsProductsTest {

    private static final String PRODUCT_TITLE_PATTERN = "\\s+";
    private static final String PRODUCT_COUNTER_PATTERN = "товар";
    private static final String PRODUCT_PRICE_PATTERN = "р.";
    private Header header;

    @BeforeClass
    public void webDriverInit(){
        header = new Header();
        startDriver();
        navigateToOnlinerHomePage();
    }

    @Test
    public void testComponentsCategoryHasProductsWithNamesAndPrice(){
        Product products =
                    header.clickOnCatalogLink()
                    .selectCatalogBlock("Компьютеры и")
                    .moveToCatalogBlockCategoryLink("Комплектующие");
        int actualProductCount = products.getProductsCount();
        List<String>actualProductsTitles = products.getProductsTitles();
        List<String>actualProductsData = products.getProductsData();

        assertThat(actualProductsTitles)
                .as("Product(s) doesn't have title")
                .isNotEmpty()
                .noneMatch(el -> el.matches(PRODUCT_TITLE_PATTERN))
                .hasSize(actualProductCount);
        assertThat(actualProductsData)
                .as ("Product(s) doesn't have counter")
                .isNotEmpty()
                .allMatch(el -> el.contains(PRODUCT_COUNTER_PATTERN))
                .hasSize(actualProductCount);
        assertThat(actualProductsData)
                .as ("Product(s) doesn't have price")
                .allMatch(el -> el.endsWith(PRODUCT_PRICE_PATTERN));
    }

    @AfterClass
    public void weDriverClose(){
        closeDriver();
    }
}
