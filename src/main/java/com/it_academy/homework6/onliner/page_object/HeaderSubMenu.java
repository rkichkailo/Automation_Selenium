package com.it_academy.homework6.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.homework6.onliner.framework.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.it_academy.homework6.onliner.framework.CommonSelElementUtils.assertTextsFromTwoListsMatch;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;

public class HeaderSubMenu extends BasePage {

    private static  final String SUBMENU_XPATH = "//*[contains(@class, 'dropdown_visible')]";
    private static  final String SUBMENU_CATEGORIES_XPATH_PATTERN = ".//li/a[contains(@href, '%s')]";

    public void assertSubMenuIsDisplayed(){
        $x(SUBMENU_XPATH)
                .shouldBe(visible, ofSeconds(10));
    }
    public ElementsCollection getSubmenuLinks(String category){
        return $x(SUBMENU_XPATH)
                .findAll(xpath(format(SUBMENU_CATEGORIES_XPATH_PATTERN, category)))
                .shouldHave(sizeGreaterThan(0))
                .shouldHave(allMatch("some elements are not displayed",
                        WebElement::isDisplayed));
    }

    public ElementsCollection getCarMarketModelsLinks(){
        return $x(SUBMENU_XPATH)
                .findAll(xpath(".//*[contains (@class, 'dropdown-column')][position()>=3]//a"))
                .shouldHave(sizeGreaterThan(0))
                .shouldHave(allMatch("some elements are not displayed",
                        WebElement::isDisplayed));
    }

    public void assertCarMarketHasCitiesLinks(List <String> cities){
        assertTextsFromTwoListsMatch(
                getSubmenuLinks("city"),
                cities);
    }

    public void assertCarMarketHasModelLinks(List <String> models){
        assertTextsFromTwoListsMatch(
                getCarMarketModelsLinks(),
                models);
    }

    public void assertSubmenuHasPricesLinks(){
        getSubmenuLinks("price");
    }

    public void assertHousesAndFlatsHasCitiesLinks(){
        getSubmenuLinks("bound");
    }

    public void assertHousesAndFlatsHasRoomsLinks(){
        getSubmenuLinks("room");
    }
}
