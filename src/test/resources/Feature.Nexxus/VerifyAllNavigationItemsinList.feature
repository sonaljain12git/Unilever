Feature: Validate the header link validation

  @Header
  @nexxus
  Scenario: Verifying Header navigation link loading time
    Given The site is Up and Running
    When i try to get the header links
    Then All the header link should load within 5 second