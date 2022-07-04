@myStore
Feature: Buying
  Scenario: Get logged buy goods use PrintScreen
    Given I am at mystore page with valid user account and go to sign in button
    When I sign in with data swiderus@interia.pl password jklopol1
    And Go to clothes and pick Hummingbird Printed Sweater
    And Check if discount is 20% pick size M pick amount 5 and add to cart
    And Pick address pick payment Pay by Check pick order with obligation to pay use PrintScreen
    Then Check order confirmation header