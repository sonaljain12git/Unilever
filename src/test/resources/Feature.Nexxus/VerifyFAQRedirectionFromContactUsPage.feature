Feature: Validate FAQ link redirection from Contact Us Page

  @faq @nexxus
  Scenario: Verifying FAQ link redirection from Contact Us Page
    Given The site is Up and Running
    When user click on Footer link Contact us
    Then Contact us page should be displayed
    And Click on FAQ Accordion and click on FAQ link
