Feature: Shop.sqa Add To Cart

Scenario: Testing add to cart
    When User go to page search and input glass
    And User choose sunglasses
    And pick color, size, and then click add to cart button
    Then User can add glass to cart