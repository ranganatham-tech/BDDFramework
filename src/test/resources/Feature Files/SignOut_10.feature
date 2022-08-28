Feature: Sign Out 

  Scenario: SignOut of the User
    Given Open the Website for tenth test case
    When Click Register
    Then Click Sign up now
    And Click Login
    Then Enter "<Email>" "<Password>"
    And Click Log In
    Then Click User name
    And Click Sign Out

    Examples: 
      |					 Email  					| Password	  |
      | ranganatham7026@gmail.com | Ranga@12345 |
