@taskManagement
Feature: Task Management

  Background: Click on header
    Given Click on Task Management

#  @AddTaskManagement
#  Scenario: Add Task Management Success
#    When Click on button add
#    When Click choose meeting
#    And Enter task name is "Auto test"
#    And Click choose priority
#    And Click choose due date
#    And Click choose pic
#    And User click save button
#    Then System shows success message

#    Then Verify new task management

  @EditTaskManagement
  Scenario Outline: Edit Task Management
    Given User search "<searchKey>" to edit
    Then Search result should be contain "<searchKey>"
    When Click on edit button by search key "<searchKey>"
    Then Task details screen should be display
    And Edit information of task
    And User click save button
    Then System shows success message should be "<message>"
    Examples:
      | searchKey | message                           |
      | MyEC      | Data has been saved successfully. |

  @DeleteTask
  Scenario Outline: Delete Task Management
    Given User search "<searchKey>" to edit
    Then Search result should be contain "<searchKey>"
    When Click on delete button by search key "<searchKey>"
    Then Delete task popup should be display
    And User click confirm delete task
    Then System shows success message should be "<message>"
    Examples:
      | searchKey | message                           |
      | MyEC      | Data has been saved successfully. |
