Feature: Validate Web Inquiry Contact Us form Submission

  @webInquiry @nexxus @contactUs
  Scenario Outline: Verifying Web Inquiry Contact Us form Submission for valid data
    Given The site is Up and Running
    When user click on Footer link Contact us
    Then Click on Web Inquiry Accordion and check the Web Inquiry Form
    And Fill the data in form and click on Contact Us button <firstname>,<lastname>,<email>,<streetAddress1>,<City>,<postalCode> and <comments>
    Then user should get message based on <Criteria> Criteria

    Examples:

      | firstname | lastname | email          |streetAddress1    |city      | postalCode |comments                | Criteria |
      | Test      | Testing1 | test@gmail.com |B-13 Basant Vihar | New York | 12120      |Let me know the details | Valid |