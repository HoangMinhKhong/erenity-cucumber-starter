#@taskManagement2
#Feature: Task Management
#
#  Background: Login to site
#    Given Click on Task Management
#
#  @EditTaskManagement
#  Scenario Outline: Edit Task Management
#    Given User search "<searchKey>" to edit
#    Then Search result should be contain "<searchKey>"
#    When Click on edit button by search key "<searchKey>"
#    Then Task details screen should be display
#    And Edit information of task with priority "<priority>"
#    And User click save button
#    Then System shows success message "<message>"
#    Examples:
#      | searchKey | priority | message                           |
#      | hehe      | High     | Data has been saved successfully. |
