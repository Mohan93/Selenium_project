Feature: Search and Place the order for Products

Scenario: Search Experiance for Product search in both home and offers page
Given: User is on GreenCart landing page
When: User search with sortname "Tom" and Extract actual Product
Then: User go and Search for same shortname in offers page 
And: Validate the product name in offer page with landing page