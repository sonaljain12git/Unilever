Feature: Validate signup popup drawer functionality

  @signup
  Scenario: Verifying signup popup drawer functionality
    Given The site is Up and Running
    When SignUp popup is visible
    And enter email and click on Continue button
    Then Signup page and Signup form should on displayed