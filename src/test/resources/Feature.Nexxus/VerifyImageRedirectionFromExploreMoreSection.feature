Feature: Validate the Image redirection from Explore More section

@exploreMore @nexxus
Scenario: Verifying the Image redirection from Explore More section
Given The site is Up and Running
When verifying the Explore More section visibility
And click on Image
Then user should be redirected to Product Listing page