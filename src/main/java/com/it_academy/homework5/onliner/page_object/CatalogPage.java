package com.it_academy.homework5.onliner.page_object;

import com.it_academy.homework5.onliner.framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class CatalogPage extends BasePage {

    @FindBy (xpath = "//*[@class = 'catalog-navigation-classifier__item-title-wrapper']")
    private List<WebElement> catalogBarLinks;
    public static final String CATALOG_BAR_LINKS_XPATH_PATTERN =
        "//*[contains(@class, 'catalog-navigation-classifier__item') and contains(text(), '%s')]";

    public CatalogBlock selectCatalogBlock(String link){
        waitForElementVisible(xpath(
                format(CATALOG_BAR_LINKS_XPATH_PATTERN, link)))
                .click();
        return new CatalogBlock();
    }

    public List<WebElement> getCatalogBarLinks(){
        return waitForElementsVisible(catalogBarLinks);
    }

    public List<String> getCatalogBarLinksText(){
        return getCatalogBarLinks()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
