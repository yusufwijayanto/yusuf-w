Feature: Shop.sqa Add Cart From Compare Page

Scenario: Testing add cart from compare page
    When User go to page search and input item
    And User click compare page button
    And User pick color, size, and then click add to cart button
    Then User can add item to cart from compare page