package com.it_academy.homework5.onliner.page_object;

import com.it_academy.homework5.onliner.framework.BasePage;
import com.it_academy.homework5.onliner.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CatalogBlock extends BasePage {

    public static final String CATALOG_BLOCK_CATEGORIES_LINKS_XPATH_PATTERN
            = "//*[@style = 'display: block;']//*[contains(text(), '%s')]";
    @FindBy (xpath = "//*[@style = 'display: block;']//*[@class = 'catalog-navigation-list__aside-title']")
    private List<WebElement> catalogBlockCategories;

    public List<WebElement> getCatalogBlockCategories(){
        return waitForElementsVisible(catalogBlockCategories);
    }

    public List<String> getCatalogBlockCategoriesText(){
        return getCatalogBlockCategories()
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public Product moveToCatalogBlockCategoryLink(String link){
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(waitForElementVisible(
                By.xpath(format(CATALOG_BLOCK_CATEGORIES_LINKS_XPATH_PATTERN, link)))).
                build().perform();
        return new Product();
    }
}
