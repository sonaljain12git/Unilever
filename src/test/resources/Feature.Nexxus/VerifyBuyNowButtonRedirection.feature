Feature: Validate the buy now button redirection

  @buyNow @nexxus
  Scenario: Verifying buy now button functionality
    Given The site is Up and Running
    When verifying the best selling product section visibility
    And click on Buy Now button
    Then Find Online popup is displayed
    And click on cross button on popup

  @buyNow @nexxus
  Scenario: Verifying buy now functionality using vendor
    Given The site is Up and Running
    And click on Buy Now button
    When Select the vendor from the list
    Then it should redirect to the vendor page