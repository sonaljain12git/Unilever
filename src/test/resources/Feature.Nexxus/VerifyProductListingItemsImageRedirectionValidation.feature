Feature: Validate Product Listing Items image redirection from Product Listing page

  @productListing @nexxus
  Scenario: Verifying Product Listing Items image redirection from Product Listing page
    Given The site is Up and Running
    When navigate to Product Listing page
    And click on Product image in Product Listing Section
    Then Product Image should be redirected to PDP Page