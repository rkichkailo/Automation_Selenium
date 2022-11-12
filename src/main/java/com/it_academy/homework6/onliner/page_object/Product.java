package com.it_academy.homework6.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.onliner.framework.BasePage;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;

public class Product extends BasePage {

    public static final String PRODUCTS_ACTIVE_CATEGORY_XPATH =
            "//*[contains(@class, 'aside-item_active')]";
    public static final String PRODUCT_TITLES_XPATH
            = ".//*[contains (@class, 'list__dropdown-title')]";
    public static final String PRODUCT_DATA_XPATH
            = ".//*[contains (@class, 'list__dropdown-description')]";
    private static final String PRODUCT_COUNTER_PATTERN = "товар";
    private static final String PRODUCT_PRICE_PATTERN = "р.";

    public static ElementsCollection getProducts(){
        return $x(PRODUCTS_ACTIVE_CATEGORY_XPATH)
                .findAll("a")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    public ElementsCollection getProductsTitlesLinks(){
        return $x(PRODUCTS_ACTIVE_CATEGORY_XPATH)
                .findAll(xpath(PRODUCT_TITLES_XPATH))
                .shouldHave(sizeGreaterThan(0));
    }

    public Product assertEachProductHasTitle(){
        getProductsTitlesLinks()
                .shouldHave(noneMatch("Some categories are empty",
                element -> element.getText().isBlank()))
                .shouldHave(size(getProducts().size()));
        return this;
    }

    public ElementsCollection getProductsDataLinks(){
        return $x(PRODUCTS_ACTIVE_CATEGORY_XPATH)
                .findAll(xpath(PRODUCT_DATA_XPATH))
                .shouldHave(sizeGreaterThan(0));
    }

    public Product assertEachProductHasData(){
        getProductsDataLinks()
                .shouldHave(noneMatch("Some categories are empty",
                        element -> element.getText().isBlank()))
                .shouldHave(size(getProducts().size()));
        return this;
    }
    public Product assertEachProductHasCount(){
        getProductsDataLinks()
                .shouldHave(allMatch("Each element has count",
                        element -> element.getText()
                                .contains(PRODUCT_COUNTER_PATTERN)));
        return this;
    }
    public void assertEachProductHasPrice(){
        getProductsDataLinks()
                .shouldHave(allMatch("Each element has price",
                        element -> element.getText()
                                .endsWith(PRODUCT_PRICE_PATTERN)));
    }
}
