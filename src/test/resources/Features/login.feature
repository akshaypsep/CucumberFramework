@test
Feature: Login feature

  Background:
    Given user should be on login page


  @sirftum
  Scenario: valid_login_TC01
    When user enters valid userid and password
    And click in login button
    Then user should be navigated to home page
    And user can see the logout

  @modi @sanity @smoke
  Scenario: invalid_login_TC02
    When user enters invalid userid and password
    And click in login button
    Then user should be navigated to login page
    And user can see the error message

  @datadriven
  Scenario Outline: Invalid login data driven
    When user enters invalid userid as "<userid>" and password as "<password>"
    And click in login button
    Then user should be navigated to login page
    And user can see the error message
  Examples:
    |userid | password |
    |admin1 | pwd1     |
    |admin2 | pwd2     |
    |admin3 | pwd3     |

