@taskManagement
Feature: Task Management

  @Background:
    Given Verify account text box and password text box
    When Enter account is "superuser" and password is "password"
    And Click button login
    Then Verify home page

#  @addTaskManagement
#  Scenario: Add Task Management
#  Given


  @editTaskManagement
  Scenario Outline: Edit Task Management
    Given User search <searchKey> to edit
    Then Search result should be contain <searchKey>
    When Click on edit button by search key <searchKey>
    Then Task details screen should be display
    And Edit information of task with priority <priority>
    And User click save button
    Then System shows success message <message>
    Examples:
      | searchKey | priority | message                           |
      | poly poly | High     | Data has been saved successfully. |
