Feature: Validate the Visit Gallery button redirection to Olapic Gallery page

  @olapicGallery
  Scenario: Verifying the Visit Gallery button redirection to Olapic Gallery page
    Given The site is Up and Running
    When click on Visit Gallery button
    Then Olapic Gallery page is displayed
