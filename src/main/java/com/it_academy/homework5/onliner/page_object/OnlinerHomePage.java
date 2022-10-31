package com.it_academy.homework5.onliner.page_object;

import com.it_academy.homework5.onliner.framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class OnlinerHomePage extends BasePage {

    @FindBy (xpath = "//*[@class = 'b-main-navigation__text']]")
    private List<WebElement> headerItems;

    public List <String> getHeaderItemsText(){
        return waitForElementsVisible(headerItems)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
