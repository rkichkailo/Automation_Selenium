package com.it_academy.homework5.onliner.tests;

import com.it_academy.homework5.onliner.page_object.CatalogBlock;
import com.it_academy.homework5.onliner.page_object.Header;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.it_academy.homework5.onliner.framework.DriverManager.closeDriver;
import static com.it_academy.homework5.onliner.framework.DriverManager.startDriver;
import static com.it_academy.homework5.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerNetworksCategoriesTest {

    private static final List<String> EXPECTED_COMPUTER_NETWORKS_CATEGORIES
            = List.of("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private Header header;

    @BeforeClass
    public void webDriverInit(){
        header = new Header();
        startDriver();
        navigateToOnlinerHomePage();
    }

    @Test
    public void testCatalogBarHasExactLinksNames(){
        CatalogBlock computerNetworks =
                header.clickOnCatalogLink()
                .selectCatalogBlock("Компьютеры и");
        assertThat(computerNetworks.getCatalogBlockCategoriesText())
                .as("Computer networks categories don't have some of expected categories")
                .containsAll(EXPECTED_COMPUTER_NETWORKS_CATEGORIES);
    }

    @AfterClass
    public void weDriverClose(){
        closeDriver();
    }
}
