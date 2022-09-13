Feature: final



    Scenario: Login
      Given I am on the Edgewords Login Page
      When I enter my login details
      And I submit my login details
      Then I should be logged in


    Scenario: I check out an item as a logged in user.
      Given I log in
      And I am on the given products page
      When I add the item to my basket
      And I check out my basket
      Then I have bought the item