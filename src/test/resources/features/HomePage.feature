Feature: Home Page

  Background:
    Given user has opened portfolio site
    Then user checks portfolio url

  Scenario: User Validates My Portfolio Logo
    When user clicks on My Portfolio Logo
    Then user checks portfolio url