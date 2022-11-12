package com.it_academy.cucumber.steps;

import com.it_academy.homework6.onliner.page_object.HeaderSubMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class HousesAndFlatsSteps {
    HeaderSubMenu subMenu = new HeaderSubMenu();

    @Then("user verifies HouseAndFlats cities links are displayed")
    public void userVerifiesHouseAndFlatsCitiesLinksAreDisplayed() {
        subMenu.assertHousesAndFlatsHasCitiesLinks();
    }

    @And("user verifies room models are present")
    public void userVerifiesRoomModelsArePresent() {
        subMenu.assertHousesAndFlatsHasRoomsLinks();
    }
}
