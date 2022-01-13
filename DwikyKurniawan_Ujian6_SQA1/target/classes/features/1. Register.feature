Feature: Shop.sqa Register Page

Scenario: Testing register page
    Given User go to the website
    When User click my account page button
    And User input username, email, and password to register
    Then User can register to the website