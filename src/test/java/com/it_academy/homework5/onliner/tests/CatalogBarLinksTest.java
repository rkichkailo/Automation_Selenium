package com.it_academy.homework5.onliner.tests;

import com.it_academy.homework5.onliner.page_object.Header;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.it_academy.homework5.onliner.framework.DriverManager.*;
import static com.it_academy.homework5.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogBarLinksTest {

    private static final List<String> EXPECTED_CATALOG_BAR_LINKS
            = List.of("Onlíner Prime", "Электроника", "Компьютеры и сети",
            "Бытовая техника", "Стройка и ремонт", "Дом и сад",
            "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");
    private Header header;

    @BeforeClass
    public void webDriverInit(){
        header = new Header();
        startDriver();
        navigateToOnlinerHomePage();
    }

    @Test
    public void testCatalogBarHasExactLinksNames(){

        List<String> actualLinksNames =
                header.clickOnCatalogLink()
                .getCatalogBarLinksText();
        assertThat(actualLinksNames)
                .as("CatalogBarLinksNames don't match expected links")
                .isNotEmpty()
                .containsExactlyElementsOf((EXPECTED_CATALOG_BAR_LINKS));
    }

    @AfterClass
    public void weDriverClose(){
        closeDriver();
    }
}
