Feature: Validate accordion on FAQ page

  @faq @needToUpdate
  Scenario: Verifying accordion on FAQ page
    Given The site is Up and Running
    When user click on Footer link FAQ
    And FAQ page should be displayed
    When i try to click on + icon
    Then the answer should be visible
    When i try to click on cross * icon
    Then the answer should be hidden again