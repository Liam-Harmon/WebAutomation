Feature: Projects

  Background:
    Given user has opened portfolio site
    Then user checks portfolio url
    When user clicks on projects in top nav

    Scenario: Validate Projects Page
      Then user validates projects page url
      And user validates projects page title
      And user sees list of projects displayed
