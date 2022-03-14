Feature: Validate Footer link Newsletter Sign Up Redirection

  @signup
  Scenario: Verifying Footer link Newsletter Sign Up Redirection to signup form
    Given The site is Up and Running
    When user click on Footer link Newsletter Sign Up link
    Then Signup page and Signup form should on displayed