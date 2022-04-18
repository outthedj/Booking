Feature: Searching data for the hotel

  Scenario Outline: Searching for New-York hotel
    Given User is on Home Page
    When User inputs the name of the <Hotel> in the [Search] field
    And User clicks on the [Search] button
    Then The result of the <Hotel> and its <Rating> is displayed
    Examples:
      | Hotel                   |  | Rating |
      | "Park Lane New York" |  | "8,7"  |