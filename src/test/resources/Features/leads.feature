Feature: lead feature

  Background:
    Given user should be on login page
    When user enters valid userid and password
    And click in login button

  @lead
  Scenario Outline: <TCName>
    When user click on new lead link and fill mandatory form and save
    Then lead should be created successfully
    Examples:
    |TCName|
    |create_lead_TC03|
    #|create_lead_TC04|
    #|create_lead_TC05|


@stepsParam
  Scenario: create lead data driven
    When user click on new lead link and fill mandatory form and save and verify
    |Modi   | BJP     |
    |Gandhi | COngress|
    |Yogi   | BJP     |
    Then lead should be created successfully