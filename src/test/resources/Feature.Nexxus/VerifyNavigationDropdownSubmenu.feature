Feature: Validate Navigation Dropdown submenu
  @submenu @navigation @nexxus
  Scenario: Verifying navigation item which having dropdown
    Given The site is Up and Running
    When Navigation item having dropdown and user click on it
    Then Submenu items should be visible and clickable