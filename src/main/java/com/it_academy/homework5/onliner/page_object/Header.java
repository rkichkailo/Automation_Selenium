package com.it_academy.homework5.onliner.page_object;

import com.it_academy.homework5.onliner.framework.BasePage;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class Header extends BasePage {

    public static final String MAIN_NAVIGATION_BAR_LINKS_XPATH_PATTERN =
            "//*[@class = 'b-main-navigation__text' and contains (text(), '%s')]";

    public void clickOnMainNavigationBarLink(String link){
        waitForElementVisible(xpath(
                format(MAIN_NAVIGATION_BAR_LINKS_XPATH_PATTERN, link)))
                .click();
    }

    public CatalogPage clickOnCatalogLink(){
        clickOnMainNavigationBarLink("Каталог");
        return new CatalogPage();
    }
}
