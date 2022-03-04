Feature: Validate logo redirection on the Home Page

  @logo
  Scenario: Verifying logo redirection on the Home Page
    Given The site is Up and Running
    When verifying logo
    Then user should be redirected to Home page, if click on logo