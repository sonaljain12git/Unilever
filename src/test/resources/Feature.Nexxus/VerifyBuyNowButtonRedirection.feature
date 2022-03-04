Feature: Validate the buy now button redirection

  @buyNow
  Scenario: Verifying buy now button functionality
    Given The site is Up and Running
    When verifying the best selling product section visibility
    And click on Buy Now button
    Then Find Online popup is displayed

  @buyNow
  Scenario: Verifying buy now functionality using vendor
    Given The site is Up and Running
    And click on Buy Now button
    When Select the vendor from the list
    Then it should redirect to the vendor page