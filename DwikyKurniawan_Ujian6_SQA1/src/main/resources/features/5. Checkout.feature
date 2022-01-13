Feature: Shop.sqa Checkout Page

Scenario: Testing checkout page
    When User go to page checkout
    And User input data form
    And User click checkbox term&conditions, and then click place order button
    Then User complete checkout item