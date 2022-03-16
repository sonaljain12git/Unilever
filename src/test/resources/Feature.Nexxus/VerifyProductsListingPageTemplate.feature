Feature: Validate Product Listing page template

  @template @nexxus
  Scenario: Verifying Product Listing page template
    Given The site is Up and Running
    When navigate to Product Listing page
    Then all components should be displayed on Product Listing page