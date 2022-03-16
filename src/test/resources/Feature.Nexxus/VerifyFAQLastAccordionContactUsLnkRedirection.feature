Feature: Validate Contact us link redirection from FAQ Page

  @contactUs @nexxus
  Scenario: Verifying Contact us link redirection from FAQ Page
    Given The site is Up and Running
    When user click on Footer link FAQ
    Then FAQ page should be displayed
    And Click on last Accordion and click on Contact us link
