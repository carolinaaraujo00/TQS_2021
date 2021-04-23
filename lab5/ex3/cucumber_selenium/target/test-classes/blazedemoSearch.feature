Feature: Search in Blazedemo

  Scenario: Seek for Selenium-Jupiter documentation
    When I navigate to "https://blazedemo.com/"
    And I choose departure "Philadelphia"
    And I choose destination "New York"
    And I press Find Flights
    And I should be shown results including "Lufthansa"
    And I press Choose Flight 4346
    Then I finish the purchase