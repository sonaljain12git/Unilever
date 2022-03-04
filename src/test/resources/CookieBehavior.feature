Feature: Validate the Cookie consent and behavior of site


  @CookieConsent @P0  @All  @popup  @thailand  @magnum  @brazil @finland
  Scenario: Verifying behavior of the site when cookie accepted
    Given The site is Up and navigate to cookie banner in footer
    When click on the accept button
    And again load the site
    Then check the popup should not be visible again


