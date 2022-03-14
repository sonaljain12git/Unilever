Feature: Validate the Olapic Gallery carousel rotation

  @olapicGallery @needToImprove
  Scenario: Verifying the Olapic Gallery carousel rotation
    Given The site is Up and Running
    When Gallery displayed then click on next arrow
    And Last image got changed
    Then click on previous arrow
    And Previous image got changed