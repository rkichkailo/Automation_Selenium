package com.it_academy.cucumber.steps;

import com.it_academy.homework6.onliner.page_object.Header;
import com.it_academy.homework6.onliner.page_object.HeaderSubMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.it_academy.homework6.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;

public class CarMarketSteps {

    Header header = new Header();
    HeaderSubMenu subMenu = new HeaderSubMenu();
    @Given("the user opens Onliner website")
    public void theUserOpensOnlinerWebsite() {
        navigateToOnlinerHomePage();
    }

    @Then("main navigation menu is displayed")
    public void mainNavigationMenuIsDisplayed() {
        header.assertMainNavigationBarIsDisplayed();
    }

    @When("the user hover over the {string} menu section")
    public void theUserHoverOverTheMenuSection(String name) {
        header.hoverOverMainNavigationBarLink(name);
    }

    @Then("a sub menu appears")
    public void aSubMenuAppears() {
        subMenu.assertSubMenuIsDisplayed();
    }

    @Then("user verifies CarMarket cities links are displayed")
    public void userVerifiesCarMarketCitiesLinksAreDisplayed(List <String> links) {
        subMenu.assertCarMarketHasCitiesLinks(links);
    }

    @And("user verifies car models are displayed")
    public void userVerifiesCarModelsAreDisplayed(List <String> links) {
        subMenu.assertCarMarketHasModelLinks(links);
    }

    @And("user verifies price categories are displayed")
    public void userVerifiesPriceCategoriesAreDisplayed() {
        subMenu.assertSubmenuHasPricesLinks();
    }
}
