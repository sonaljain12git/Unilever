Feature: Validate Footer link Sitemap Redirection

  @sitemap @nexxus
  Scenario: Verifying Footer link Sitemap Redirection
    Given The site is Up and Running
    When user click on Footer link Sitemap
    Then Sitemap page should be displayed