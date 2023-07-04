@taskManagement
Feature: Task Management
  Background: Click on header
    Given Click on Task Management

  Scenario: Add Task Management Success
    When Click on button add
    When Click choose meeting
    And Enter task name is "Auto test"
    And Click choose priority
    And Click choose due date
#    And Click choose pic
#    And Click choose reporter
#    Then Verify new task management
