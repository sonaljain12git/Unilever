Feature: Validate Footer link FAQ Redirection

  @faq @nexxus
  Scenario: Verifying Footer link FAQ Redirection
    Given The site is Up and Running
    When user click on Footer link FAQ
    Then FAQ page should be displayed