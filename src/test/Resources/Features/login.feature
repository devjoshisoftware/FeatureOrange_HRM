
Feature: login
  @login
  Scenario: to check valid login functionality
    Given user is on home page
    When user enters valid credentials
    Then user should able to login successfully

  @invalidLogin
  Scenario Outline: to check invalid login functionality
    Given user is on home page
    When user use "<username>" and "<password>"
    Then user should able to see successful message"<login_message>"
    Examples:
      | username | password       | login_message            |
      | Admin    |                | Password cannot be empty |
      |          |                | Username cannot be empty |
      | Admin    | administration | Invalid credentials      |