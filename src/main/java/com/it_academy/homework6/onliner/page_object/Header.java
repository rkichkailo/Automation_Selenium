package com.it_academy.homework6.onliner.page_object;

import com.it_academy.homework6.onliner.framework.BasePage;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;

public class Header extends BasePage {

    public static final String MAIN_NAVIGATION_BAR_LINKS = "//*[@class = 'b-main-navigation__text']";

    public void clickOnMainNavigationBarLink(String link){
        $$x(MAIN_NAVIGATION_BAR_LINKS)
                .findBy(text(link))
                .shouldBe(and("clickable", visible, enabled))
                .click();
    }

    public CatalogPage clickOnCatalogLink(){
        clickOnMainNavigationBarLink("Каталог");
        return new CatalogPage();
    }

    public void hoverOverMainNavigationBarLink(String link){
        $$x(MAIN_NAVIGATION_BAR_LINKS)
                .findBy(text(link))
                .shouldBe(and("clickable", visible, enabled))
                .hover();
    }

    public void assertMainNavigationBarIsDisplayed(){
        $$x(MAIN_NAVIGATION_BAR_LINKS)
                .shouldHave(allMatch("some elements are not visible",
                        WebElement::isDisplayed));
    }
}