Feature: Home Page

  Background: User Navigate To Portfolio Site
    Given user has opened portfolio site
    When user enters valid username
    And user enters valid password
    When user clicks login button

  Scenario: Verify Portfolio Title
    Then user validates portfolio title