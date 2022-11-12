package com.it_academy.homework5.onliner.page_object;

import com.it_academy.homework5.onliner.framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.it_academy.homework5.onliner.framework.CommonWebElementUtils.getTextsFromWebElements;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class Product extends BasePage {

    @FindBy (xpath = "//*[contains(@class, 'aside-item_active')]//*[@class = 'catalog-navigation-list__dropdown-data']")
    private List<WebElement> products;
    public static final String PRODUCT_ITEMS_LINKS_XPATH_PATTERN
            = "//*[contains(@class, 'aside-item_active')]//*[contains (@class, 'list__dropdown-%s')]";

    public List<WebElement> getProducts(){
        return waitForElementsVisible(products);
    }

    public List<WebElement> getProductsTitlesLinks(){
        return waitForElementsVisible(xpath(format(
                PRODUCT_ITEMS_LINKS_XPATH_PATTERN, "title")));
    }

    public List<String> getProductsTitles(){
        return getTextsFromWebElements(getProductsTitlesLinks());
    }

    public List<WebElement> getProductsDataLinks(){
        return waitForElementsVisible(xpath(format(
                PRODUCT_ITEMS_LINKS_XPATH_PATTERN, "description")));
    }

    public List<String> getProductsData(){
        return getTextsFromWebElements(getProductsDataLinks());
    }
}
