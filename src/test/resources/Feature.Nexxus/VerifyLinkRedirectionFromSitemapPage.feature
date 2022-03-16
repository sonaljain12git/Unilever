Feature: Validate link Redirection from Sitemap Page

  @sitemap @nexxus
  Scenario: Verifying link Redirection from Sitemap Page
    Given The site is Up and Running
    When user click on Footer link Sitemap
    Then Sitemap page should be displayed
    And user click on link which is on Sitemap page
    Then user should be redirected to correct page