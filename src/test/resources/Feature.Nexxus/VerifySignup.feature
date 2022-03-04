Feature: Validate signup form

  @signup
  Scenario: Verifying signup functionality
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details and submit
    Then it should submit and redirect to thank you page.

  @signUp
  Scenario: Verifying signup functionality without entering name
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details except name and submit
    Then it should display validation message with respect to name