Feature: Validate Footer link Contact us link Redirection

  @contactUs @nexxus
  Scenario: Verifying Footer link Contact Us Redirection
    Given The site is Up and Running
    When user click on Footer link Contact us
    Then Contact us page should be displayed