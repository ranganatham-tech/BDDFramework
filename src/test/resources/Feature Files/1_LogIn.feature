Feature: LogIn 

  Scenario: Login to the Website
    Given Open the Website
    When Click on the Register
    Then Click on the Sign up now
    And Click on Login
    Then Enter "<Email>" and "<Password>"
    And Click on Log In

    Examples: 
      | Email  										| 		Password 		| 
      | ranganatham7026@gmail.com |     Ranga@12345 |
