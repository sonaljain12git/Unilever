Feature: Validate Web Inquiry Form Redirection from Contact Us Page

  @webInquiry @nexxus
  Scenario: Verifying Web Inquiry Form Redirection from Contact Us Page
    Given The site is Up and Running
    When user click on Footer link Contact us
    Then Contact us page should be displayed
    And Click on Web Inquiry Accordion and check the Web Inquiry Form
