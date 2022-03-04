Feature: Validate global search suggestion

  @search
  Scenario: Verifying global search suggestions visibility and redirection
    Given The site is Up and Running
    When try to write and click on search icon
    Then search Results should be displayed
    And if click on search result, user should be redirected to respective page