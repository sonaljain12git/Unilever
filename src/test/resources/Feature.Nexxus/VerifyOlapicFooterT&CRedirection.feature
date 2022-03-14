Feature: Validate the Olapic Gallery Footer-T&C link redirection to UGC Policy page

  @olapicGallery
  Scenario: Verifying the Olapic Gallery Footer-T&C link redirection to UGC Policy page
    Given The site is Up and Running
    When click on Term and Conditions link which is in Olapic gallery footer
    Then UGC Policy page is displayed