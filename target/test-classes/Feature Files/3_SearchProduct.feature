Feature: Search a Product

  Scenario: Search Sensitive Liquid on Search bar
    Given First Open Browser
    When Search the product "<value>"
    Then Click on Search button
    And Click on Second Result

    Examples: 
      | value 					 |
      | Sensitive Liquid |
