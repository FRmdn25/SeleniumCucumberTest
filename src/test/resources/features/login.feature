Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters username "standard_user" and password "secret_sauce"
    And user clicks the login button
    Then user should be redirected to the inventory page