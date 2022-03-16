Feature: Validate Footer link Terms Of Use Redirection

  @termsOfUse @nexxus
  Scenario: Verifying Footer link Terms Of Use Redirection
    Given The site is Up and Running
    When user click on Footer link Terms of use
    Then Terms Of Use page should be opened into new tab