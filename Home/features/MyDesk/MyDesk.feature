Feature: My Desk

Scenario: Verify whether all the listing pages are working in My Desk
Given I am logged in as: "GDQA-P2P@zycus.com", "YoDeHaCoPoBiBaIoAiWiYeQe8&7"
And I am on home page
When I click on hamburger icon
And I click on "My Desk" module
And I see all the listing page
And I click on "Quick Source Events" page
Then I should see details of the "Quick Source Events" page


