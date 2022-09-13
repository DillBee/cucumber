Feature: Google Search

  #Scenario: Search google for edgewords
   # Given I am on the google homepage
  #  When I search for "Edgewords"
 #   Then "Edgewords" is the top result

  Scenario Outline: Search google for edgewords
    Given I am on the google homepage
    When I search for "<searchTerm>"
    Then "<searchTerm>" is the top result
    Examples:
      | searchTerm |
      | Edgewords  |
      | BBC        |
      | ITV        |


  Scenario: Inline table
    Given I am on the google homepage
    When I search for "Edgewords"
    Then I see in the results
      | url                                 | title                                                    |
      | https://www.edgewordstraining.co.uk | Edgewords Training - Automated Software Testing Training |
      | https://twitter.com › edgewords     | Edgewords - Twitter                                      |