Feature: Validate Where to buy link

  @link
  Scenario: Verifying Where to buy link redirection
    Given The site is Up and Running
    When User try to click on Where to Buy link
    Then user should be redirected to Products page