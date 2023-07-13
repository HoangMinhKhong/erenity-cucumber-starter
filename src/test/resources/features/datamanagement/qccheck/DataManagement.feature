@Asset
Feature: Asset Management

  Background: Access AHI Main
    Given Click on asset Data Management
    And User click on project QC check1

  @60376
  Scenario: [Asset] Can create an Asset without Asset Template successfully
    When User follow path to access screen
      | Asset |

#    Then Search result should be contain "<searchKey>"
#    When Click on edit button by search key "<searchKey>"
#    Then Task details screen should be display
#    And Edit information of task with priority "<priority>"
#    And User click save button
#    Then System shows success message "<message>"
#    Examples:
#      | searchKey | priority | message                           |
#      | hehe      | High     | Data has been saved successfully. |
