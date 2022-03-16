Feature: Validate Footer link Privacy Policy Redirection

  @privacyPolicy @nexxus
  Scenario: Verifying Footer link Privacy Policy Redirection
    Given The site is Up and Running
    When user click on Footer link Privacy Policy
    Then Privacy Policy page should be opened into new tab