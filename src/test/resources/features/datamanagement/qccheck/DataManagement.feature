@Asset
Feature: Asset Management

  Background: Access QC check
    Given Click on asset Data Management
    And User click on project QC check1

  @60376
  Scenario Outline: [Asset] Can create an Asset without Asset Template successfully
    When User follow path to access screen
      | Asset |
    And User right click on a asset
    Then User select "<action>"
    And User input data to add asset
    When User click Add
    Then Success message should be "<message>"
    And User go to Activity Log screen
    Then User can see new log with correct data
      | Asset | Add | hoantb@vmodev.com | Success |
#    When User follow path to access screen
#      | Asset Management |
#      | Asset            |
#    And User delete newly created data
#    Then Success message should be "Delete successfully"
    Examples:
      | action  | message           |
      | Add New | Save successfully |

  @60377
  Scenario Outline: [Asset][Access Control] Can update access control of Asset successfully
    When User follow path to access screen
      | Asset |
    And User right click on a asset
    When User select "<action>"
    And User add resource "demo"
    And User Add entity "Bao.Ha@websynergies.com"
    When User click save
    Then Success message should be "<message>"
    Examples:
      | action         | message           |
      | Access Control | Save successfully |

  @60378
  Scenario Outline: [Asset][Add New] Can add an Asset Child without Asset Template successfully
    When User follow path to access screen
      | Asset |
    And User right click on a asset
    When User select "<action>"
    Then Parent name is asset which is selected
    And User input data to add asset
    When User click Add
    Then Success message should be "<message>"
    And User go to Activity Log screen
    Then User can see new log with correct data
      | Asset | Add | hoantb@vmodev.com | Success |
    Examples:
      | action  | message           |
      | Add New | Save successfully |