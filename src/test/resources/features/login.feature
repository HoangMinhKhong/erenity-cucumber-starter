Feature: Login

  @login
  Scenario: Login
    Given Verify account text box and password text box
    When Enter account is "superuser" and password is "password"
    And Click button login
    Then Verify home page