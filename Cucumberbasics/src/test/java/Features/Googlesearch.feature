Feature: Google search functionality
  Scenario: To launch google and perform a search
    Given User navigates to "https://www.google.com"
    And User enters "hello world" in the search field
    And User clicks on search button
    Then Search results should be displayed successfully and user selects the top result