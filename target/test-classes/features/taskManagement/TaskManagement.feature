@taskManagement
Feature: Task Management

  Background: Click on header
    Given Click on Task Management

  @AddTaskManagement
  Scenario: Add Task Management Success
    When Click on button add
    When Click choose meeting
    And Enter task name is "Auto test"
    And Click choose priority
    And Click choose due date
    And Click choose pic
    And User click save button
    Then System shows success message

#    Then Verify new task management
  @EditTaskManagement
  Scenario Outline: Edit Task Management
    When User search <searchKey> to edit
    And Search result should be contain "<searchKey>"
    And Click on edit button by search key "<searchKey>"
    Then Task details screen should be display
    When Edit information of task
    And User click save button
    Then System shows success message should be "<message>"
    Then Verify that edit data success
    Examples:
      | searchKey | message                           |
      | MyEC      | Data has been saved successfully. |

  Scenario Outline: Delete Task Management
    When User search <searchKey> to delete
    And Search result should be contain "<searchKey>"
    And Click on delete button by search key "<searchKey>"
    Then Delete task popup should be display
    When User click confirm delete task
    Then System shows success message should be "<message>"
    Then Verify that delete data success
    Examples:
      | searchKey | message              |
      | MyEC      | Delete successfully! |
