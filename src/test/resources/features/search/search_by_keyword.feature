Feature: Search by keyword

  @posttextgroup
  Scenario: Searching for a term
    Given Sergey is researching things on the internet
    When he looks up "Cucumber"
    Then he should see information about "Cucumber"

