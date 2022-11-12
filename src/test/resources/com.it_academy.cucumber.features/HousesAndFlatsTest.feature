Feature: As a logged in/not logged in user
  I want to see a sub menu
  On hovering the HousesAndFlats menu section
  So I can navigate through the available categories

  @smoke
  Scenario: HousesAndFlats sub menu should contain appropriate categories
    Given the user opens Onliner website
    Then main navigation menu is displayed
    When the user hover over the "Дома и квартиры" menu section
    Then a sub menu appears
    Then user verifies HouseAndFlats cities links are displayed
    And user verifies room models are present
    And user verifies price categories are displayed
