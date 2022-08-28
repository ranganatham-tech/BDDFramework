Feature: Verify the Text 
  
  Scenario: Hover on Shop and Click on "Tide Free & Gentle" and Verify the Text "hypoallergenic"
    Given Open Browser for fourth test case
    When Hover on Shop Products for fourth test case
    Then Click on Tide Free and Gentle
    And Verify the Text "<Text>"

    Examples: 
      | Text  			|
      | hypoallergenic |
