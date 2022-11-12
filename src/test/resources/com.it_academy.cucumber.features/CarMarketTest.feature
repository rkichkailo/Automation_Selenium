Feature: As a logged in/not logged in user
  I want to see a sub menu
  On hovering the CarMarket menu section
  So I can navigate through the available categories

  @smoke
  Scenario: CarMarket sub menu should contain appropriate categories
    Given the user opens Onliner website
    Then main navigation menu is displayed
    When the user hover over the "Автобарахолка" menu section
    Then a sub menu appears
    Then user verifies CarMarket cities links are displayed
    |Минск|
    |Гомель|
    |Могилев|
    |Витебск|
    |Гродно|
    |Брест|
    And user verifies car models are displayed
    |Audi|
    |BMW |
    |Citroen|
    |Ford   |
    |Mazda|
    |Mercedes-Benz|
    |Nissan|
    |Opel  |
    |Peugeot|
    |Renault |
    |Toyota|
    |Volkswagen|
    And user verifies price categories are displayed

