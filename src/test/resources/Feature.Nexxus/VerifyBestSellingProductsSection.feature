Feature: Validate the best selling product section

  @ProductCarousel
  Scenario: Verifying best selling product section functionality
    Given The site is Up and Running
    When verifying the best selling product section visibility
    Then arrows should be working as expected