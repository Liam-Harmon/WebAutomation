Feature: Projects

  Background:
    Given user has opened portfolio site
    Then user checks portfolio url

  Scenario: Validate Projects Page
    When user clicks on projects in top nav
    Then user validates projects page url
    And user validates projects page title
    And user sees list of projects displayed

  Scenario: Validate Portfolio Project Contents
    When user clicks on projects in top nav
    Then user validates project contents

  Scenario: Validate Add Projects Functionality
    When user clicks on projects in top nav
    And user clicks on Add Projects
    Then user enters project name
    And user enters project description
    And user enters github link
    And user enters tags
    And user enters image url
    And user enters image alt text
    When user clicks save changes
    Then user validates newly added project